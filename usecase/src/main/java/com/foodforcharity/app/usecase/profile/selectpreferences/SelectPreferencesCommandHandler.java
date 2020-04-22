package com.foodforcharity.app.usecase.profile.selectpreferences;

import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.CommandHandler;
import org.springframework.stereotype.Service;

@Service
public class SelectPreferencesCommandHandler implements CommandHandler<SelectPreferencesCommand, Response<Void>> {

    public SelectPreferencesCommandHandler() {

    }

    @Override
    public Response<Void> handle(SelectPreferencesCommand command) {

        return null;

    }

}