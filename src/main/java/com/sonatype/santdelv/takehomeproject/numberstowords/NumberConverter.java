package com.sonatype.santdelv.takehomeproject.numberstowords;

public interface NumberConverter {

    /**
     * Converts a number given by an it to its equivalent in english words.
     * @param number The number we want to convert
     * @return The given number expressed in english words.
     */
    String getNumberAsWords(String number);
}
