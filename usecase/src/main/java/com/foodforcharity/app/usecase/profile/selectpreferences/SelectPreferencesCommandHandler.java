package com.foodforcharity.app.usecase.profile.selectpreferences;

import java.util.Optional;
import com.foodforcharity.app.domain.entity.Donee;
import com.foodforcharity.app.domain.entity.DoneePriceRange;
import com.foodforcharity.app.domain.entity.DoneeSpiceRange;
import com.foodforcharity.app.domain.response.Response;
import com.foodforcharity.app.domain.service.DoneeService;
import com.foodforcharity.app.mediator.CommandHandler;

import org.springframework.stereotype.Service;

import com.foodforcharity.app.domain.constant.Error;

@Service
public class SelectPreferencesCommandHandler implements CommandHandler<SelectPreferencesCommand, Response<Void>> {
    DoneeService doneeService;

    /**
     * public constructor
     * 
     * @param doneeService
     */
    public SelectPreferencesCommandHandler(DoneeService doneeService) {
        this.doneeService = doneeService;
    }

    @Override
    public Response<Void> handle(SelectPreferencesCommand command) {
        try {


            
            // 1 check that donee exists
            // 1- check if donee exists and has an active status
            Optional<Donee> dbDonee = doneeService.findById(command.getDoneeId());
            if (dbDonee.isEmpty()) {
                return Response.of(Error.DoneeDoesNotExist);
            }
            Donee donee = dbDonee.get();
            // 2- reset previouses preferences
           
                donee.getAllergens().clear();
        
                donee.getCuisines().clear();
            
                donee.getMealTypes().clear();

            // 3-price ranges start is always greater than 0 and less than stop
       
            if (command.getPriceRange().getStart() < 0 || command.getPriceRange().getStop() < command.getPriceRange().getStart()) {
                return Response.of(Error.InvalidPriceRange);
            }
            
            if(donee.getPriceRange() == null){
                donee.setPriceRange(new DoneePriceRange());
            }
               
            donee.getPriceRange().setStartPrice(command.getPriceRange().getStart());
            donee.getPriceRange().setEndPrice(command.getPriceRange().getStop());
            

            // 4- the spice range must be valid
            if (command.getSpiceRange().getStop().ordinal() < command.getSpiceRange().getStart().ordinal()) {
                return Response.of(Error.InvalidSpiceRange);
            } 


            if(donee.getSpiceRange()==null){
                donee.setSpiceRange(new DoneeSpiceRange());
            }
                donee.getSpiceRange().setStartLevel(command.getSpiceRange().getStart());
                donee.getSpiceRange().setEndLevel(command.getSpiceRange().getStop());

            

            // 5- add cuisine
            command.getCuisines().stream().forEach(c -> donee.addCuisine(c));

            // 6-add mealtype
            command.getAllergens().stream().forEach(a -> donee.addAllergen(a));

            // 7- add mealtypes
            command.getMealTypes().stream().forEach(m -> donee.addMealType(m));

            // 8-save donee
            doneeService.save(donee);

            // 9- send respons.success
            return Response.EmptyResponse();

        } catch (Exception e) {
            return Response.of(Error.UnknownError);
        }

    }

}