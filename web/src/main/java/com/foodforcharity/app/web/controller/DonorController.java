package com.foodforcharity.app.web.controller;

import static com.foodforcharity.app.web.model.Request.withSuccess;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import com.foodforcharity.app.domain.constant.Cuisine;
import com.foodforcharity.app.domain.constant.MealType;
import com.foodforcharity.app.domain.constant.SpiceLevel;
import com.foodforcharity.app.domain.entity.Food;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Mediator;
import com.foodforcharity.app.usecase.profile.addmenu.AddMenuCommand;
import com.foodforcharity.app.usecase.profile.deletemenuitem.DeleteMenuItemCommand;
import com.foodforcharity.app.usecase.profile.getmenuitem.GetMenuItemCommand;
import com.foodforcharity.app.usecase.profile.modifymenuitem.ModifyMenuItemCommand;
import com.foodforcharity.app.web.dto.FoodDto;
import com.foodforcharity.app.web.model.MenuModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/donor")
@PreAuthorize(value = "hasAuthority('Donor')")
public class DonorController extends AbstractController {

    @Autowired
    DonorController(Mediator mediator) {
        super(mediator);
    }

    @GetMapping(value = "/home")
    public String getDonorHomepageView() {
        return "donor/donor-homepage";
    }

    @GetMapping(value = "/menu")
    public String getMenu(MenuModel menuModel) {
        return "donor/menu-items";
    }

    @GetMapping(value = "/edit-menu")
    public String getEditMenu(MenuModel menuModel,
            @RequestParam(value = "foodId", required = false) Optional<Long> foodId, Model model)
            throws ExecutionException {

        if (foodId.isPresent()) {
            GetMenuItemCommand command = new GetMenuItemCommand(getPersonId(), foodId.get());

            Response<Food> response = publishAsync(command).get();

            if (response.hasError()) {
                menuModel.setError(response.getError());
                return "redirect:/";
            }

            FoodDto food = new FoodDto(response.getResponse());

            menuModel.setSuccess(true);
            model.addAttribute("menuModel", food);
        } else {
            model.addAttribute("menuModel", new MenuModel());
        }

        return "donor/edit-menu";
    }

    @PostMapping(value = "/edit-menu")
    public String addMenuItem(@Valid MenuModel menuModel, BindingResult result, Model model) throws ExecutionException {

        if (result.hasErrors()) {
            return "edit-menu";
        }

        AddMenuCommand addMenuCommand = new AddMenuCommand(getPersonId(), menuModel.getFoodName(),
                menuModel.getDescriptionText(), menuModel.getOriginalPrice(), menuModel.getMealForNPeople(),
                menuModel.getQuantityAvailable(), SpiceLevel.valueOf(menuModel.getSpiceLevel()),
                MealType.valueOf(menuModel.getMealType()), Cuisine.valueOf(menuModel.getCuisine()),
                menuModel.getAllergen());

        Response<Void> response = publishAsync(addMenuCommand).get();

        if (response.hasError()) {
            menuModel.setError(response.getError());
            return "reditrect:/";
        }
        model.addAttribute("success", withSuccess(menuModel));
        return "menu";

    }

    @PutMapping(value = "/edit-menu")
    public String updateMenuItem(@RequestParam(value = "itemId", required = true) long itemId,
            @Valid MenuModel menuModel, BindingResult result, Model model) throws ExecutionException {

        if (result.hasErrors()) {
            return "edit-menu";
        }

        ModifyMenuItemCommand modifyMenuItemCommand = new ModifyMenuItemCommand(getPersonId(), itemId);

        Response<Void> response = publishAsync(modifyMenuItemCommand).get();

        if (response.hasError()) {
            menuModel.setError(response.getError());
            return "reditrect:/";
        }
        model.addAttribute("success", withSuccess(menuModel));
        return "menu";

    }

    @DeleteMapping(value = "/delete-menu")
    public String deleteMenuItem(@RequestParam(value = "foodId", required = true) long foodId,
            @Valid MenuModel menuModel, Model model) throws ExecutionException {

        DeleteMenuItemCommand deleteMenuItemCommand = new DeleteMenuItemCommand(getPersonId(), foodId);

        Response<Void> response = publishAsync(deleteMenuItemCommand).get();

        if (response.hasError()) {
            menuModel.setError(response.getError());
            return "menu";
        }
        model.addAttribute("success", withSuccess(menuModel));
        return "menu";
    }

}