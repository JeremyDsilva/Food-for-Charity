package com.foodforcharity.app.web.controller;

import java.util.concurrent.ExecutionException;

import com.foodforcharity.app.domain.constant.DoneeType;
import com.foodforcharity.app.domain.constant.PersonRole;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.domain.security.PersonDetails;
import com.foodforcharity.app.mediator.Mediator;
import com.foodforcharity.app.usecase.account.changepassword.ChangePasswordCommand;
import com.foodforcharity.app.usecase.account.doneeregisteration.DoneeRegisterationCommand;
import com.foodforcharity.app.usecase.account.donorregisteration.DonorRegisterationCommand;
import com.foodforcharity.app.web.model.RequestModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// @RequestMapping("/user")
public class PersonController {

    Mediator mediator;

    @Autowired
    PersonController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping(value = "/change-password")
    public String getChangePasswordView(Model model) {
        return "change-password";
    }

    @PostMapping(value = "/change-password")
    public String changePassword(Authentication authentication, Model model,
            @RequestParam(defaultValue = "password") String password,
            @RequestParam(defaultValue = "newPassword") String newPassword) throws ExecutionException {
        /*
         * Get person id from session
         */

        PersonDetails o = (PersonDetails) authentication.getPrincipal();

        long personId = o.getPersonId();

        ChangePasswordCommand command = new ChangePasswordCommand(personId, password, newPassword);

        Response<Void> response = mediator.publishAsync(command).get();

        if (response.success()) {
            model.addAttribute("Success", "Password Successfully Changed!");
        } else {
            model.addAttribute("Error", response.getError().getMessage());
        }

        return "change-password";
    }

    @GetMapping(value = "/register")
    public String getRegisterView(Model model) {
        model.addAttribute("requestModel", new RequestModel());
        return "register";
    }

    @PostMapping(value = "/register")
    public String registerDonor(@ModelAttribute RequestModel requestModel, Model model) throws ExecutionException {

        Response<Void> response;

        if (requestModel.getPersonRole() == PersonRole.Donor.name()) {

            DonorRegisterationCommand command = new DonorRegisterationCommand(requestModel.getName(),
                    requestModel.getPassword(), requestModel.getEmail(), requestModel.getPhoneNumber(),
                    requestModel.getCity(), requestModel.getCountry(), requestModel.getAddress());

            response = mediator.publishAsync(command).get();
        } else {
            DoneeRegisterationCommand command = new DoneeRegisterationCommand(requestModel.getName(),
                    requestModel.getPassword(), requestModel.getEmail(), requestModel.getPhoneNumber(),
                    requestModel.getCity(), requestModel.getCountry(), requestModel.getAddress(), DoneeType.Individual,
                    1);

            response = mediator.publishAsync(command).get();
        }

        if (response.success()) {
            return "login";
        }

        model.addAttribute("IsError", true);
        model.addAttribute("ErrorMessage", response.getError().getMessage());
        model.addAttribute("requestModel", requestModel);

        return "register";
    }

}