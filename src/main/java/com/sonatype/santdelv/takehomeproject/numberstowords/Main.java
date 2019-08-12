package com.sonatype.santdelv.takehomeproject.numberstowords;

import com.sonatype.santdelv.takehomeproject.numberstowords.controllers.NumberConverterController;
import com.sonatype.santdelv.takehomeproject.numberstowords.core.services.impl.impl.NumberConverterImpl;
import com.sonatype.santdelv.takehomeproject.numberstowords.validators.impl.NumberStringValidatorImpl;

/**
 * Initializes our spark server.
 */
public class Main {
    public static void main(String[] args) {
        new NumberConverterController(new NumberConverterImpl(new NumberStringValidatorImpl()));
    }
}
