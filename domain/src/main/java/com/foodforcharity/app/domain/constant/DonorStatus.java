package com.foodforcharity.app.domain.constant;

import com.foodforcharity.app.domain.security.PersonStatus;

public enum DonorStatus implements PersonStatus {
    Initial, Active, Inactive, Suspended;
}