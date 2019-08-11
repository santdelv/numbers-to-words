package com.sonatype.santdelv.takehomeproject.numberstowords.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringOperations {

    /**
     * Capitalizes the first letter of a given String
     * @param sentence
     * @return The capitalized sentence, null if null, empty String if Empty String
     */
    public static String getCapitalizedString(String sentence) {
        if (sentence == null) {
            return null;
        }
        if ("".equals(sentence)) {
            return "";
        }
        return sentence.substring(0, 1).toUpperCase() + sentence.substring(1);
    }

    /**
     * Splits a String in segments of the given number, reverses the result
     * @param sentence Sentence we want to split
     * @return
     */
    public static List<String> getCharacterSegmentsReversed(String sentence, int segmentNumber) {

        List<String> segments = getCharacterSegments(sentence, segmentNumber);
        Collections.reverse(segments);
        return segments;
    }

    /**
     * Splits a String into segments of the given number, the first segment is less than the segmentNumber if the String
     * given is not a multiple of segmentNumber.
     * @param sentence The sentence we want to split
     * @return A list of Strings segmented in three character sections
     */
    public static List<String> getCharacterSegments(String sentence, int segmentNumber) {

        if (sentence == null) {
            return null;
        }

        List<String> segments = new ArrayList<>();
        String segment;

        if (sentence.length() <= segmentNumber) {
            segments.add(sentence);
            return segments;
        }

        int segmentSize = sentence.length() %segmentNumber;
        if(segmentSize == 0){
            segmentSize = segmentNumber;
        }

        // First segment could be especial so we process it outside of the loop
        segment = sentence.substring(0, segmentSize);
        segments.add(segment);
        sentence = sentence.substring(segmentSize);
        segmentSize = segmentNumber;

        while (sentence.length() != 0) {
            segment = sentence.substring(0, segmentSize);
            segments.add(segment);
            sentence = sentence.substring(segmentSize);
        }

        return segments;
    }
}
