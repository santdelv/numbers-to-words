package com.sonatype.santdelv.takehomeproject.numberstowords.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringOperationsTest {

    @Test
    @DisplayName("Test String capitalization")
    void capitalizeSentences() {
        assertEquals("Zero", StringOperations.getCapitalizedString("zero"));
        assertEquals("One phrase", StringOperations.getCapitalizedString("one phrase"));
        assertEquals("ALL CAPS", StringOperations.getCapitalizedString("ALL CAPS"));
        assertEquals("Three words", StringOperations.getCapitalizedString("three words"));
    }

    @Test
    @DisplayName("Test String capitalization with null")
    void capitalizeNull() {
        assertEquals(null, StringOperations.getCapitalizedString(null));
    }

    @Test
    @DisplayName("Test String capitalization with empty string")
    void capitalizeEmptyString() {
        assertEquals("", StringOperations.getCapitalizedString(""));
    }

    @Test
    @DisplayName("Test String capitalization with string with blank spaces")
    void capitalizeBlankSpaceString() {
        assertEquals(" ", StringOperations.getCapitalizedString(" "));
        assertEquals("  ", StringOperations.getCapitalizedString("  "));
    }


    @Test
    @DisplayName("Test Separating in Three character segments if less than 3")
    void getThreeCharacterSegmentsLessThanThreeCharacters() {
        List<String> segments = StringOperations.getCharacterSegments("h", 3);
        assertEquals(1, segments.size());
        assertEquals("h", segments.get(0));
        segments = StringOperations.getCharacterSegments("he", 3);
        assertEquals(1, segments.size());
        assertEquals("he", segments.get(0));
    }

    @Test
    @DisplayName("Test Separating in Three character segments if exactly 3")
    void getThreeCharacterSegmentsEqualThreeCharacters() {
        List<String> segments = StringOperations.getCharacterSegments("hel", 3);
        assertEquals(1, segments.size());
        assertEquals("hel", segments.get(0));
    }

    @Test
    @DisplayName("Test Separating in Three character segments if more than 3")
    void getThreeCharacterSegmentsMoreThanThreeCharacters() {
        List<String> segments = StringOperations.getCharacterSegments("hello", 3);
        assertEquals(2, segments.size());
        assertEquals("he", segments.get(0));
        assertEquals("llo", segments.get(1));
        segments = StringOperations.getCharacterSegments("hello world", 3);
        assertEquals(4, segments.size());
        assertEquals("he", segments.get(0));
        assertEquals("llo", segments.get(1));
        assertEquals(" wo", segments.get(2));
        assertEquals("rld", segments.get(3));
    }

    @Test
    @DisplayName("Test Separating in Three character segments if null")
    void getThreeCharacterSegmentsNullString() {
        List<String> segments = StringOperations.getCharacterSegments(null, 0);
        assertEquals(null, segments);
    }

    //Missing cases for reversed String
}
