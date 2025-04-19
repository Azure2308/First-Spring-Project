package com.example.startproj.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    private static final String PHONE_NUMBER = "^((\\+7|7|8)+([0-9]){10})$";

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
        return phone != null && phone.matches(PHONE_NUMBER);
    }
}
