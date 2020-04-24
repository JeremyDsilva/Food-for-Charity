package com.foodforcharity.app.usecase.profile.getmenuitem;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Food;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.domain.service.FoodService;
import com.foodforcharity.app.mediator.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetMenuItemCommandHandler implements CommandHandler<GetMenuItemCommand, Response<Food>> {

    FoodService foodService;

    @Autowired
    public GetMenuItemCommandHandler(FoodService foodService) {
        this.foodService = foodService;
    }

    @Override
    public Response<Food> handle(GetMenuItemCommand command) {

        try {
            Optional<Food> dbFood = foodService.findById(command.getFoodId());

            if (dbFood.isEmpty()) {
                return Response.of(Error.FoodDoesNotExist);
            } else if (dbFood.get().getDonor().getId() != command.getPersonId()) {
                return Response.of(Error.FoodsDonorMismatch);
            }

            return Response.of(dbFood.get());

        } catch (Exception e) {
            return Response.of(Error.UnknownError);
        }
    }

}
