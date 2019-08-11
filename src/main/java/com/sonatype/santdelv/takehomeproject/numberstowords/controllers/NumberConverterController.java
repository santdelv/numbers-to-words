package com.sonatype.santdelv.takehomeproject.numberstowords.controllers;
import com.sonatype.santdelv.takehomeproject.numberstowords.NumberConverter;
import com.sonatype.santdelv.takehomeproject.numberstowords.exceptions.InvalidNumberException;
import com.sonatype.santdelv.takehomeproject.numberstowords.exceptions.NumberOutOfRangeException;

import static spark.Spark.*;

/**
 * Controller to expose an endpoint to convert numbers from a numerical version to
 * emglish words.
 */
public class NumberConverterController {

    /**
     * Controller for the number converter api.
     * @param numberConverterService The service uset to convert numbers.
     */
    public NumberConverterController(final NumberConverter numberConverterService) {

        get("/numbertoword/:number", (req, res) -> {
            String number = req.params("number");
            try {
                res.status(200);
                return numberConverterService.getNumberAsWords(number);
            }
            catch (InvalidNumberException e) {
                res.status(422);
                return "number should be an int with an optional '-' at the beginning";
            } catch(NumberOutOfRangeException e){
                res.status(422);
                return "number outside of the supported range";
            }
        });

    }
}
