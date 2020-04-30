package com.foodforcharity.app.web.controller;

import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Mediator;
import com.foodforcharity.app.usecase.foodreservation.createrequest.CreateRequestCommand;
import com.foodforcharity.app.usecase.profile.selectpreferences.SelectPreferencesCommand;
import com.foodforcharity.app.web.model.FoodPreferences;
import com.foodforcharity.app.web.model.FoodRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

import static com.foodforcharity.app.web.model.Request.withSuccess;

@Controller
@RequestMapping("/donee")
@PreAuthorize(value = "hasAuthority('Donee')")
public class DoneeController extends AbstractController {

    @Autowired
    DoneeController(Mediator mediator) {
        super(mediator);
    }

    @GetMapping("/home")
    public String getDoneeHomepageView() {

        // Send fooddtos to the homepage

        return "donee/donee-homepage";
    }

    @PostMapping("/home")
    public String makeFoodRequest(@RequestParam(value = "donorId", required = false) Optional<Long> donorId,
            FoodRequest request, Model model) throws ExecutionException {

        CreateRequestCommand command = new CreateRequestCommand(getPersonId(), donorId.get());

        Response<Void> response = publishAsync(command).get();

        if (response.hasError()) {
            request.setError(response.getError());
            return "redirect:/";
        }

        request.setSuccess(true);

        model.addAttribute("success", withSuccess(request));

        return "redirect:/";
    }

    // --------------View Profile----------------

    @GetMapping("profile")
    public String getProfileView() {
        return "donee/view-profile";
    }

    @PutMapping("profile")
    public String changeProfileInfo() {

        // Response<Void> response;

        return "redirect:/";
    }

    // --------------Food Preferences----------------

    @GetMapping(value = "/food-preferences")
    public String getFoodPreferencesView(FoodPreferences foodPreferences) {
        return "donee/food-preferences";
    }

    @GetMapping(value = "/edit-food-preferences")
    public String getEditFoodPreferencesView(FoodPreferences foodPreferences) {
        return "donee/edit-food-preferences";
    }

    @PostMapping(value = "/edit-food-preferences")
    public String selectPreferences(@Valid FoodPreferences foodPreferences, BindingResult result, Model model)
            throws ExecutionException {

    //     if (result.hasErrors()) {
    //         return "donee/food-preferences";
    //     }

    //     SelectPreferencesCommand selectPreferencesCommand = new SelectPreferencesCommand(getPersonId());

    //     Response<Void> response = publishAsync(selectPreferencesCommand).get();

    //     if (!response.success()) {
    //         foodPreferences.setError(response.getError());
    //     } else {
    //         foodPreferences = new FoodPreferences();
    //         foodPreferences.setSuccess(true);
    //     }
    //     return getFoodPreferencesView(new FoodPreferences());
    // }

    // @PutMapping("FoodPreferences")
    // public String modifyPreferences(@ModelAttribute FoodPreferences
    // foodPreferences, Model model){

    // Response<Void> response;

    // SelectPreferencesCommand selectPreferencesCommand = new
    // SelectPreferencesCommand(getPersonId());

    // response = publishAsync(selectPreferencesCommand).get();

    // if(!response.success()){
    // model.addAttribute("IsError", true);
    // model.addAttribute("ErrorMessage", response.getError().getMessage());
    // }
    // else {
    // model.addAttribute("Success", "Food Preferences Modified Successfully!");
    // }
    // return "redirect:/";
    // }

    // @DeleteMapping("FoodPreferences")
    // public String deletePreferences(@ModelAttribute FoodPreferences
    // foodPreferences, Model model){

    // Response<Void> response;

    // SelectPreferencesCommand selectPreferencesCommand = new
    // SelectPreferencesCommand(getPersonId());

    // response = publishAsync(selectPreferencesCommand).get();

    // if(!response.success()){
    // model.addAttribute("IsError", true);
    // model.addAttribute("ErrorMessage", response.getError().getMessage());
    // }

    // model.addAttribute("Success", "Food Preferences Deleted Successfully!");

    // return "redirect:/";
    // }

    // --------------Food Requests----------------

    @GetMapping("FoodRequests")
    public String getFoodRequestsView(Model model) {
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