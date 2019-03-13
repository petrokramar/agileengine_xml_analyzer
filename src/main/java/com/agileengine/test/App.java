package com.agileengine.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        args = new String[3];
        args[0] = "m:/samples/sample-0-origin.html";
        args[1] = "m:/samples/sample-0-origin.html";
//        args[1] = "m:/samples/sample-1-evil-gemini.html";
//        args[1] = "m:/samples/sample-2-container-and-clone.html";
//        args[1] = "m:/samples/sample-3-the-escape.html";
//        args[1] = "m:/samples/sample-4-the-mash.html";
        args[2] = "make-everything-ok-button";

        try {
            validateArgs(args);
            Analyzer.parseTargetFile(args);
        } catch(Exception e ) {
            LOGGER.error(e.getMessage());
        }
    }

    private static void validateArgs(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException(String.format("Wrong number of args - %s. Must be 3.", args.length));
        }
    }
}