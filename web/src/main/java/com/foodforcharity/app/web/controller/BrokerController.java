package com.foodforcharity.app.web.controller;

import com.foodforcharity.app.mediator.Mediator;
import com.foodforcharity.app.usecase.account.changestatus.ChangeStatusCommand;
import com.foodforcharity.app.web.model.ChangeStatusRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/broker")
@PreAuthorize(value = "hasAuthority('Broker')")
public class BrokerController extends AbstractController {

    @Autowired
    BrokerController(Mediator mediator) {
        super(mediator);
    }

    @GetMapping(value = "/home")
    public String getBrokerHomepageView() {
        return "broker/broker-homepage";
    }

    //----------Donors and Donees------------

    @GetMapping(value = "donors")
    public String getListofDonors() {
        return new String();
    }

    @GetMapping(value = "donees")
    public String getListofDonees() {
        return new String();
    }

    @GetMapping(value = "donor")
    public String getDonorProfile(@RequestParam(value = "donor") long donorId) {
        return new String();
    }

    @GetMapping(value = "donee")
    public String getDoneeProfile(@RequestParam(value = "donee") long doneeId) {
        return new String();
    }

    @DeleteMapping(value = "donor")
    public String deleteDonor(@RequestParam(value = "donor") long donorId) {

        return "redirect:/";
    }

    @DeleteMapping(value = "donee")
    public String deleteDonee(@RequestParam(value = "donee") long doneeId) {

        return "redirect:/";
    }

    //---------- Orders ------------

    @GetMapping(value = "orders")
    public String getListofOrders() {
        return new String();
    }

    @GetMapping(value = "order")
    public String getOrder(@RequestParam(value = "orderId") long id) {
        return new String();
    }

    @DeleteMapping(value = "order")
    public String deleteOrder(@RequestParam(value = "orderId") long id) {
        return new String();
    }


    //---------- Comlaints ------------


    @GetMapping(value = "complaint")
    public String getListofComplaints() {
        return new String();
    }


    //---------- Status ------------

    @ResponseBody
    @PostMapping(value = "change-status")
    public boolean changeStatus(@Valid ChangeStatusRequest request, BindingResult result){

        if(result.hasErrors()){
            return false;
        }

        ChangeStatusCommand command = null;

        if(request.getDoneeStatus() != null){
            if(request.getDonorStatus() != null){
                result.addError(new ObjectError("doneeStatus", "DoneeStatus and DonorStatus cannot be both"));
                result.addError(new ObjectError("donorStatus", "DoneeStatus and DonorStatus cannot be both"));
                return false;
            }


        } else {
            if(request.getDoneeStatus() == null){
                result.addError(new ObjectError("doneeStatus", "DoneeStatus and DonorStatus cannot be both"));
                result.addError(new ObjectError("donorStatus", "DoneeStatus and DonorStatus cannot be both"));
                return false;
            }

        }

        return true;
    }

}