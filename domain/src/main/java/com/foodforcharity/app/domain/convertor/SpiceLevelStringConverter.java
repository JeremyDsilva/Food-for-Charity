package com.foodforcharity.app.domain.convertor;

import com.foodforcharity.app.domain.constant.SpiceLevel;

public class SpiceLevelStringConverter extends EnumStringConverter<SpiceLevel>  {

    public SpiceLevelStringConverter(){
        super(SpiceLevel.class);
    }

}