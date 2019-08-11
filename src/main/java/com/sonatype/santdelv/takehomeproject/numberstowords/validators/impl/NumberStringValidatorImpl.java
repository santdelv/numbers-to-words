package com.sonatype.santdelv.takehomeproject.numberstowords.validators.impl;

import com.sonatype.santdelv.takehomeproject.numberstowords.validators.NumberStringValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberStringValidatorImpl extends NumberStringValidator {

    /* This pattern should only allow a number value with a negative "-" prefix,
    with and without space between the prefix and the number */
    private static final Pattern validNumberPattern = Pattern.compile("-?\\s?\\d+");

    @Override
    protected boolean isValidNumberString(String number) {
        Matcher m = validNumberPattern.matcher(number);
        return m.matches();
    }

    @Override
    protected boolean isValidNumberRange(String number) {

        if ("-".equals(number.substring(0, 1)))
            number = number.substring(1);

        /* Because we previously validated that the entered is a valid number then we can be sure that
        the number is outside of the valid int ranges*/
        try {
            Integer.valueOf(number);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

}
