package com.web.sales.validate;

import com.web.sales.models.DiscountCode;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class DiscountCodeValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return DiscountCode.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        DiscountCode discountCode = (DiscountCode) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "discountCode", "DiscountCode.discountCode.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rate", "DiscountCode.rate.empty");

        if (discountCode.getRate() != null && discountCode.getRate() < 0 || discountCode.getRate() > 100) {
            errors.rejectValue("rate", "DiscountCode.rate.invalid");
        }

    }

}
