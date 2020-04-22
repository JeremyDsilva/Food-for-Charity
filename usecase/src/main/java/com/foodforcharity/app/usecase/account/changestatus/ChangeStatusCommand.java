package com.foodforcharity.app.usecase.account.changestatus;

import com.foodforcharity.app.domain.constant.DoneeStatus;
import com.foodforcharity.app.domain.constant.DonorStatus;
import com.foodforcharity.app.domain.reponse.Response;
import com.foodforcharity.app.mediator.Command;
import lombok.Getter;

import java.util.Optional;

@Getter
public class ChangeStatusCommand implements Command<Response<Void>> {
    Optional<DonorStatus> donorStatus;
    Optional<DoneeStatus> doneeStatus;
    long personId; // the person whose status needs to be changed

    public ChangeStatusCommand() {

    }

    /**
     * Public Constructor
     *
     * @param donorStatus
     * @param doneeStatus
     * @param personId
     */
    public ChangeStatusCommand(long personId, DonorStatus donorStatus) {
        this.donorStatus = Optional.of(donorStatus);
        this.doneeStatus = Optional.empty();
        this.personId = personId;
    }

    public ChangeStatusCommand(long personId, DoneeStatus doneeStatus) {
        this.donorStatus = Optional.empty();
        this.doneeStatus = Optional.of(doneeStatus);
        this.personId = personId;
    }


}