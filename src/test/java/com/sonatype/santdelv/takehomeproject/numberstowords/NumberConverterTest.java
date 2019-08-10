package com.sonatype.santdelv.takehomeproject.numberstowords;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sonatype.santdelv.takehomeproject.numberstowords.impl.NumberConverterImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberConverterTest {

    @Test
    @DisplayName("Test basic numbers from 0 to 20.")
    void addsTwoNumbers() {
        NumberConverter numberConverter = new NumberConverterImpl();
        assertEquals("Zero", numberConverter.getNumberAsWords(0));
        assertEquals("One", numberConverter.getNumberAsWords(1));
        assertEquals("Two", numberConverter.getNumberAsWords(2));
        assertEquals("Three", numberConverter.getNumberAsWords(3));
        assertEquals("Four", numberConverter.getNumberAsWords(4));
        assertEquals("Five", numberConverter.getNumberAsWords(5));
        assertEquals("Six", numberConverter.getNumberAsWords(6));
        assertEquals("Seven", numberConverter.getNumberAsWords(7));
        assertEquals("Eight", numberConverter.getNumberAsWords(8));
        assertEquals("Nine", numberConverter.getNumberAsWords(9));
        assertEquals("Ten", numberConverter.getNumberAsWords(10));
        assertEquals("Eleven", numberConverter.getNumberAsWords(11));
        assertEquals("Twelve", numberConverter.getNumberAsWords(12));
        assertEquals("Thirteen", numberConverter.getNumberAsWords(13));
        assertEquals("Fourteen", numberConverter.getNumberAsWords(14));
        assertEquals("Fifteen", numberConverter.getNumberAsWords(15));
        assertEquals("Sixteen", numberConverter.getNumberAsWords(16));
        assertEquals("Seventeen", numberConverter.getNumberAsWords(17));
        assertEquals("Eighteen", numberConverter.getNumberAsWords(18));
        assertEquals("Nineteen", numberConverter.getNumberAsWords(19));
        assertEquals("Twenty", numberConverter.getNumberAsWords(20));
    }
}
