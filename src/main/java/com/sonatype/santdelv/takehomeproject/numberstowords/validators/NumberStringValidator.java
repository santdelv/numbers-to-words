package com.sonatype.santdelv.takehomeproject.numberstowords.validators;

import com.sonatype.santdelv.takehomeproject.numberstowords.exceptions.InvalidNumberException;

public abstract class NumberStringValidator {

    public void validateNumber(String number) throws InvalidNumberException {
        if (!isValidNumberString(number))
            throw new InvalidNumberException("Invalid Number");
    }

    /**
     * Validates if a given number as a String is valid.
     * @param number The number as a String
     * @return true if valid, false if invalid
     */
    protected abstract boolean isValidNumberString(String number);
}
