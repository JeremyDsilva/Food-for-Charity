package com.foodforcharity.app.usecase.reviews.filecomplaint;

import com.foodforcharity.app.domain.response.Response;
import com.foodforcharity.app.mediator.CommandHandler;
import org.springframework.stereotype.Service;

@Service
public class FileComplaintCommandHandler implements CommandHandler<FileComplaintCommand, Response<Void>> {

    public FileComplaintCommandHandler() {

    }

    @Override
    public Response<Void> handle(FileComplaintCommand command) {

        return null;

    }

}