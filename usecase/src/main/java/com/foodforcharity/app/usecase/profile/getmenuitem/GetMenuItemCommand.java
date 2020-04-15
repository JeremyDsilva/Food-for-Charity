package com.foodforcharity.app.usecase.profile.getmenuitem;

import com.foodforcharity.app.domain.entity.Food;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Command;

import lombok.Value;

@Value
public class GetMenuItemCommand implements Command<Response<Food>> {
	long personId;
	long foodId;

}