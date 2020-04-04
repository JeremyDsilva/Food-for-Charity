package com.foodforcharity.app.usecase.profile.deletemenuitem;

import java.util.Optional;

import com.foodforcharity.app.domain.constant.Error;
import com.foodforcharity.app.domain.entity.Food;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.service.FoodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteMenuItemCommandHandler implements CommandHandler<DeleteMenuItemCommand, Response<Void>> {

	FoodRepository foodRepository;

	/**
	 * Public Constructor
	 * 
	 * @param foodRepository
	 */
	@Autowired
	public DeleteMenuItemCommandHandler(FoodRepository foodRepository) {
		this.foodRepository = foodRepository;
	}

	@Override
	public Response<Void> handle(DeleteMenuItemCommand command) {
	try{	// check that food item exists
			Optional<Food> dbFood=foodRepository.findById(command.foodId);
			if (dbFood.isEmpty()){
				return Response.of(Error.FoodDoesNotExist);
			}

			Food food=dbFood.get();
		// check that food belongs to command.donor id
		if(food.getDonor().getId()!= command.donorId){
			return Response.of(Error.FoodsDonorMismatch)
		}

		// check that food doesnt belong to any active requests


		// delete
		foodRepository.delete(food);
		return Response.EmptyResponse();
	}
		catch(Exception e){
			return Response.of(Error.UnknownError);
		}

	}

}