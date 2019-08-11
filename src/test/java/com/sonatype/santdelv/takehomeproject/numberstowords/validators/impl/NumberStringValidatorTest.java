package com.sonatype.santdelv.takehomeproject.numberstowords.validators.impl;

import com.sonatype.santdelv.takehomeproject.numberstowords.exceptions.InvalidNumberException;
import com.sonatype.santdelv.takehomeproject.numberstowords.exceptions.NumberOutOfRangeException;
import com.sonatype.santdelv.takehomeproject.numberstowords.validators.NumberStringValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberStringValidatorTest {

    @Test
    @DisplayName("Test plain numbers are allowed")
    void allowNumbers() throws InvalidNumberException, NumberOutOfRangeException {
        NumberStringValidator numberStringValidator = new NumberStringValidatorImpl();
        numberStringValidator.validateNumber("1");
        numberStringValidator.validateNumber("1000");
        numberStringValidator.validateNumber("143253");
    }

    @Test
    @DisplayName("Test plain negative numbers are allowed")
    void allowNegativeNumbers() throws InvalidNumberException, NumberOutOfRangeException {
        NumberStringValidator numberStringValidator = new NumberStringValidatorImpl();
        numberStringValidator.validateNumber("-1");
        numberStringValidator.validateNumber("-1000");
        numberStringValidator.validateNumber("-143253");
    }

    @Test
    @DisplayName("Test that the validator only allows numbers")
    void rejectNonNumbers() {
        NumberStringValidator numberStringValidator = new NumberStringValidatorImpl();
        assertThrows(InvalidNumberException.class, () -> numberStringValidator.validateNumber("foo"));
        assertThrows(InvalidNumberException.class, () -> numberStringValidator.validateNumber("123foo123"));
        assertThrows(InvalidNumberException.class, () -> numberStringValidator.validateNumber("foo123"));
        assertThrows(InvalidNumberException.class, () -> numberStringValidator.validateNumber("123foo"));
    }

    @Test
    @DisplayName("Test that the validator rejects non numbers that start with the negative prefix")
    void rejectNonNumbersWithNegativeSign() {
        NumberStringValidator numberStringValidator = new NumberStringValidatorImpl();
        assertThrows(InvalidNumberException.class, () -> numberStringValidator.validateNumber("-foo"));
        assertThrows(InvalidNumberException.class, () -> numberStringValidator.validateNumber("-123foo123"));
        assertThrows(InvalidNumberException.class, () -> numberStringValidator.validateNumber("-foo123"));
        assertThrows(InvalidNumberException.class, () -> numberStringValidator.validateNumber("-123foo"));
        assertThrows(InvalidNumberException.class, () -> numberStringValidator.validateNumber("- foo"));
        assertThrows(InvalidNumberException.class, () -> numberStringValidator.validateNumber("- 123foo123"));
        assertThrows(InvalidNumberException.class, () -> numberStringValidator.validateNumber("- foo123"));
        assertThrows(InvalidNumberException.class, () -> numberStringValidator.validateNumber("- 123foo"));
    }

    @Test
    @DisplayName("Test that the validator rejects numbers with a double space between the negative sign and the number.")
    void rejectNegativesWithDoubleSpace() {
        NumberStringValidator numberStringValidator = new NumberStringValidatorImpl();
        assertThrows(InvalidNumberException.class, () -> numberStringValidator.validateNumber("-  32312"));
        assertThrows(InvalidNumberException.class, () -> numberStringValidator.validateNumber("-  1"));
    }

    @Test
    @DisplayName("Test that the validator rejects numbers with a double negative sign.")
    void rejectNegativesWithDoubleNegativeSign() {
        NumberStringValidator numberStringValidator = new NumberStringValidatorImpl();
        assertThrows(InvalidNumberException.class, () -> numberStringValidator.validateNumber("-- 32312"));
        assertThrows(InvalidNumberException.class, () -> numberStringValidator.validateNumber("-- 1"));
    }

    @Test
    @DisplayName("Test that the validator rejects valid numbers chained together.")
    void rejectValidChainedNumbers() {
        NumberStringValidator numberStringValidator = new NumberStringValidatorImpl();
        assertThrows(InvalidNumberException.class, () -> numberStringValidator.validateNumber("-1-1"));
        assertThrows(InvalidNumberException.class, () -> numberStringValidator.validateNumber("12121212-1"));
        assertThrows(InvalidNumberException.class, () -> numberStringValidator.validateNumber("12121212 -1"));
    }

    @Test
    @DisplayName("Test that the validator rejects valid numbers chained together.")
    void acceptMaximumAndMinimumNumbers() throws InvalidNumberException, NumberOutOfRangeException {
        NumberStringValidator numberStringValidator = new NumberStringValidatorImpl();
        numberStringValidator.validateNumber(String.valueOf(Integer.MAX_VALUE));
        numberStringValidator.validateNumber(String.valueOf(Integer.MIN_VALUE ));
        numberStringValidator.validateNumber(String.valueOf(Integer.MAX_VALUE * -1));
        numberStringValidator.validateNumber(String.valueOf((Integer.MIN_VALUE) * -1));
    }

}
