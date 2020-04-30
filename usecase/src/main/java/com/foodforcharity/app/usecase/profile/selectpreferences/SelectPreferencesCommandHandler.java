package com.foodforcharity.app.usecase.profile.selectpreferences;

import java.util.Optional;
import com.foodforcharity.app.domain.entity.Donee;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.domain.service.DoneeService;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.usecase.profile.selectpreferences.SelectPreferencesCommand.Range;

import org.springframework.stereotype.Service;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.constant.SpiceLevel;

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
            if (!donee.getAllergens().isEmpty()) {
                donee.getAllergens().clear();
            }
            
            if (!donee.getCuisines().isEmpty()) {
                donee.getCuisines().clear();
            }

            if (!donee.getMealTypes().isEmpty()) {
                donee.getMealTypes().clear();
            }

            // 3-price ranges start is always greater than 0 and less than stop
            Range<Integer> priceRange = command.getPriceRange();
            if (priceRange.getStart() < 0 || priceRange.getStop() < priceRange.getStart()) {
                return Response.of(Error.InvalidPriceRange);
            } else {
                donee.getPriceRange().setStartPrice(priceRange.getStart());
                donee.getPriceRange().setEndPrice(priceRange.getStop());
            }

            // 4- the spice range must be valid
            Range<SpiceLevel> spiceRange = command.getSpiceRange();
            if (spiceRange.getStop().ordinal() < spiceRange.getStart().ordinal()) {
                return Response.of(Error.InvalidSpiceRange);
            } else {
                donee.getSpiceRange().setStartLevel(command.getSpiceRange().getStart());
                donee.getSpiceRange().setEndLevel(command.getSpiceRange().getStop());

            }

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