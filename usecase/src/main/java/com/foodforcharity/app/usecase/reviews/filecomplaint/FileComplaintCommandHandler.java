package com.foodforcharity.app.usecase.reviews.filecomplaint;

import com.foodforcharity.app.mediator.CommandHandler;
import org.springframework.stereotype.Service;

@Service
public class FileComplaintCommandHandler implements CommandHandler<FileComplaintCommand, Void> {

    public FileComplaintCommandHandler() {

    }

    @Override
    public Void handle(FileComplaintCommand command) {

        return null;

    }

}