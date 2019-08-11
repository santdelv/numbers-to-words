package com.sonatype.santdelv.takehomeproject.numberstowords;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.sonatype.santdelv.takehomeproject.numberstowords.exceptions.InvalidNumberException;
import com.sonatype.santdelv.takehomeproject.numberstowords.impl.NumberConverterImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberConverterTest {

    @Test
    @DisplayName("Test basic numbers from 0 to 20.")
    void convertBasicNumbers() throws InvalidNumberException {
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
    @DisplayName("Test basic negative numbers from 0 to 20.")
    void convertBasicNegativeNumbers() throws InvalidNumberException {
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

    @Test
    @DisplayName("Test rejection of invalid number Strings.")
    void throwErrorWithInvalidNumbers() throws InvalidNumberException {
        NumberConverter numberConverter = new NumberConverterImpl();
        assertThrows(InvalidNumberException.class, () -> numberConverter.getNumberAsWords("foo"));
        assertThrows(InvalidNumberException.class, () -> numberConverter.getNumberAsWords("123Foo"));
        assertThrows(InvalidNumberException.class, () -> numberConverter.getNumberAsWords("foo123"));
        assertThrows(InvalidNumberException.class, () -> numberConverter.getNumberAsWords("foo123foo"));
        assertThrows(InvalidNumberException.class, () -> numberConverter.getNumberAsWords("-foo"));
        assertThrows(InvalidNumberException.class, () -> numberConverter.getNumberAsWords("- foo"));
        assertThrows(InvalidNumberException.class, () -> numberConverter.getNumberAsWords("--foo"));
        assertThrows(InvalidNumberException.class, () -> numberConverter.getNumberAsWords("--123"));
        assertThrows(InvalidNumberException.class, () -> numberConverter.getNumberAsWords("- 123foo"));
    }

    @Test
    @DisplayName("Test some numbers from 21 to 99")
    void convertNumbersFrom21To99() throws InvalidNumberException {
        NumberConverter numberConverter = new NumberConverterImpl();
        assertEquals("Twenty one", numberConverter.getNumberAsWords("21"));
        assertEquals("Twenty two", numberConverter.getNumberAsWords("22"));
        assertEquals("Twenty three", numberConverter.getNumberAsWords("23"));
        assertEquals("Twenty four", numberConverter.getNumberAsWords("24"));
        assertEquals("Twenty five", numberConverter.getNumberAsWords("25"));
        assertEquals("Twenty six", numberConverter.getNumberAsWords("26"));
        assertEquals("Twenty seven", numberConverter.getNumberAsWords("27"));
        assertEquals("Twenty eight", numberConverter.getNumberAsWords("28"));
        assertEquals("Twenty nine", numberConverter.getNumberAsWords("29"));
        assertEquals("Thirty one", numberConverter.getNumberAsWords("31"));
        assertEquals("Thirty two", numberConverter.getNumberAsWords("32"));
        assertEquals("Forty", numberConverter.getNumberAsWords("40"));
        assertEquals("Forty three", numberConverter.getNumberAsWords("43"));
        assertEquals("Fifty four", numberConverter.getNumberAsWords("54"));
        assertEquals("Sixty five", numberConverter.getNumberAsWords("65"));
        assertEquals("Seventy six", numberConverter.getNumberAsWords("76"));
        assertEquals("Eighty seven", numberConverter.getNumberAsWords("87"));
        assertEquals("Ninety eight", numberConverter.getNumberAsWords("98"));
        assertEquals("Ninety nine", numberConverter.getNumberAsWords("99"));
    }

    @Test
    @DisplayName("Test some negative numbers from 21 to 99")
    void convertNegativeNumbersFrom21To99() throws InvalidNumberException {
        NumberConverter numberConverter = new NumberConverterImpl();
        assertEquals("Negative twenty one", numberConverter.getNumberAsWords("-21"));
        assertEquals("Negative thirty two", numberConverter.getNumberAsWords("-32"));
        assertEquals("Negative forty", numberConverter.getNumberAsWords("-40"));
        assertEquals("Negative forty three", numberConverter.getNumberAsWords("-43"));
        assertEquals("Negative fifty four", numberConverter.getNumberAsWords("-54"));
        assertEquals("Negative sixty five", numberConverter.getNumberAsWords("-65"));
        assertEquals("Negative seventy six", numberConverter.getNumberAsWords("-76"));
        assertEquals("Negative eighty seven", numberConverter.getNumberAsWords("-87"));
        assertEquals("Negative ninety eight", numberConverter.getNumberAsWords("-98"));
        assertEquals("Negative ninety nine", numberConverter.getNumberAsWords("-99"));
    }

    @Test
    @DisplayName("Test some numbers from 100 to 999")
    void convertNumbersFrom100To999() throws InvalidNumberException {
        NumberConverter numberConverter = new NumberConverterImpl();
        assertEquals("One hundred and one", numberConverter.getNumberAsWords("101"));
        assertEquals("One hundred and five", numberConverter.getNumberAsWords("105"));
        assertEquals("One hundred and fifty five", numberConverter.getNumberAsWords("155"));
        assertEquals("Two hundred and thirty four", numberConverter.getNumberAsWords("234"));
        assertEquals("Three hundred and seventy six", numberConverter.getNumberAsWords("376"));
        assertEquals("Four hundred and nineteen", numberConverter.getNumberAsWords("419"));
        assertEquals("Five hundred and eleven", numberConverter.getNumberAsWords("511"));
        assertEquals("Six hundred and forty seven", numberConverter.getNumberAsWords("647"));
        assertEquals("Seven hundred and seventy seven", numberConverter.getNumberAsWords("777"));
        assertEquals("Eight hundred and fifty three", numberConverter.getNumberAsWords("853"));
        assertEquals("Nine hundred and thirty", numberConverter.getNumberAsWords("930"));
        assertEquals("Nine hundred and ninety nine", numberConverter.getNumberAsWords("999"));
    }

    @Test
    @DisplayName("Test some numbers from 100 to 999")
    void convertNegativeNumbersFrom100To999() throws InvalidNumberException {
        NumberConverter numberConverter = new NumberConverterImpl();
        assertEquals("Negative one hundred and one", numberConverter.getNumberAsWords("-101"));
        assertEquals("Negative one hundred and five", numberConverter.getNumberAsWords("-105"));
        assertEquals("Negative one hundred and fifty five", numberConverter.getNumberAsWords("-155"));
        assertEquals("Negative two hundred and thirty four", numberConverter.getNumberAsWords("-234"));
        assertEquals("Negative three hundred and seventy six", numberConverter.getNumberAsWords("-376"));
        assertEquals("Negative four hundred and nineteen", numberConverter.getNumberAsWords("-419"));
        assertEquals("Negative five hundred and eleven", numberConverter.getNumberAsWords("-511"));
        assertEquals("Negative six hundred and forty seven", numberConverter.getNumberAsWords("-647"));
        assertEquals("Negative seven hundred and seventy seven", numberConverter.getNumberAsWords("-777"));
        assertEquals("Negative eight hundred and fifty three", numberConverter.getNumberAsWords("-853"));
        assertEquals("Negative nine hundred and thirty", numberConverter.getNumberAsWords("-930"));
        assertEquals("Negative nine hundred and ninety nine", numberConverter.getNumberAsWords("-999"));
    }
}
