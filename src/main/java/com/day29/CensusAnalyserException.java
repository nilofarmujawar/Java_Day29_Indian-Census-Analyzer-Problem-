package com.day29;

/**
 * crete a class name as CensusAnalyserException
 */
public class CensusAnalyserException extends Exception {

    /**
     *  crete a enum class
     *  An enum type (or enumerated type) is a type whose fields consist of a fixed set of constants
     */
    public enum ExceptionType {
        CENSUS_FILE_PROBLEM, e
    }

    ExceptionType type;

    /**
     *  create a constructor name as CensusAnalyserException, this is parameterized constructor
     * @param message
     * @param type
     */
    public CensusAnalyserException(String message, ExceptionType type) {
        /**
         * The super keyword refers to superclass (parent) objects.
         */
        super(message);
        /**
         * The this keyword is used to refer to the current object.
         */
        this.type = type;
    }

    /**
     * create a constructor name as CensusAnalyserException, this is parameterized constructor
     * @param message
     * @param type
     * @param cause
     */
    public CensusAnalyserException(String message, ExceptionType type, Throwable cause) {
        /**
         * The super keyword refers to superclass (parent) objects.
         */
        super(message, cause);
        /**
         * The this keyword is used to refer to the current object.
         */
        this.type = type;
    }
}