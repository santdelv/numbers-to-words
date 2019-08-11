package com.sonatype.santdelv.takehomeproject.numberstowords;

import com.sonatype.santdelv.takehomeproject.numberstowords.controllers.NumberConverterController;
import com.sonatype.santdelv.takehomeproject.numberstowords.impl.NumberConverterImpl;
import com.sonatype.santdelv.takehomeproject.numberstowords.validators.impl.NumberStringValidatorImpl;
import org.eclipse.jetty.client.HttpResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static spark.Spark.awaitInitialization;
import static spark.Spark.stop;


public class NumberConverterControllerTest {

    NumberConverterController numberConverterController;

    @BeforeEach
    public void setUp() throws Exception {
        NumberConverterController numberConverterController = new NumberConverterController(new NumberConverterImpl(new NumberStringValidatorImpl()));
        awaitInitialization();

    }

    @AfterEach
    public void tearDown() throws Exception {
        stop();
    }

    @Test
    public void testModelObjectsPOST() {

        String testUrl = "/test";

//        HttpResponse response = http.get(testUrlT);
//        assertEquals(204, response.statusCode);
//        assertEquals("", response.body);
    }


}
