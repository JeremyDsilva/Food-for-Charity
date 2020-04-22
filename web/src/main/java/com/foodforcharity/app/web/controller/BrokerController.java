package com.foodforcharity.app.web.controller;

import com.foodforcharity.app.mediator.Mediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


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


}