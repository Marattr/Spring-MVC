package com.test.hplus.converters;

import com.test.hplus.beans.Gender;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, Gender> {
    @Override
    public Gender convert(String source) {
        if(source.equals("MALE")){
            return Gender.MALE;
        }else if(source.equals("FEMALE")){
            return Gender.FEMALE;
        }else{
            return Gender.OTHER;
        }
    }
}
