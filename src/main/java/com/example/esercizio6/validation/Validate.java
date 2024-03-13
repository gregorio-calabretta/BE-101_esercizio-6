package com.example.esercizio6.validation;

import com.example.esercizio6.annotations.IsLetter;
import com.example.esercizio6.exception.InvalidInputException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class Validate implements ConstraintValidator<IsLetter,String> {
    private String message;
    private String propName;

    @Override
    public void initialize(IsLetter constraintAnnotation) {
        this.propName = constraintAnnotation.propName();
        this.message = constraintAnnotation.message();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
       boolean valid = s.matches("[a-zA-Z]+")&& s.length() == 1;
        if (Boolean.FALSE.equals(valid)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(this.message).addPropertyNode(this.propName).addConstraintViolation();
            if (s.equals(" ")){
                throw new InvalidInputException("Input can't be empty");
            }else
            {
            throw new InvalidInputException("Input :" + s +" is not valid");
            }
        }
    return true;
    }
}
