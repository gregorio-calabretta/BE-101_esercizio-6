package com.example.esercizio6.annotations;

import com.example.esercizio6.validation.Validate;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Validate.class)
public @interface IsLetter {
     Class<? extends Payload>[] payload() default {};
     Class<?>[] groups() default {};
     String message() default "Invalid Input";
     String propName();
}
