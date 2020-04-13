package com.foodforcharity.app.web.controller;

import java.util.concurrent.ExecutionException;

import com.foodforcharity.app.domain.constant.Allergen;
import com.foodforcharity.app.domain.constant.Cuisine;
import com.foodforcharity.app.domain.constant.MealType;
import com.foodforcharity.app.domain.constant.SpiceLevel;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Mediator;
import com.foodforcharity.app.usecase.profile.addmenu.AddMenuCommand;
import com.foodforcharity.app.usecase.profile.deletemenuitem.DeleteMenuItemCommand;
import com.foodforcharity.app.usecase.profile.modifymenuitem.ModifyMenuItemCommand;
import com.foodforcharity.app.web.model.MenuModel;
import com.foodforcharity.app.web.model.RequestModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/donor")
// @PreAuthorize("Donor")
public class DonorController extends AbstractController {

    @Autowired
    DonorController(Mediator mediator) {
        super(mediator);
    }

    @GetMapping(value = "/home")
    public String getDoneeHomepageView(Model model) {
        //model.addAttribute("PersonName", Person)
        return "donor/donor-homepage";
    }

    @GetMapping(value = "/menu")
    public String getMenu(Model model) {
        //model.addAttribute("menu", new MenuModel(id));
        return "redirect:/menu";
    }

    @PostMapping(value = "/menu")
    public String addMenuItem(@ModelAttribute MenuModel menuModel, Model model) throws ExecutionException {

        Response<Void> response;

        AddMenuCommand addMenuCommand = new AddMenuCommand(getPersonId(), menuModel.getFoodName(),
                menuModel.getDescriptionText(), menuModel.getOriginalPrice(), menuModel.getMealForNPeople(),
                menuModel.getQuantityAvailable(), SpiceLevel.valueOf(menuModel.getSpiceLevel()),
                MealType.valueOf(menuModel.getMealType()), Cuisine.valueOf(menuModel.getCuisine()),
                menuModel.getAllergen());

        response = publishAsync(addMenuCommand).get();

        if (!response.success()) {
            model.addAttribute("IsError", true);
            model.addAttribute("ErrorMessage", response.getError().getMessage());
            model.addAttribute("menuModel", menuModel);
        } else {
            model.addAttribute("Success", "Menu Item Added Successfully!");
        }
        return "redirect:/";

    }

    @PutMapping(value = "/menu")
    public String updateMenuItem(@RequestParam(value = "foodId", required = true) long foodId,
            @ModelAttribute MenuModel menuModel, Model model) throws ExecutionException {
        Response<Void> response;

        ModifyMenuItemCommand modifyMenuItemCommand = new ModifyMenuItemCommand(getPersonId(), foodId);

        response = publishAsync(modifyMenuItemCommand).get();

        if(!response.success()){
            model.addAttribute("IsError", true);
            model.addAttribute("ErrorMessage", response.getError().getMessage());
            model.addAttribute("menuModel", menuModel);
        }
        else{
            model.addAttribute("Success", "Menu Item Changed Successfully!");
        }
        return "redirect:/";

    }

    @DeleteMapping(value="/menu")
    public String deleteMenuItem(@RequestParam(value = "foodId") long foodId, 
                            @ModelAttribute MenuModel menuModel, Model model) throws ExecutionException {

        Response<Void> response;

        DeleteMenuItemCommand deleteMenuItemCommand = new DeleteMenuItemCommand(getPersonId(), foodId);

        response = publishAsync(deleteMenuItemCommand).get();

        if(!response.success()){
            model.addAttribute("IsError", true);
            model.addAttribute("ErrorMessage", response.getError().getMessage());
            model.addAttribute("menuModel", menuModel);
        }
        else{
            model.addAttribute("Success", "Menu Item Deleted Successfully!");
        }
        return "redirect:/";
    }

    



}