package com.sonatype.santdelv.takehomeproject.numberstowords;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sonatype.santdelv.takehomeproject.numberstowords.impl.NumberConverterImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberConverterTest {

    @Test
    @DisplayName("Test basic numbers from 0 to 20.")
    void convertBasicNumbers() {
        NumberConverter numberConverter = new NumberConverterImpl();
        assertEquals("Zero", numberConverter.getNumberAsWords("0"));
        assertEquals("One", numberConverter.getNumberAsWords("1"));
        assertEquals("Two", numberConverter.getNumberAsWords("2"));
        assertEquals("Three", numberConverter.getNumberAsWords("3"));
        assertEquals("Four", numberConverter.getNumberAsWords("4"));
        assertEquals("Five", numberConverter.getNumberAsWords("5"));
        assertEquals("Six", numberConverter.getNumberAsWords("6"));
        assertEquals("Seven", numberConverter.getNumberAsWords("7"));
        assertEquals("Eight", numberConverter.getNumberAsWords("8"));
        assertEquals("Nine", numberConverter.getNumberAsWords("9"));
        assertEquals("Ten", numberConverter.getNumberAsWords("10"));
        assertEquals("Eleven", numberConverter.getNumberAsWords("11"));
        assertEquals("Twelve", numberConverter.getNumberAsWords("12"));
        assertEquals("Thirteen", numberConverter.getNumberAsWords("13"));
        assertEquals("Fourteen", numberConverter.getNumberAsWords("14"));
        assertEquals("Fifteen", numberConverter.getNumberAsWords("15"));
        assertEquals("Sixteen", numberConverter.getNumberAsWords("16"));
        assertEquals("Seventeen", numberConverter.getNumberAsWords("17"));
        assertEquals("Eighteen", numberConverter.getNumberAsWords("18"));
        assertEquals("Nineteen", numberConverter.getNumberAsWords("19"));
        assertEquals("Twenty", numberConverter.getNumberAsWords("20"));
    }

    @Test
    @DisplayName("Test basic numbers from 0 to 20.")
    void convertBasicNegativeNumbers() {
        NumberConverter numberConverter = new NumberConverterImpl();
        assertEquals("Zero", numberConverter.getNumberAsWords("-0"));
        assertEquals("Negative one", numberConverter.getNumberAsWords("-1"));
        assertEquals("Negative two", numberConverter.getNumberAsWords("-2"));
        assertEquals("Negative three", numberConverter.getNumberAsWords("-3"));
        assertEquals("Negative four", numberConverter.getNumberAsWords("-4"));
        assertEquals("Negative five", numberConverter.getNumberAsWords("-5"));
        assertEquals("Negative six", numberConverter.getNumberAsWords("-6"));
        assertEquals("Negative seven", numberConverter.getNumberAsWords("-7"));
        assertEquals("Negative eight", numberConverter.getNumberAsWords("-8"));
        assertEquals("Negative nine", numberConverter.getNumberAsWords("-9"));
        assertEquals("Negative ten", numberConverter.getNumberAsWords("-10"));
        assertEquals("Negative eleven", numberConverter.getNumberAsWords("-11"));
        assertEquals("Negative twelve", numberConverter.getNumberAsWords("-12"));
        assertEquals("Negative thirteen", numberConverter.getNumberAsWords("-13"));
        assertEquals("Negative fourteen", numberConverter.getNumberAsWords("-14"));
        assertEquals("Negative fifteen", numberConverter.getNumberAsWords("-15"));
        assertEquals("Negative sixteen", numberConverter.getNumberAsWords("-16"));
        assertEquals("Negative seventeen", numberConverter.getNumberAsWords("-17"));
        assertEquals("Negative eighteen", numberConverter.getNumberAsWords("-18"));
        assertEquals("Negative nineteen", numberConverter.getNumberAsWords("-19"));
        assertEquals("Negative twenty", numberConverter.getNumberAsWords("-20"));
    }
}
