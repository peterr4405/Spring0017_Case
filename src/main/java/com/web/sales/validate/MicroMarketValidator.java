package com.web.sales.validate;

import com.web.sales.models.MicroMarket;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MicroMarketValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return MicroMarket.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        MicroMarket microMarket = (MicroMarket) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipCode", "MicroMarket.zipCode.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "radius", "MicroMarket.radius.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "areaLength", "MicroMarket.areaLength.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "areaWidth", "MicroMarket.areaWidth.empty");

        if (microMarket.getRadius() != null && microMarket.getRadius() < 0) {
            errors.rejectValue("radius", "MicroMarket.radius.invalid");
        }

        if (microMarket.getAreaLength()!= null && microMarket.getAreaLength() < 0) {
            errors.rejectValue("areaLength", "MicroMarket.areaLength.invalid");
        }

        if (microMarket.getAreaWidth() != null && microMarket.getAreaWidth() < 0) {
            errors.rejectValue("areaWidth", "MicroMarket.areaWidth.invalid");
        }

    }

}
