package com.A101.utilities;


import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class Log {

    // Initialize Log4j logs

    static Logger logger = Logger.getLogger(Log.class);

    public Log() {
        DOMConfigurator.configure("log4j.xml");
    }

    // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

    public void startTestCase(String sTestCaseName) {

        for (int i = 1; i <6 ; i++) {
            if(i == 3){
                logger.info("-".repeat(50 - sTestCaseName.length()/2) + sTestCaseName + "-".repeat(50 - sTestCaseName.length()/2));
            continue;
            }
            logger.info("*".repeat(100));
        }

    }

    //This is to print log for the ending of the test case

    public void endTestCase() {

        logger.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");

    }

    // Need to create these methods, so that they can be called

    public void info(String message) {

        logger.info(message);

    }

    public void warn(String message) {

        logger.warn(message);


    }

    public void error(String message) {

        logger.error(message);

    }

    public void fatal(String message) {

        logger.fatal(message);

    }

    public void debug(String message) {

        logger.debug(message);

    }

}
