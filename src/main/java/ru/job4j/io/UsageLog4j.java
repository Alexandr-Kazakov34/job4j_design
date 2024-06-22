package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");

        String name = "Petr Arsentev";
        int age = 33;
        LOG.debug("User info name : {}, age : {}", name, age);

        int intValue = 10;
        long longValue = 100000000000L;
        float floatValue = 3.14F;
        double doubleValue = 2.7189676828;
        char charValue = 'A';
        boolean booleanValue = true;
        byte byteValue = 127;
        short shortValue = 1000;

        LOG.debug("int: {}, long: {}, float: {}, double: {}, char: {}, boolean: {}, byte: {}, short: {}",
                intValue, longValue, floatValue, doubleValue, charValue, booleanValue, byteValue, shortValue);
    }
}

