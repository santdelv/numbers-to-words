package com.sonatype.santdelv.takehomeproject.numberstowords.core.services.impl.impl;

import com.sonatype.santdelv.takehomeproject.numberstowords.core.services.NumberConverter;
import com.sonatype.santdelv.takehomeproject.numberstowords.exceptions.InvalidNumberException;
import com.sonatype.santdelv.takehomeproject.numberstowords.exceptions.NumberOutOfRangeException;
import com.sonatype.santdelv.takehomeproject.numberstowords.validators.NumberStringValidator;
import static com.sonatype.santdelv.takehomeproject.numberstowords.utils.StringOperations.*;

import java.util.*;

/**
 * Implementation of NumberConverter, converts numbers in a numerical format to its representation in english words.
 */
public class NumberConverterImpl implements NumberConverter {

    // Prefix used for negative numbers
    private static final String NEGATIVE_PREFIX = "Negative";
    // Prefix to indicate negative numbers
    public static final String MINUS_SIGN = "-";
    public static final String HUNDRED = "hundred";
    public static final String AND_CONNECTOR = " and ";
    public static final int A_HUNDRED_INT = 100;
    public static final int TWENTY_INT = 20;

    // Validator used to check if the given numbers as Strings are valid and can be converted.
    private final NumberStringValidator numberStringValidator;

    /**
     * Constructor that injects the NumberStringValidator used for this implementation.
     * @param numberStringValidator service to validate if the number Strings are valid.
     */
    public NumberConverterImpl (NumberStringValidator numberStringValidator) {
        this.numberStringValidator = numberStringValidator;

    }

    // Map that defines the basic building blocks of numbers in english
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

    // Array with the magnitudes supported by this converter
    private final static String[] MAGNITUDES = {"hundred", "thousand", "million", "billion"};

    /**
     * Converts a number given by an it to its equivalent in english words.
     * @param number The number we want to convert.
     * @return The given number expressed in english words.
     */
    public String getNumberAsWords(String number) throws InvalidNumberException, NumberOutOfRangeException {

        numberStringValidator.validateNumber(number);
        boolean isNegativeNumber = isNegative(number);
        String numberAsWords;

        if(isNegativeNumber) {
            number = cleanUpNegativePrefix(number);
        }

        double numberValue = Double.parseDouble(number);

        if (numberValue < 20) {
            numberAsWords = numberBuildingBlocks.get(Integer.parseInt(number));
        }else {
            numberAsWords = getNonBasicNumber(number);
        }

        if (isNegativeNumber && !"zero".equals(numberAsWords)){
            numberAsWords = NEGATIVE_PREFIX + " " + numberAsWords;
        }
        return getCapitalizedString(numberAsWords);
    }

    /**
     * Obtains a non basic number (non basic numbers are bigger than twenty for our case).
     * Segments the String in sections of three, process them and concatenates.
     * @param number A number bigger than 20.
     * @return The non basic number as english word
     */
    private String getNonBasicNumber(String number) {
        List<String> segments = getCharacterSegmentsReversed(number, 3);
        StringBuilder numberSegmentsWords = new StringBuilder();

        for (int i = segments.size(); i > 0 ; i--) {
            // hundreds is a special case because of the and
            int currentNumber = Integer.parseInt(segments.get(i -1));
            if(i == 1 && currentNumber > 0) {
                numberSegmentsWords.append(getHundredsNumber(currentNumber, AND_CONNECTOR, ""));
                continue;
            }
            if(currentNumber > 0){
                numberSegmentsWords.append(getHundredsNumber(Integer.parseInt(segments.get(i - 1)), " ", MAGNITUDES[i-1]));
                numberSegmentsWords.append(" ");
            }
        }
        String nonBasicNumberString = numberSegmentsWords.toString().trim();
        return nonBasicNumberString;
    }

    /**
     * Checks if a number is negative or not determined byt its use of a minus sign.
     * @param number String representation of a number
     * @return true if the number string starts with the minus sign
     */
    private boolean isNegative(String number){
        return number.startsWith(MINUS_SIGN);
    }

    /**
     * Converts any three digit number to english words, adds its magnitude if needed.
     * @param numberValue The value of the number.
     * @param separator The separator, could be and or a space, and its only used in the last hundreds value.
     * @param magnitude The magnitude of the number.
     * @return The representation of the number in english words.
     */
    private String getHundredsNumber(int numberValue, String separator, String magnitude) {
        String numberAsWords;
        if (numberValue <= 20) {
            numberAsWords = numberBuildingBlocks.get(Integer.valueOf(numberValue)) + " " + magnitude;
            return numberAsWords.trim();
        }

        String hundredsPartOfNumber = "";
        int biggestHundredNumber = (int)Math.floor(numberValue/ A_HUNDRED_INT);
        String notHundredsPartOfNumber = getNumberLowerThan100(numberValue - (biggestHundredNumber * A_HUNDRED_INT));
        if (notHundredsPartOfNumber.isEmpty()) {
            separator = "";
        }
        if (biggestHundredNumber > 0) {
            hundredsPartOfNumber = numberBuildingBlocks.get(biggestHundredNumber) + " " + HUNDRED + separator;
        }
        numberAsWords =  (hundredsPartOfNumber + notHundredsPartOfNumber + " ").trim() + " " + magnitude;
        return numberAsWords.trim();
    }

    /**
     * Converts a number lower than one hundred to engliush words.
     * @param numberValue A number kess than 99.
     * @return The number representation in english wortds.
     */
    private String getNumberLowerThan100(int numberValue){

        String tensPartOfNumber = "";
        String basicNumberPart = "";
        int remainder;
        int biggestTenMultiple = (int)Math.floor(numberValue/10) * 10;
        if (biggestTenMultiple > 0 && biggestTenMultiple >= TWENTY_INT) {
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

    /**
     * Cleans up the negative prefix from a number String.
     * @param number number that starts with the minus sign.
     * @return The number without the minus sign or blank spaces.
     */
    private String cleanUpNegativePrefix(String number) {
        return number.substring(1).trim();
    }
}
