package br.edu.ifpb.pps.projeto.renderspring.modurender.utils;


import java.util.regex.Pattern;

public class Validator {

    public boolean validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }

    public boolean validateNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public boolean validateRange(int value, int min, int max) {
        return value >= min && value <= max;
    }

    public boolean validatePositiveNumber(double number) {
        return number > 0;
    }
}

