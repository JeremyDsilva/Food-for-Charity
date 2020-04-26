package com.foodforcharity.app.usecase.profile.deletemenuitem;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Food;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.domain.service.FoodService;
import com.foodforcharity.app.mediator.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteMenuItemCommandHandler implements CommandHandler<DeleteMenuItemCommand, Response<Void>> {

    FoodService foodService;

    /**
     * Public Constructor
     *
     * @param foodService
     */
    @Autowired
    public DeleteMenuItemCommandHandler(FoodService foodService) {
        this.foodService = foodService;
    }

    @Override
    public Response<Void> handle(DeleteMenuItemCommand command) {
        try { // check that food item exists
            Optional<Food> dbFood = foodService.findById(command.foodId);
            if (dbFood.isEmpty()) {
                return Response.of(Error.FoodDoesNotExist);
            }

            Food food = dbFood.get();
            // check that food belongs to command.donor id
            if (food.getDonor().getId() != command.donorId) {
                return Response.of(Error.FoodsDonorMismatch);
            }

            // check that food doesnt belong to any active requests
            if (food.getSubRequests().size() != 0 && (
                    food.getSubRequests().stream().filter(subRequest -> subRequest.getRequest().getIsActive()
                            || subRequest.getRequest().getComplaints().stream().filter(complaint -> complaint.getIsActive()).findFirst().isPresent()).findFirst().isPresent())) {
                return Response.of(Error.FoodHasActiveRequestOrComplaints);
            }

            // delete
            food.getDonor().removeFood(food);
            return Response.EmptyResponse();
        } catch (Exception e) {
            return Response.of(Error.UnknownError);
        }

    }

}