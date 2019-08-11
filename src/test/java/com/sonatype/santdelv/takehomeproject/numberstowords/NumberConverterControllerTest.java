package com.sonatype.santdelv.takehomeproject.numberstowords;

import com.sonatype.santdelv.takehomeproject.numberstowords.controllers.NumberConverterController;
import com.sonatype.santdelv.takehomeproject.numberstowords.impl.NumberConverterImpl;
import com.sonatype.santdelv.takehomeproject.numberstowords.validators.impl.NumberStringValidatorImpl;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.eclipse.jetty.client.HttpResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static spark.Spark.awaitInitialization;
import static spark.Spark.stop;


public class NumberConverterControllerTest {

    NumberConverterController numberConverterController;

    @BeforeAll
    private static void setUp() throws Exception {
        NumberConverterController numberConverterController =
                new NumberConverterController(new NumberConverterImpl(new NumberStringValidatorImpl()));
        awaitInitialization();
    }

    @AfterAll
    private static void tearDown() throws Exception {
        System.out.println("Stopping server");
        stop();
    }

    @Test
    public void testValidNumbersGives200() throws IOException {
        CloseableHttpResponse response = getResponseFromNumberServer("1234");
        int statusCode = response.getStatusLine().getStatusCode();
        String serverResponseBody = getServerResponseBody(response);
        assertEquals(200, statusCode);
        assertEquals("One thousand two hundred and thirty four", serverResponseBody);
    }

    @Test
    public void testNonNumericStringGives422() throws IOException {
        CloseableHttpResponse response = getResponseFromNumberServer("asdf");
        int statusCode = response.getStatusLine().getStatusCode();
        String serverResponseBody = getServerResponseBody(response);
        assertEquals(422, statusCode);
        assertEquals("number should be an int with an optional '-' at the beginning", serverResponseBody);
    }

    @Test
    public void testNumberOutOfRangeValidNumbersGives422() throws IOException {
        CloseableHttpResponse response = getResponseFromNumberServer("2147483648");
        int statusCode = response.getStatusLine().getStatusCode();
        String serverResponseBody = getServerResponseBody(response);
        assertEquals(422, statusCode);
        assertEquals("number outside of the supported range", serverResponseBody);
    }

    private static CloseableHttpResponse getResponseFromNumberServer(String number) throws IOException {
        CloseableHttpClient httpClient = HttpClients.custom().build();
        HttpGet httpGet = new HttpGet("http://localhost:4567/numbertoword/" + number);
        return httpClient.execute(httpGet);
    }

    private static String getServerResponseBody(CloseableHttpResponse response) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }

}
