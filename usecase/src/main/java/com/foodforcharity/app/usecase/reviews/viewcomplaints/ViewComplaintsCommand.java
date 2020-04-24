package com.foodforcharity.app.usecase.reviews.viewcomplaints;

import com.foodforcharity.app.domain.constant.PersonRole;
import com.foodforcharity.app.mediator.Command;

import java.util.Optional;

public class ViewComplaintsCommand implements Command<Void> {
    long personId; // required to decide which complaints to show based on who the person is

    Optional<PersonRole> fromRole;

    Optional<Boolean> isActive;

    public ViewComplaintsCommand() {

    }

    /**
     * Public constructors
     *
     * @param personId
     */
    public ViewComplaintsCommand(long personId) {
        this.personId = personId;
        fromRole = Optional.empty();
        isActive = Optional.empty();
    }

    /**
     * @param personRole
     */
    public void setFromRole(PersonRole personRole) {
        this.fromRole = Optional.of(personRole);
    }

    public void setisActive(Boolean isActive) {
        this.isActive = Optional.of(isActive);
    }

}