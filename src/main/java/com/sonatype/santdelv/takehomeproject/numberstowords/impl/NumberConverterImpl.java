package com.sonatype.santdelv.takehomeproject.numberstowords.impl;

import com.sonatype.santdelv.takehomeproject.numberstowords.NumberConverter;
import com.sonatype.santdelv.takehomeproject.numberstowords.exceptions.InvalidNumberException;
import com.sonatype.santdelv.takehomeproject.numberstowords.validators.NumberStringValidator;
import com.sonatype.santdelv.takehomeproject.numberstowords.validators.impl.NumberStringValidatorImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NumberConverterImpl implements NumberConverter {

    private static final String NEGATIVE_PREFIX = "Negative";
    // TODO see if we can put some DI mechanism here if we have time
    private NumberStringValidator numberStringValidator = new NumberStringValidatorImpl();

    private static final Map<Integer, String> numberBuildingBlocks;
    static {
        Map<Integer, String> intializerMap = new HashMap<Integer, String>();
        intializerMap.put(0, "zero");
        intializerMap.put(1, "one");
        intializerMap.put(2, "two");
        intializerMap.put(3, "three");
        intializerMap.put(4, "four");
        intializerMap.put(5, "five");
        intializerMap.put(6, "six");
        intializerMap.put(7, "seven");
        intializerMap.put(8, "eight");
        intializerMap.put(9, "nine");
        intializerMap.put(10, "ten");
        intializerMap.put(11, "eleven");
        intializerMap.put(12, "twelve");
        intializerMap.put(13, "thirteen");
        intializerMap.put(14, "fourteen");
        intializerMap.put(15, "fifteen");
        intializerMap.put(16, "sixteen");
        intializerMap.put(17, "seventeen");
        intializerMap.put(18, "eighteen");
        intializerMap.put(19, "nineteen");
        intializerMap.put(20, "twenty");
        intializerMap.put(30, "thirty");
        intializerMap.put(40, "forty");
        intializerMap.put(50, "fifty");
        intializerMap.put(60, "sixty");
        intializerMap.put(70, "seventy");
        intializerMap.put(80, "eighty");
        intializerMap.put(90, "ninety");
        intializerMap.put(100, "hundred");
        intializerMap.put(1000, "thousand");
        intializerMap.put(1000000, "million");
        intializerMap.put(1000000000, "billion");
        numberBuildingBlocks = Collections.unmodifiableMap(intializerMap);
    }

    public String getNumberAsWords(String number) throws InvalidNumberException {

        numberStringValidator.validateNumber(number);
        boolean isNegativeNumber = isNegative(number);
        String numberAsWords = "";

        //TODO a lot of conditionals, will need a refactor shortly
        if(isNegativeNumber) {
            number = cleanUpNegativePrefix(number);
        }

        Integer numberValue = Integer.valueOf(number);
        if (numberValue <= 20) {
            numberAsWords = numberBuildingBlocks.get(Integer.valueOf(number));
        }

        if (numberValue < 100 && numberValue > 20) {
            numberAsWords = getNumberLowerThanOneHundred(numberValue);
        }

        if (isNegativeNumber && !"zero".equals(numberAsWords)){
            numberAsWords = NEGATIVE_PREFIX + " " + numberAsWords;
        }
        return numberAsWords.substring(0, 1).toUpperCase() + numberAsWords.substring(1);
    }

    private boolean isNegative(String number){
        return number.startsWith("-");
    }

    /**
     * Given a number lower than hundred and bigger than twenty converts it to words in english.
     * First we get its lower multiple of 10, get the word that represents it and concatenate with the
     * remainder of the given number minus the nearest decimal divisor.
     * @param numberValue number we want to convert.
     * @return The number representation in english words
     */
    private String getNumberLowerThanOneHundred(int numberValue) {
        String numberAsWords;
        String basicNumberPart = "";
        int biggestTenMultiple = (int)Math.floor(numberValue/10) * 10;
        String tensPartOfNumber = numberBuildingBlocks.get(biggestTenMultiple);
        int remainder = numberValue - biggestTenMultiple;
        if(remainder > 0) {
            basicNumberPart = numberBuildingBlocks.get(numberValue - biggestTenMultiple);
        }
        numberAsWords =  tensPartOfNumber + " " + basicNumberPart;
        return numberAsWords.trim();
    }

    private String cleanUpNegativePrefix(String number) {
        return number.substring(1).trim();
    }
}
