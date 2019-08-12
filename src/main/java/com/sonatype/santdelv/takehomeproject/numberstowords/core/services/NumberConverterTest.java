package com.sonatype.santdelv.takehomeproject.numberstowords.core.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.sonatype.santdelv.takehomeproject.numberstowords.core.services.NumberConverter;
import com.sonatype.santdelv.takehomeproject.numberstowords.exceptions.InvalidNumberException;
import com.sonatype.santdelv.takehomeproject.numberstowords.exceptions.NumberOutOfRangeException;
import com.sonatype.santdelv.takehomeproject.numberstowords.core.services.impl.impl.NumberConverterImpl;
import com.sonatype.santdelv.takehomeproject.numberstowords.validators.impl.NumberStringValidatorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberConverterTest {

    @Test
    @DisplayName("Test basic numbers from 0 to 20.")
    void convertBasicNumbers() throws InvalidNumberException, NumberOutOfRangeException {
        NumberConverter numberConverter = new NumberConverterImpl(new NumberStringValidatorImpl());
        Assertions.assertEquals("Zero", numberConverter.getNumberAsWords("0"));
        Assertions.assertEquals("One", numberConverter.getNumberAsWords("1"));
        Assertions.assertEquals("Two", numberConverter.getNumberAsWords("2"));
        Assertions.assertEquals("Three", numberConverter.getNumberAsWords("3"));
        Assertions.assertEquals("Four", numberConverter.getNumberAsWords("4"));
        Assertions.assertEquals("Five", numberConverter.getNumberAsWords("5"));
        Assertions.assertEquals("Six", numberConverter.getNumberAsWords("6"));
        Assertions.assertEquals("Seven", numberConverter.getNumberAsWords("7"));
        Assertions.assertEquals("Eight", numberConverter.getNumberAsWords("8"));
        Assertions.assertEquals("Nine", numberConverter.getNumberAsWords("9"));
        Assertions.assertEquals("Ten", numberConverter.getNumberAsWords("10"));
        Assertions.assertEquals("Eleven", numberConverter.getNumberAsWords("11"));
        Assertions.assertEquals("Twelve", numberConverter.getNumberAsWords("12"));
        Assertions.assertEquals("Thirteen", numberConverter.getNumberAsWords("13"));
        Assertions.assertEquals("Fourteen", numberConverter.getNumberAsWords("14"));
        Assertions.assertEquals("Fifteen", numberConverter.getNumberAsWords("15"));
        Assertions.assertEquals("Sixteen", numberConverter.getNumberAsWords("16"));
        Assertions.assertEquals("Seventeen", numberConverter.getNumberAsWords("17"));
        Assertions.assertEquals("Eighteen", numberConverter.getNumberAsWords("18"));
        Assertions.assertEquals("Nineteen", numberConverter.getNumberAsWords("19"));
        Assertions.assertEquals("Twenty", numberConverter.getNumberAsWords("20"));
    }

    @Test
    @DisplayName("Test basic negative numbers from 0 to 20.")
    void convertBasicNegativeNumbers() throws InvalidNumberException, NumberOutOfRangeException {
        NumberConverter numberConverter = new NumberConverterImpl(new NumberStringValidatorImpl());
        Assertions.assertEquals("Zero", numberConverter.getNumberAsWords("-0"));
        Assertions.assertEquals("Negative one", numberConverter.getNumberAsWords("-1"));
        Assertions.assertEquals("Negative two", numberConverter.getNumberAsWords("-2"));
        Assertions.assertEquals("Negative three", numberConverter.getNumberAsWords("-3"));
        Assertions.assertEquals("Negative four", numberConverter.getNumberAsWords("-4"));
        Assertions.assertEquals("Negative five", numberConverter.getNumberAsWords("-5"));
        Assertions.assertEquals("Negative six", numberConverter.getNumberAsWords("-6"));
        Assertions.assertEquals("Negative seven", numberConverter.getNumberAsWords("-7"));
        Assertions.assertEquals("Negative eight", numberConverter.getNumberAsWords("-8"));
        Assertions.assertEquals("Negative nine", numberConverter.getNumberAsWords("-9"));
        Assertions.assertEquals("Negative ten", numberConverter.getNumberAsWords("-10"));
        Assertions.assertEquals("Negative eleven", numberConverter.getNumberAsWords("-11"));
        Assertions.assertEquals("Negative twelve", numberConverter.getNumberAsWords("-12"));
        Assertions.assertEquals("Negative thirteen", numberConverter.getNumberAsWords("-13"));
        Assertions.assertEquals("Negative fourteen", numberConverter.getNumberAsWords("-14"));
        Assertions.assertEquals("Negative fifteen", numberConverter.getNumberAsWords("-15"));
        Assertions.assertEquals("Negative sixteen", numberConverter.getNumberAsWords("-16"));
        Assertions.assertEquals("Negative seventeen", numberConverter.getNumberAsWords("-17"));
        Assertions.assertEquals("Negative eighteen", numberConverter.getNumberAsWords("-18"));
        Assertions.assertEquals("Negative nineteen", numberConverter.getNumberAsWords("-19"));
        Assertions.assertEquals("Negative twenty", numberConverter.getNumberAsWords("-20"));
    }

    @Test
    @DisplayName("Test rejection of invalid number Strings.")
    void throwErrorWithInvalidNumbers() throws InvalidNumberException {
        NumberConverter numberConverter = new NumberConverterImpl(new NumberStringValidatorImpl());
        Assertions.assertThrows(InvalidNumberException.class, () -> numberConverter.getNumberAsWords("foo"));
        Assertions.assertThrows(InvalidNumberException.class, () -> numberConverter.getNumberAsWords("123Foo"));
        Assertions.assertThrows(InvalidNumberException.class, () -> numberConverter.getNumberAsWords("foo123"));
        Assertions.assertThrows(InvalidNumberException.class, () -> numberConverter.getNumberAsWords("foo123foo"));
        Assertions.assertThrows(InvalidNumberException.class, () -> numberConverter.getNumberAsWords("-foo"));
        Assertions.assertThrows(InvalidNumberException.class, () -> numberConverter.getNumberAsWords("- foo"));
        Assertions.assertThrows(InvalidNumberException.class, () -> numberConverter.getNumberAsWords("--foo"));
        Assertions.assertThrows(InvalidNumberException.class, () -> numberConverter.getNumberAsWords("--123"));
        Assertions.assertThrows(InvalidNumberException.class, () -> numberConverter.getNumberAsWords("- 123foo"));
    }

    @Test
    @DisplayName("Test some numbers from 21 to 99")
    void convertNumbersFrom21To99() throws InvalidNumberException, NumberOutOfRangeException {
        NumberConverter numberConverter = new NumberConverterImpl(new NumberStringValidatorImpl());
        Assertions.assertEquals("Twenty one", numberConverter.getNumberAsWords("21"));
        Assertions.assertEquals("Twenty two", numberConverter.getNumberAsWords("22"));
        Assertions.assertEquals("Twenty three", numberConverter.getNumberAsWords("23"));
        Assertions.assertEquals("Twenty four", numberConverter.getNumberAsWords("24"));
        Assertions.assertEquals("Twenty five", numberConverter.getNumberAsWords("25"));
        Assertions.assertEquals("Twenty six", numberConverter.getNumberAsWords("26"));
        Assertions.assertEquals("Twenty seven", numberConverter.getNumberAsWords("27"));
        Assertions.assertEquals("Twenty eight", numberConverter.getNumberAsWords("28"));
        Assertions.assertEquals("Twenty nine", numberConverter.getNumberAsWords("29"));
        Assertions.assertEquals("Thirty one", numberConverter.getNumberAsWords("31"));
        Assertions.assertEquals("Thirty two", numberConverter.getNumberAsWords("32"));
        Assertions.assertEquals("Forty", numberConverter.getNumberAsWords("40"));
        Assertions.assertEquals("Forty three", numberConverter.getNumberAsWords("43"));
        Assertions.assertEquals("Fifty four", numberConverter.getNumberAsWords("54"));
        Assertions.assertEquals("Sixty five", numberConverter.getNumberAsWords("65"));
        Assertions.assertEquals("Seventy six", numberConverter.getNumberAsWords("76"));
        Assertions.assertEquals("Eighty seven", numberConverter.getNumberAsWords("87"));
        Assertions.assertEquals("Ninety eight", numberConverter.getNumberAsWords("98"));
        Assertions.assertEquals("Ninety nine", numberConverter.getNumberAsWords("99"));
    }

    @Test
    @DisplayName("Test some negative numbers from 21 to 99")
    void convertNegativeNumbersFrom21To99() throws InvalidNumberException, NumberOutOfRangeException {
        NumberConverter numberConverter = new NumberConverterImpl(new NumberStringValidatorImpl());
        Assertions.assertEquals("Negative twenty one", numberConverter.getNumberAsWords("-21"));
        Assertions.assertEquals("Negative thirty two", numberConverter.getNumberAsWords("-32"));
        Assertions.assertEquals("Negative forty", numberConverter.getNumberAsWords("-40"));
        Assertions.assertEquals("Negative forty three", numberConverter.getNumberAsWords("-43"));
        Assertions.assertEquals("Negative fifty four", numberConverter.getNumberAsWords("-54"));
        Assertions.assertEquals("Negative sixty five", numberConverter.getNumberAsWords("-65"));
        Assertions.assertEquals("Negative seventy six", numberConverter.getNumberAsWords("-76"));
        Assertions.assertEquals("Negative eighty seven", numberConverter.getNumberAsWords("-87"));
        Assertions.assertEquals("Negative ninety eight", numberConverter.getNumberAsWords("-98"));
        Assertions.assertEquals("Negative ninety nine", numberConverter.getNumberAsWords("-99"));
    }

    @Test
    @DisplayName("Test some numbers from 100 to 999")
    void convertNumbersFrom100To999() throws InvalidNumberException, NumberOutOfRangeException {
        NumberConverter numberConverter = new NumberConverterImpl(new NumberStringValidatorImpl());
        Assertions.assertEquals("One hundred and one", numberConverter.getNumberAsWords("101"));
        Assertions.assertEquals("One hundred and five", numberConverter.getNumberAsWords("105"));
        Assertions.assertEquals("One hundred and fifty five", numberConverter.getNumberAsWords("155"));
        Assertions.assertEquals("Two hundred and thirty four", numberConverter.getNumberAsWords("234"));
        Assertions.assertEquals("Three hundred and seventy six", numberConverter.getNumberAsWords("376"));
        Assertions.assertEquals("Four hundred and nineteen", numberConverter.getNumberAsWords("419"));
        Assertions.assertEquals("Five hundred and eleven", numberConverter.getNumberAsWords("511"));
        Assertions.assertEquals("Six hundred and forty seven", numberConverter.getNumberAsWords("647"));
        Assertions.assertEquals("Seven hundred and seventy seven", numberConverter.getNumberAsWords("777"));
        Assertions.assertEquals("Eight hundred and fifty three", numberConverter.getNumberAsWords("853"));
        Assertions.assertEquals("Nine hundred and thirty", numberConverter.getNumberAsWords("930"));
        Assertions.assertEquals("Nine hundred and ninety nine", numberConverter.getNumberAsWords("999"));
    }

    @Test
    @DisplayName("Test some numbers from 100 to 999")
    void convertNegativeNumbersFrom100To999() throws InvalidNumberException, NumberOutOfRangeException {
        NumberConverter numberConverter = new NumberConverterImpl(new NumberStringValidatorImpl());
        Assertions.assertEquals("Negative one hundred and one", numberConverter.getNumberAsWords("-101"));
        Assertions.assertEquals("Negative one hundred and five", numberConverter.getNumberAsWords("-105"));
        Assertions.assertEquals("Negative one hundred and fifty five", numberConverter.getNumberAsWords("-155"));
        Assertions.assertEquals("Negative two hundred and thirty four", numberConverter.getNumberAsWords("-234"));
        Assertions.assertEquals("Negative three hundred and seventy six", numberConverter.getNumberAsWords("-376"));
        Assertions.assertEquals("Negative four hundred and nineteen", numberConverter.getNumberAsWords("-419"));
        Assertions.assertEquals("Negative five hundred and eleven", numberConverter.getNumberAsWords("-511"));
        Assertions.assertEquals("Negative six hundred and forty seven", numberConverter.getNumberAsWords("-647"));
        Assertions.assertEquals("Negative seven hundred and seventy seven", numberConverter.getNumberAsWords("-777"));
        Assertions.assertEquals("Negative eight hundred and fifty three", numberConverter.getNumberAsWords("-853"));
        Assertions.assertEquals("Negative nine hundred and thirty", numberConverter.getNumberAsWords("-930"));
        Assertions.assertEquals("Negative nine hundred and ninety nine", numberConverter.getNumberAsWords("-999"));
    }

    @Test
    @DisplayName("Test some numbers from 1000 to 999999")
    void convertNumbersFrom1000To999999() throws InvalidNumberException, NumberOutOfRangeException {
        NumberConverter numberConverter = new NumberConverterImpl(new NumberStringValidatorImpl());
        Assertions.assertEquals("One thousand", numberConverter.getNumberAsWords("1000"));
        Assertions.assertEquals("One hundred thousand", numberConverter.getNumberAsWords("100000"));
        Assertions.assertEquals("One hundred thousand one", numberConverter.getNumberAsWords("100001"));
        Assertions.assertEquals("Eight hundred fifty three thousand three hundred", numberConverter.getNumberAsWords("853300"));
        Assertions.assertEquals("Nine hundred thirty thousand", numberConverter.getNumberAsWords("930000"));
        Assertions.assertEquals("Nine hundred thousand", numberConverter.getNumberAsWords("900000"));
        Assertions.assertEquals("Nine hundred ninety nine thousand nine hundred and ninety nine", numberConverter.getNumberAsWords("999999"));
    }

    @Test
    @DisplayName("Test some negative numbers from 1000 to 999999")
    void convertNegativeNumbersFrom1000To999999() throws InvalidNumberException, NumberOutOfRangeException {
        NumberConverter numberConverter = new NumberConverterImpl(new NumberStringValidatorImpl());
        Assertions.assertEquals("Negative one thousand", numberConverter.getNumberAsWords("-1000"));
        Assertions.assertEquals("Negative one hundred thousand", numberConverter.getNumberAsWords("-100000"));
        Assertions.assertEquals("Negative one hundred thousand one", numberConverter.getNumberAsWords("-100001"));
        Assertions.assertEquals("Negative eight hundred fifty three thousand three hundred", numberConverter.getNumberAsWords("-853300"));
        Assertions.assertEquals("Negative nine hundred thirty thousand", numberConverter.getNumberAsWords("-930000"));
        Assertions.assertEquals("Negative nine hundred thousand", numberConverter.getNumberAsWords("-900000"));
        Assertions.assertEquals("Negative nine hundred ninety nine thousand nine hundred and ninety nine", numberConverter.getNumberAsWords("-999999"));
    }

    @Test
    @DisplayName("Test some numbers from 1000000 to 999999999")
    void convertNumbersFrom1000000To999999999() throws InvalidNumberException, NumberOutOfRangeException {
        NumberConverter numberConverter = new NumberConverterImpl(new NumberStringValidatorImpl());
        Assertions.assertEquals("One million", numberConverter.getNumberAsWords("1000000"));
        Assertions.assertEquals("One million one", numberConverter.getNumberAsWords("1000001"));
        Assertions.assertEquals("One million two hundred fifty thousand", numberConverter.getNumberAsWords("1250000"));
        Assertions.assertEquals("Nine hundred ninety nine million nine hundred ninety nine thousand nine hundred and ninety nine", numberConverter.getNumberAsWords("999999999"));
    }

    @Test
    @DisplayName("Test some  negativenumbers from 1000000 to 999999999")
    void convertNegativeNumbersFrom1000000To999999999() throws InvalidNumberException, NumberOutOfRangeException {
        NumberConverter numberConverter = new NumberConverterImpl(new NumberStringValidatorImpl());
        Assertions.assertEquals("Negative one million", numberConverter.getNumberAsWords("-1000000"));
        Assertions.assertEquals("Negative one million one", numberConverter.getNumberAsWords("-1000001"));
        Assertions.assertEquals("Negative one million two hundred fifty thousand", numberConverter.getNumberAsWords("-1250000"));
        Assertions.assertEquals("Negative nine hundred ninety nine million nine hundred ninety nine thousand nine hundred and ninety nine", numberConverter.getNumberAsWords("-999999999"));
    }

    @Test
    @DisplayName("Test some numbers from 1000000000 to 21147483647")
    void convertNumbersFrom1000000000() throws InvalidNumberException, NumberOutOfRangeException {
        NumberConverter numberConverter = new NumberConverterImpl(new NumberStringValidatorImpl());
        Assertions.assertEquals("One billion", numberConverter.getNumberAsWords("1000000000"));
        Assertions.assertEquals("One billion one", numberConverter.getNumberAsWords("1000000001"));
        Assertions.assertEquals("Two billion one hundred forty seven million four hundred eighty three thousand six hundred and forty seven", numberConverter.getNumberAsWords("2147483647"));
    }

    @Test
    @DisplayName("Test some negative numbers from 1000000000 to 21147483647")
    void convertNegativeNumbersFrom1000000000() throws InvalidNumberException, NumberOutOfRangeException {
        NumberConverter numberConverter = new NumberConverterImpl(new NumberStringValidatorImpl());
        Assertions.assertEquals("Negative one billion", numberConverter.getNumberAsWords("-1000000000"));
        Assertions.assertEquals("Negative one billion one", numberConverter.getNumberAsWords("-1000000001"));
        Assertions.assertEquals("Negative two billion one hundred forty seven million four hundred eighty three thousand six hundred and forty eight", numberConverter.getNumberAsWords("-2147483648"));
    }
}
