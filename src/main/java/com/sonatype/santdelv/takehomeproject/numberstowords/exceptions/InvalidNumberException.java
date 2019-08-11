package com.sonatype.santdelv.takehomeproject.numberstowords.exceptions;

/**
 * Custom exception to be thrown when a number is not deemed as a valid one for the NumberConverter
 */
public class InvalidNumberException extends Exception {

    public InvalidNumberException(String message) {
        super(message);
    }

}
