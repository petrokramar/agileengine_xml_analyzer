package com.agileengine.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        try {
            validateArgs(args);
            Analyzer.parseTargetFile(args);
        } catch(Exception e ) {
            LOGGER.error(e.getMessage());
        }
    }

    private static void validateArgs(String[] args) {
        if (args.length < 2 || args.length > 3) {
            throw new IllegalArgumentException(
                    String.format("Wrong number of args - %s. Must be 2 or 3 args.", args.length));
        }
    }
}