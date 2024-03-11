package com.example.esercizio6.validator;

import org.springframework.stereotype.Component;

@Component
public class Validate {

    public void isLetter(String letter) {
        char myChar = letter.charAt(0);
        if(letter.length() > 1){
            throw new IllegalArgumentException("Invalid input");
        }
        if (!letter.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Invalid input");
        }
    }
}