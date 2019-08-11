package com.sonatype.santdelv.takehomeproject.numberstowords.controllers;
import com.sonatype.santdelv.takehomeproject.numberstowords.NumberConverter;
import com.sonatype.santdelv.takehomeproject.numberstowords.exceptions.InvalidNumberException;
import com.sonatype.santdelv.takehomeproject.numberstowords.exceptions.NumberOutOfRangeException;
import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.*;

public class NumberConverterController {

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

        // more routes
    }
}
