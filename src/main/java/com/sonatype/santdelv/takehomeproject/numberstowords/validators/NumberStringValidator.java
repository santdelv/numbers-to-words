package com.sonatype.santdelv.takehomeproject.numberstowords.validators;

import com.sonatype.santdelv.takehomeproject.numberstowords.exceptions.InvalidNumberException;
import com.sonatype.santdelv.takehomeproject.numberstowords.exceptions.NumberOutOfRangeException;

public abstract class NumberStringValidator {

    /**
     * Test that a number if valid for the nNumberConverter to process
     * @param number number as a String
     * @throws InvalidNumberException if the number is malformed
     * @throws NumberOutOfRangeException if the number is out of the valid range
     */
    public void validateNumber(String number) throws InvalidNumberException, NumberOutOfRangeException {
        if (!isValidNumberString(number))
            throw new InvalidNumberException("Number should be an int with an optional '-' at the beginning");
        if (!isValidNumberRange(number))
            throw new NumberOutOfRangeException("Number out of the accepted range");
    }

    /**
     * Validates if a given number as a String is valid.
     * @param number The number as a String
     * @return true if valid, false if invalid
     */
    protected abstract boolean isValidNumberString(String number);

    /**
     * Validates if a given number as a String is within the valid ranges.
     * @param number The number as a String
     * @return true if valid, false if invalid
     */
    protected abstract boolean isValidNumberRange(String number);
}
