package com.foodforcharity.app.domain;

import java.util.Date;
import java.util.List;


public class Request {
   
    long id;

    Donor donor;

    Donee donee;

    int finalPrice;

    int discountApplied;

    Date requestTime;

    Boolean IsActive;

    List<SubRequest> subRequest;

}
