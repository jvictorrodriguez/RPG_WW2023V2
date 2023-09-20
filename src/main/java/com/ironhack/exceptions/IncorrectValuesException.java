package com.ironhack.exceptions;

import com.ironhack.model.Attacker;
import com.ironhack.model.Warrior;

public class IncorrectValuesException extends Exception {
    public IncorrectValuesException(Attacker attacker, String valueForStaminaIncorrect) {

    }

    public IncorrectValuesException(String message) {
        super(message);
    }

    public IncorrectValuesException() {
        super();
    }
}
