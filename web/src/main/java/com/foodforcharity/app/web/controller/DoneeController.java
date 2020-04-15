package com.foodforcharity.app.web.controller;

import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Mediator;
import com.foodforcharity.app.usecase.profile.selectpreferences.SelectPreferencesCommand;
import com.foodforcharity.app.web.model.FoodPreferences;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/donee")
// @PreAuthorize("Donee")
public class DoneeController extends AbstractController {

    @Autowired
    DoneeController(Mediator mediator) {
        super(mediator);
    }

    @GetMapping("/home")
    public String getDoneeHomepageView(Model model) {
        // model.addAttribute("userDetails", userDetails);
        // model.addAttribute("FoodAvailable", FoodAvailable);
        return "donee/donee-homepage";
    }

    // --------------View Profile----------------

    @GetMapping("profile")
    public String getProfileView(Model model) {
        // model.addAttribute("UserProfile", new Profile());
        return "donee/view-profile";
    }

    @PutMapping("profile")
    public String changeProfileInfo(Model model) {

        // Response<Void> response;

        return "redirect:/";
    }

    // --------------Food Preferences----------------

    @GetMapping(value = "/food-preferences")
    public String getFoodPreferencesView(FoodPreferences foodPreferences, Model model) {
        model.addAttribute("foodPreferences", new FoodPreferences());
        return "donee/food-preferences";
    }

    @GetMapping(value = "/edit-food-preferences")
    public String getEditFoodPreferencesView(FoodPreferences foodPreferences, Model model) {
        model.addAttribute("foodPreferences", new FoodPreferences());
        return "donee/edit-food-preferences";
    }

    @PostMapping(value = "/edit-food-preferences")
    public String selectPreferences(@Valid FoodPreferences foodPreferences, BindingResult result, Model model) throws ExecutionException {

        if(result.hasErrors()){
            return "donee/food-preferences";
        }
        
        Response<Void> response;

        
        SelectPreferencesCommand selectPreferencesCommand = new SelectPreferencesCommand(getPersonId());

        response = publishAsync(selectPreferencesCommand).get();

        if (!response.success()) {
            foodPreferences.setError(response.getError());
        } else {
            foodPreferences = new FoodPreferences();
            foodPreferences.setSuccess(true);
        }
        return getFoodPreferencesView(new FoodPreferences(), model);
    }

    // @PutMapping("FoodPreferences")
    // public String modifyPreferences(@ModelAttribute FoodPreferences foodPreferences, Model model){

    //     Response<Void> response;

    //     SelectPreferencesCommand selectPreferencesCommand = new SelectPreferencesCommand(getPersonId());

    //     response = publishAsync(selectPreferencesCommand).get();

    //     if(!response.success()){
    //         model.addAttribute("IsError", true);
    //         model.addAttribute("ErrorMessage", response.getError().getMessage());
    //     }
    //     else {
    //         model.addAttribute("Success", "Food Preferences Modified Successfully!");
    //     }
    //     return "redirect:/";
    // }

    // @DeleteMapping("FoodPreferences")
    // public String deletePreferences(@ModelAttribute FoodPreferences foodPreferences, Model model){

    //     Response<Void> response;

    //     SelectPreferencesCommand selectPreferencesCommand = new SelectPreferencesCommand(getPersonId());

    //     response = publishAsync(selectPreferencesCommand).get();

    //     if(!response.success()){
    //         model.addAttribute("IsError", true);
    //         model.addAttribute("ErrorMessage", response.getError().getMessage());
    //     }

    //     model.addAttribute("Success", "Food Preferences Deleted Successfully!");

    //     return "redirect:/";
    // }

    // --------------Food Requests----------------

    @GetMapping("FoodRequests")
    public String getFoodRequestsView(Model model) {
        // model.addAttribute("food", Food());
        return "donee/Food-request";
    }

    @GetMapping("FoodRequest/{foodId}")
    public String getFoodRequestView(@PathVariable long id, Model model) {
        model.addAttribute("FoodRequest", new FoodPreferences());
        return "redirect:/";

        // @GetMapping("FoodRequest/{foodId}")
        // public String getFoodRequestView(@PathVariable long id, Model model) {
        // model.addAttribute("FoodRequest", new CreateRequest());
        // return "redirect:/";

    }

    // @PostMapping("FoodRequest")
    // public String createFoodRequest(@PathVariable("doneeId") long doneeId,
    // @RequestParam(value = "donorId") long donorId, Model model) throws
    // ExecutionException {

    // CreateRequestCommand createRequestCommand = new CreateRequestCommand(doneeId,
    // donorId);

    // Response<Void> response = publishAsync(createRequestCommand).get();

    // if (!response.success()) {
    // model.addAttribute("IsError", true);
    // model.addAttribute("ErrorMessage", response.getError().getMessage());
    // } else {
    // model.addAttribute("Success", "Food have been requested!");
    // }
    // return "redirect:/";
    // }

}