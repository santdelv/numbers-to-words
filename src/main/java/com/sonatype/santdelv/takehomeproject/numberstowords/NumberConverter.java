package com.sonatype.santdelv.takehomeproject.numberstowords;

import com.sonatype.santdelv.takehomeproject.numberstowords.exceptions.InvalidNumberException;
import com.sonatype.santdelv.takehomeproject.numberstowords.exceptions.NumberOutOfRangeException;

public interface NumberConverter {

    /**
     * Converts a number given by an it to its equivalent in english words.
     * @param number The number we want to convert
     * @return The given number expressed in english words.
     */
    String getNumberAsWords(String number) throws InvalidNumberException, NumberOutOfRangeException;
}
