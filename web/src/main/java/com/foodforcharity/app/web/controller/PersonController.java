package com.foodforcharity.app.web.controller;

import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import com.foodforcharity.app.domain.constant.DoneeType;
import com.foodforcharity.app.domain.constant.PersonRole;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Mediator;
import com.foodforcharity.app.usecase.account.changepassword.ChangePasswordCommand;
import com.foodforcharity.app.usecase.account.doneeregisteration.DoneeRegisterationCommand;
import com.foodforcharity.app.usecase.account.donorregisteration.DonorRegisterationCommand;
import com.foodforcharity.app.web.model.UserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// @RequestMapping("/user")
public class PersonController extends AbstractController {

    @Autowired
    PersonController(Mediator mediator) {
        super(mediator);
    }

    @GetMapping(value = "/home")
    public String getHomeView(Model model) {
        return "redirect:/" + getPersonRole().name().toLowerCase() + "/home";
    }

    @GetMapping(value = "/change-password")
    public String getChangePasswordView(Model model) {
        return "change-password";
    }

    @PostMapping(value = "/change-password")
    public String changePassword(Model model, @RequestParam(defaultValue = "password") String password,
            @RequestParam(defaultValue = "newPassword") String newPassword) throws ExecutionException {
        /*
         * Get person id from session
         */

        ChangePasswordCommand command = new ChangePasswordCommand(getPersonId(), password, newPassword);

        Response<Void> response = publishAsync(command).get();

        if (response.success()) {
            model.addAttribute("Success", "Password Successfully Changed!");
        } else {
            model.addAttribute("Error", response.getError().getMessage());
        }

        return "change-password";
    }

    @GetMapping(value = "/register")
    public String getRegisterView(Model model) {
        model.addAttribute("userDetails", new UserDetails());
        return "register";
    }

    @PostMapping(value = "/register")
    public String registerDonor(@Valid @ModelAttribute UserDetails userDetails, Model model) throws ExecutionException {

        Response<Void> response;

        if (userDetails.getPersonRole() == PersonRole.Donor.name()) {

            DonorRegisterationCommand command = new DonorRegisterationCommand(userDetails.getName(),
            userDetails.getPassword(), userDetails.getEmail(), userDetails.getPhoneNumber(),
            userDetails.getCity(), userDetails.getCountry(), userDetails.getAddress());

            response = publishAsync(command).get();
        } else {
            DoneeRegisterationCommand command = new DoneeRegisterationCommand(userDetails.getName(),
            userDetails.getPassword(), userDetails.getEmail(), userDetails.getPhoneNumber(),
            userDetails.getCity(), userDetails.getCountry(), userDetails.getAddress(), DoneeType.Individual,
                    1);

            response = publishAsync(command).get();
        }

        if (response.success()) {
            return "login";
        }

        // model.addAttribute("IsError", true);
        // model.addAttribute("ErrorMessage", response.getError().getMessage());
        model.addAttribute("userDetails", userDetails);

        return "register";
    }

}