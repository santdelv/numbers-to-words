package com.sonatype.santdelv.takehomeproject.numberstowords.exceptions;

/**
 * Custom exception to be thrown when a number is not within the valid ranges for the number converter
 */
public class NumberOutOfRangeException extends Exception {

    public NumberOutOfRangeException(String message) {
        super(message);
    }
}
