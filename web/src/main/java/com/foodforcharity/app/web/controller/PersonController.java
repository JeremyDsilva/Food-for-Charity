package com.foodforcharity.app.web.controller;

import static com.foodforcharity.app.web.model.Request.withSuccess;

import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Mediator;
import com.foodforcharity.app.usecase.account.changepassword.ChangePasswordCommand;
import com.foodforcharity.app.usecase.account.doneeregisteration.DoneeRegisterationCommand;
import com.foodforcharity.app.usecase.account.donorregisteration.DonorRegisterationCommand;
import com.foodforcharity.app.web.model.ChangePasswordRequest;
import com.foodforcharity.app.web.model.DoneeRegisterRequest;
import com.foodforcharity.app.web.model.DonorRegisterRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController extends AbstractController {

    @Autowired
    PersonController(Mediator mediator) {
        super(mediator);
    }

    // @InitBinder
    // protected void initBinder(WebDataBinder binder) {
    // binder.setValidator(new ChangePasswordValidator());
    // }

    @GetMapping(value = "/home")
    public String getHomeView(Model model) {
        return "redirect:/" + getPersonRole().toLowerCase() + "/home";
    }

    @GetMapping(value = "/register")
    public String getRegisterView(){
        return "/register";
    }
    
    @GetMapping(value = "/change-password")
    public String getChangePasswordView(ChangePasswordRequest request) {
        return "change-password";
    }

    @PostMapping(value = "/change-password")
    public String changePassword(@Valid ChangePasswordRequest request, BindingResult result, Model model) throws ExecutionException {

        if(!request.getConfirmNewPassword().equals(request.getNewPassword())){
            result.addError(new ObjectError("confirmNewPassword", "Passwords don't match"));
            return "change-password";
        }

        if (result.hasErrors()) {
            return "change-password";
        }

        ChangePasswordCommand command = new ChangePasswordCommand(Long.valueOf(1), request.getPassword(),
                request.getNewPassword());

        Response<Void> response = publishAsync(command).get();

        if (response.hasError()) {
            request.setError(response.getError());
        } else {
            model.addAttribute("changePasswordRequest", withSuccess(new ChangePasswordRequest()));
        }
            
        return "change-password";
    }

    @GetMapping(value = "/donee-register")
    public String getDoneeRegisterView(DoneeRegisterRequest request, Model model) {
        return "donee-register";
    }

    @PostMapping(value = "/donee-register")
    public String registerDonee(@Valid DoneeRegisterRequest request, BindingResult result, Model model) throws ExecutionException {

        if(!request.getConfirmPassword().equals(request.getPassword())){
            result.addError(new ObjectError("confirmPassword", "Passwords don't match"));
            return "donee-register";
        }

        if (result.hasErrors()) {
            return "donee-register";
        }

        DoneeRegisterationCommand command = new DoneeRegisterationCommand(request.getName(), request.getPassword(),
                request.getEmail(), request.getPhoneNumber(), request.getCity(), request.getCountry(),
                request.getAddress(), request.getDoneeType(), request.getNumberOfMembers());

        Response<Void> response = publishAsync(command).get();

        if(response.hasError()){
            request.setError(response.getError());
        } else {
            model.addAttribute("doneeRegisterRequest", withSuccess(new DoneeRegisterRequest())); 
        }
            
        return "donee-register";
    }

    @GetMapping(value = "/donor-register")
    public String getDonorRegisterView(DonorRegisterRequest request, Model model) {
        return "donor-register";
    }

    @PostMapping(value = "/donor-register")
    public String registerDonor(@Valid DonorRegisterRequest request, BindingResult result, Model model) throws ExecutionException {

        if(!request.getConfirmPassword().equals(request.getPassword())){
            result.addError(new ObjectError("confirmPassword", "Passwords don't match"));
            return "donor-register";
        }

        if (result.hasErrors()) {
            return "donor-register";
        }

        DonorRegisterationCommand command = new DonorRegisterationCommand(request.getName(), request.getPassword(),
                request.getEmail(), request.getPhoneNumber(), request.getCity(), request.getCountry(),
                request.getAddress());

        Response<Void> response = publishAsync(command).get();

        if(response.hasError()){
            request.setError(response.getError());
        } else {
            model.addAttribute("donorRegisterRequest", withSuccess(new DonorRegisterRequest())); 
        }

        return "donor-register";
    }

}