package com.foodforcharity.app.domain.convertor;

import com.foodforcharity.app.domain.constant.PersonRole;

public class PersonRoleStringConverter extends EnumStringConverter<PersonRole>  {

    public PersonRoleStringConverter() {
        super(PersonRole.class);
    }

}