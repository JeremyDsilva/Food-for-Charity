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
// @RequestMapping("/user")
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
        return "register";
    }
    // @GetMapping(value = {"/change-password", "/change-password/?success",
    // "/change-password/?error"})
    @GetMapping(value = "/change-password")
    public String getChangePasswordView(ChangePasswordRequest request) {
        return "change-password";
    }

    @PostMapping(value = "/change-password")
    public String changePassword(@Valid ChangePasswordRequest request, BindingResult result) throws ExecutionException {



        if (result.hasErrors()) {
            return "change-password";
        }

        if(request.getConfirmNewPassword() != request.getNewPassword()){
            result.addError(new ObjectError("confirmNewPassword", "Passwords don't match"));
            return "change-password";
        }

        ChangePasswordCommand command = new ChangePasswordCommand(Long.valueOf(1), request.getPassword(),
                request.getNewPassword());

        Response<Void> response = publishAsync(command).get();

        if (response.hasError()) {
            request.setError(response.getError());
            return "change-password";
        } 
            
        return getChangePasswordView(withSuccess(new ChangePasswordRequest()));
    }

    @GetMapping(value = "/donee-register")
    public String getDoneeRegisterView(DoneeRegisterRequest request, Model model) {
        return "donee-register";
    }

    @PostMapping(value = "/donee-register")
    public String registerDonee(@Valid DoneeRegisterRequest request, BindingResult result, Model model) throws ExecutionException {

        if (result.hasErrors()) {
            return "donee-register";
        }

        // if(request.getPassword() != request.getConfirmPassword()){
        //     result.addError(new ObjectError("confirmPassword", "Passwords don't match"));
        //     return "donee-register";
        // }

        DoneeRegisterationCommand command = new DoneeRegisterationCommand(request.getName(), request.getPassword(),
                request.getEmail(), request.getPhoneNumber(), request.getCity(), request.getCountry(),
                request.getAddress(), request.getDoneeType(), request.getNumberOfMembers());

        Response<Void> response = publishAsync(command).get();

        if(response.hasError()){
            request.setError(response.getError());
            return "/donee-register";
        }
        model.addAttribute("success", withSuccess(request));
            
        return getDoneeRegisterView(withSuccess(new DoneeRegisterRequest()), model);
    }

    @GetMapping(value = "/donor-register/**")
    public String getDonorRegisterView(DonorRegisterRequest request, Model model) {
        return "donor-register";
    }

    @PostMapping(value = "/donor-register")
    public String registerDonor(@Valid DonorRegisterRequest request, BindingResult result, Model model) throws ExecutionException {

        if (result.hasErrors()) {
            return "donor-register";
        }

        // if(request.getPassword() != request.getConfirmPassword()){
        //     result.addError(new ObjectError("confirmNewPassword", "Passwords don't match"));
        //     return "donor-register";
        // }

        DonorRegisterationCommand command = new DonorRegisterationCommand(request.getName(), request.getPassword(),
                request.getEmail(), request.getPhoneNumber(), request.getCity(), request.getCountry(),
                request.getAddress());

        Response<Void> response = publishAsync(command).get();

        if(response.hasError()){
            request.setError(response.getError());
            return "/donor-register";
        }

        model.addAttribute("success", withSuccess(request));

        return getDonorRegisterView(withSuccess(new DonorRegisterRequest()), model);
    }

}