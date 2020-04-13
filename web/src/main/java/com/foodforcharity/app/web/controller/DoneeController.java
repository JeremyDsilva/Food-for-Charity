// package com.foodforcharity.app.web.controller;

// import java.util.List;
// import java.util.Optional;
// import java.util.concurrent.ExecutionException;

// import com.foodforcharity.app.domain.constant.Allergen;
// import com.foodforcharity.app.domain.constant.Cuisine;
// import com.foodforcharity.app.domain.constant.SpiceLevel;
// import com.foodforcharity.app.domain.reponse.Response;
// import com.foodforcharity.app.domain.security.PersonDetails;
// import com.foodforcharity.app.mediator.Mediator;
// import com.foodforcharity.app.usecase.foodreservation.createrequest.CreateRequestCommand;
// import com.foodforcharity.app.usecase.profile.selectpreferences.SelectPreferencesCommand;
// import com.foodforcharity.app.usecase.profile.selectpreferences.SelectPreferencesCommand.Range;
// import com.foodforcharity.app.web.model.FoodPreferences;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// @Controller
// @RequestMapping("/donee")
// // @PreAuthorize("Donee")
// public class DoneeController extends AbstractController {

//     @Autowired
//     DoneeController(Mediator mediator) {
//         super(mediator);
//     }

//     @GetMapping("/home")
//     public String getDoneeHomepageView(Model model) {
//         // model.addAttribute("PersonName", );
//         // model.addAttribute("FoodAvailable", FoodAvailable);
//         return "donee/donee-homepage";
//     }

//     // --------------View Profile----------------

//     @GetMapping("profile/{profileId}")
//     public String getProfileView(@PathVariable long id, Model model){
//         //model.addAttribute("UserProfile", new Profile());
//         return "donee/view-profile";
//     }

//     @PutMapping("profile/{profileId}")
//     public String changeProfileInfo(@PathVariable long id, Model model){

//        // Response<Void> response;



//         return "redirect:/";
//     }

//     // --------------Food Preferences----------------

//     @GetMapping("FoodPreferences/{id}")
//     public String getFoodPreferencesView(@PathVariable long id, Model model) {
//         model.addAttribute("createRequest", new FoodPreferences());
//         return "donee/food-preferences";
//     }

//     @PostMapping("FoodPreferencess")
//     public String selectPreferences(@ModelAttribute FoodPreferences foodPreferences, Model model) {

//         Response<Void> response;

//         SelectPreferencesCommand selectPreferencesCommand = new SelectPreferencesCommand(getPersonId());

//         response = publishAsync(selectPreferencesCommand).get();

//         if (!response.success()) {
//             model.addAttribute("IsError", true);
//             model.addAttribute("ErrorMessage", response.getError().getMessage());
//         } else {
//             model.addAttribute("Success", "Food Preferences Selected Successfully!");
//         }
//         return "redirect:/";
//     }

//     @PutMapping("FoodPreferences")
//     public String modifyPreferences(@ModelAttribute FoodPreferences foodPreferences, Model model){

//         Response<Void> response;

//         SelectPreferencesCommand selectPreferencesCommand = new SelectPreferencesCommand(getPersonId());

//         response = publishAsync(selectPreferencesCommand).get();

//         if(!response.success()){
//             model.addAttribute("IsError", true);
//             model.addAttribute("ErrorMessage", response.getError().getMessage());
//         }
//         else {
//             model.addAttribute("Success", "Food Preferences Modified Successfully!");
//         }
//         return "redirect:/";
//     }

//     @DeleteMapping("FoodPreferences")
//     public String deletePreferences(@ModelAttribute FoodPreferences foodPreferences, Model model){

//         Response<Void> response;

//         SelectPreferencesCommand selectPreferencesCommand = new SelectPreferencesCommand(getPersonId());

//         response = publishAsync(selectPreferencesCommand).get();

//         if(!response.success()){
//             model.addAttribute("IsError", true);
//             model.addAttribute("ErrorMessage", response.getError().getMessage());
//         }

//         model.addAttribute("Success", "Food Preferences Deleted Successfully!");

//         return "redirect:/";
//     }

//     // --------------Food Requests----------------

//     @GetMapping("FoodRequests")
//     public String getFoodRequestsView(Model model) {
//         // model.addAttribute("food", Food());
//         return "donee/Food-request";
//     }

//     @GetMapping("FoodRequest/{foodId}")
//     public String getFoodRequestView(@PathVariable long id, Model model) {
//         model.addAttribute("FoodRequest", new FoodPreferences());
//         return "redirect:/";

//     }

//     @PostMapping("FoodRequest")
//     public String createFoodRequest(@PathVariable("doneeId") long doneeId,
//             @RequestParam(value = "donorId") long donorId, Model model) throws ExecutionException {

//         Response<Void> response;

//         CreateRequestCommand createRequestCommand = new CreateRequestCommand(doneeId, donorId);

//         response = publishAsync(createRequestCommand).get();

//         if (!response.success()) {
//             model.addAttribute("IsError", true);
//             model.addAttribute("ErrorMessage", response.getError().getMessage());
//         } else {
//             model.addAttribute("Success", "Food have been requested!");
//         }
//         return "redirect:/";
//     }

// }