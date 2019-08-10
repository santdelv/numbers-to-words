package com.sonatype.santdelv.takehomeproject.numberstowords.impl;

import com.sonatype.santdelv.takehomeproject.numberstowords.NumberConverter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NumberConverterImpl implements NumberConverter {

    private static final String NEGATIVE_PREFIX = "Negative";

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
        numberBuildingBlocks = Collections.unmodifiableMap(intializerMap);
    }

    public String getNumberAsWords(String number) {

        number = number.trim();
        boolean isNegativeNumber = isNegative(number);

        if(isNegativeNumber) {
            number = cleanUpNegativePrefix(number);
        }

        String numberAsWords = numberBuildingBlocks.get(Integer.valueOf(number));
        if (isNegativeNumber && !"zero".equals(numberAsWords)){
            numberAsWords = NEGATIVE_PREFIX + " " + numberAsWords;
        }
        return numberAsWords.substring(0, 1).toUpperCase() + numberAsWords.substring(1);
    }

    private boolean isNegative(String number){
        return number.startsWith("-");
    }

    private String cleanUpNegativePrefix(String number) {
        return number.substring(1).trim();
    }
}
