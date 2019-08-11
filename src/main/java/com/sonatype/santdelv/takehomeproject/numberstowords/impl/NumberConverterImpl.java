package com.sonatype.santdelv.takehomeproject.numberstowords.impl;

import com.sonatype.santdelv.takehomeproject.numberstowords.NumberConverter;
import com.sonatype.santdelv.takehomeproject.numberstowords.exceptions.InvalidNumberException;
import com.sonatype.santdelv.takehomeproject.numberstowords.exceptions.NumberOutOfRangeException;
import com.sonatype.santdelv.takehomeproject.numberstowords.validators.NumberStringValidator;
import static com.sonatype.santdelv.takehomeproject.numberstowords.utils.StringOperations.*;

import java.util.*;

public class NumberConverterImpl implements NumberConverter {

    private static final String NEGATIVE_PREFIX = "Negative";

    private final NumberStringValidator numberStringValidator;

    public NumberConverterImpl (NumberStringValidator numberStringValidator) {
        this.numberStringValidator = numberStringValidator;

    }

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
        numberBuildingBlocks = Collections.unmodifiableMap(intializerMap);
    }

    private final static String[] MAGNITUDES = {"hundred", "thousand", "million", "billion"};

    public String getNumberAsWords(String number) throws InvalidNumberException, NumberOutOfRangeException {

        numberStringValidator.validateNumber(number);
        boolean isNegativeNumber = isNegative(number);
        String numberAsWords = "";

        if(isNegativeNumber) {
            number = cleanUpNegativePrefix(number);
        }

        Integer numberValue = Integer.valueOf(number);

        if (numberValue <= 20) {
            numberAsWords = numberBuildingBlocks.get(Integer.valueOf(numberValue));
        }

        if (numberValue > 20){
            numberAsWords = getNonBasicNumber(number);
        }

        if (isNegativeNumber && !"zero".equals(numberAsWords)){
            numberAsWords = NEGATIVE_PREFIX + " " + numberAsWords;
        }
        return getCapitalizedString(numberAsWords);
    }

    private String getNonBasicNumber(String number) {
        List<String> segments = getCharacterSegmentsReversed(number, 3);
        StringBuilder numberSegmentsWords = new StringBuilder();

        for (int i = segments.size(); i > 0 ; i--) {
            // hundreds is a special case because of the and
            int currentNumber = Integer.valueOf(segments.get(i -1));
            if(i == 1 && currentNumber > 0) {
                numberSegmentsWords.append(getHundredsNumber(currentNumber, " and ", ""));
                continue;
            }
            if(currentNumber > 0){
                numberSegmentsWords.append(getHundredsNumber(Integer.valueOf(segments.get(i - 1)), " ", MAGNITUDES[i-1]));
                numberSegmentsWords.append(" ");
            }
        }
        String result = numberSegmentsWords.toString().trim();
        return result;
    }

    private boolean isNegative(String number){
        return number.startsWith("-");
    }

    private String getHundredsNumber(int numberValue, String separator, String magnitude) {
        String numberAsWords;
        if (numberValue <= 20) {
            numberAsWords = numberBuildingBlocks.get(Integer.valueOf(numberValue)) + " " + magnitude;
            return numberAsWords.trim();
        }

        String hundredsPartOfNumber = "";
        int biggestHundredNumber = (int)Math.floor(numberValue/100);
        String notHundredsPartOfNumber = getNumberLowerThan100(numberValue - (biggestHundredNumber * 100));
        if (notHundredsPartOfNumber.isEmpty()) {
            separator = "";
        }
        if (biggestHundredNumber > 0) {
            hundredsPartOfNumber = numberBuildingBlocks.get(biggestHundredNumber) + " " + "hundred" + separator;
        }
        numberAsWords =  (hundredsPartOfNumber + notHundredsPartOfNumber + " ").trim() + " " + magnitude;
        return numberAsWords.trim();
    }

    private String getNumberLowerThan100(int numberValue){

        String tensPartOfNumber = "";
        String basicNumberPart = "";
        int remainder;
        int biggestTenMultiple = (int)Math.floor(numberValue/10) * 10;
        if (biggestTenMultiple > 0 && biggestTenMultiple >= 20) {
            tensPartOfNumber = numberBuildingBlocks.get(biggestTenMultiple);
            remainder = numberValue - biggestTenMultiple;
        } else {
            remainder = numberValue;
        }
        if(remainder > 0) {
            basicNumberPart = numberBuildingBlocks.get(remainder);
        }
        return (tensPartOfNumber + " " + basicNumberPart).trim();
    }

    private String cleanUpNegativePrefix(String number) {
        return number.substring(1).trim();
    }
}
