package com.foodforcharity.app.web.controller;

import java.util.concurrent.ExecutionException;

import com.foodforcharity.app.domain.constant.DoneeType;
import com.foodforcharity.app.domain.constant.PersonRole;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Mediator;
import com.foodforcharity.app.usecase.account.changepassword.ChangePasswordCommand;
import com.foodforcharity.app.usecase.account.doneeregisteration.DoneeRegisterationCommand;
import com.foodforcharity.app.usecase.account.donorregisteration.DonorRegisterationCommand;
import com.foodforcharity.app.web.model.ChangePasswordRequest;
import com.foodforcharity.app.web.model.RequestModel;
import com.foodforcharity.app.web.validator.ChangePasswordValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
// @RequestMapping("/user")
public class PersonController extends AbstractController {

    @Autowired
    PersonController(Mediator mediator) {
        super(mediator);
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new ChangePasswordValidator());
    }

    @GetMapping(value = "/home")
    public String getHomeView(Model model) {
        return "redirect:/" + getPersonRole().name().toLowerCase() + "/home";
    }

    @GetMapping(value = "/change-password")
    public String getChangePasswordView(ChangePasswordRequest request) {
        return "change-password";
    }

    @PostMapping(value = "/change-password")
    public String changePassword(Model model, @Validated ChangePasswordRequest requestModel, BindingResult result)
            throws ExecutionException {

        if (result.hasErrors()) {
            return "change-password";
        }

        ChangePasswordCommand command = new ChangePasswordCommand(getPersonId(), requestModel.getPassword(),
                requestModel.getNewPassword());

        Response<Void> response = publishAsync(command).get();

        return response.success()? "redirect:/change-password?success" : "redirect:/change-password?error";
    }

    @GetMapping(value = "/register")
    public String getRegisterView(RequestModel requestModel) {
        return "register";
    }

    @PostMapping(value = "/register")
    public ModelAndView registerDonor(@ModelAttribute RequestModel requestModel, Model model) throws ExecutionException {

        Response<Void> response;

        if (requestModel.getPersonRole() == PersonRole.Donor.name()) {

            DonorRegisterationCommand command = new DonorRegisterationCommand(requestModel.getName(),
                    requestModel.getPassword(), requestModel.getEmail(), requestModel.getPhoneNumber(),
                    requestModel.getCity(), requestModel.getCountry(), requestModel.getAddress());

            response = publishAsync(command).get();
        } else {
            DoneeRegisterationCommand command = new DoneeRegisterationCommand(requestModel.getName(),
                    requestModel.getPassword(), requestModel.getEmail(), requestModel.getPhoneNumber(),
                    requestModel.getCity(), requestModel.getCountry(), requestModel.getAddress(), DoneeType.Individual,
                    1);

            response = publishAsync(command).get();
        }

        if (response.success()) {
            new ModelAndView("login");
        }

        return new ModelAndView("redirect:/register?error", "requestModel", requestModel);
    }

}