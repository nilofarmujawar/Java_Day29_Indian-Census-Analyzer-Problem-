package com.day29;

/**
 * import class
 */

import io.github.glytching.junit.extension.exception.ExpectedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @SuppressWarnings("deprecation") =
 *   Use this when you are deliberately using a deprecated method,
 *   realizing full well that your code might one day break, but you do not wish to be notified of this
 */
@SuppressWarnings("deprecation")
/**
 * create a class name as CensusAnalyserTest
 */
public class CensusAnalyserTest {
    /**
     * put the file path
     */
    private static String CORRECT_CSV_FILE_PATH = "C:\\Users\\admin\\Desktop\\java\\Day29Indian-Census-Analyzer-Problem\\Java_Day29_Indian-Census-Analyzer-Problem-\\src\\test\\resources\\IndianStateCensusData.csv";
    private static String WRONG_CSV_FILE_PATH = "C:\\Users\\admin\\Desktop\\java\\Day29Indian-Census-Analyzer-Problem\\Java_Day29_Indian-Census-Analyzer-Problem-\\src\\IndianStateCensusData.csv";
    private static String INCORRECT_FILE_TYPE_CSV_PATH = "C:\\Users\\admin\\Desktop\\java\\Day29Indian-Census-Analyzer-Problem\\Java_Day29_Indian-Census-Analyzer-Problem-\\src\\test\\resources\\IndianStateCensusData.java";
    private static String INCORRECT_DELIMETER_CSV = "C:\\Users\\admin\\Desktop\\java\\Day29Indian-Census-Analyzer-Problem\\Java_Day29_Indian-Census-Analyzer-Problem-\\src\\test\\resources\\IndianCSVWithWrongDelimeter.csv";
    private static String WRONG_HEADER = "C:\\Users\\admin\\Desktop\\java\\Day29Indian-Census-Analyzer-Problem\\Java_Day29_Indian-Census-Analyzer-Problem-\\src\\test\\resources\\WrongHeaderCensus.csv";
    private static String CORRECT_STATE_CODE_CSV_FILE_PATH = "C:\\Users\\admin\\Desktop\\java\\Day29Indian-Census-Analyzer-Problem\\Java_Day29_Indian-Census-Analyzer-Problem-\\src\\test\\resources\\IndianStateCodesCSV.csv";


    // TC 1.1
    @Test
    public void givenIndianCensusCSVFile_ShouldReturnCorrectNumberOfRecordTest() {
        CensusAnalyser censusAnalyzerObj = new CensusAnalyser();
        int numOfEntries;
        try {
            numOfEntries = censusAnalyzerObj.loadIndiaCensusData(CORRECT_CSV_FILE_PATH);
            Assertions.assertEquals(29, numOfEntries);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    //TC 1.2
    @Test
    public void givenWrongIndianCensusCSVFile_ShouldReturnCustomExceptionTest() {
        try {
            CensusAnalyser censusAnalyzerObj = new CensusAnalyser();
            /**
             * Allow us to verify the Exception thrown
             */
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyzerObj.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    // TC 1.3
    @Test
    public void givenWrongType_IndianCensusCSVFile_ShouldReturnCustomExceptionTest() {
        try {
            CensusAnalyser censusAnalyzerObj = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none(); // Allow us to verify the Exception thrown
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyzerObj.loadIndiaCensusData(INCORRECT_FILE_TYPE_CSV_PATH);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    //TC 1.4
    @Test
    public void givenWrongDelimeter_IndianCensusCSVFile_ShouldReturnCustomExceptionTest() {
        try {
            CensusAnalyser censusAnalyzerObj = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none(); // Allow us to verify the Exception thrown
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyzerObj.loadIndiaCensusData(INCORRECT_DELIMETER_CSV);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    //TC1.5
    @Test
    public void givenIncorrectHeaderIntoCSVFile_ShouldReturnCustomExceptionTest() {
        try {
            CensusAnalyser censusAnalyserObj = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyserObj.loadIndiaCensusData(WRONG_HEADER);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }
    // TC 2.1
    @Test
    public void givenStateCodeCSVFile_ShouldReturnCorrectNumberOfRecordTest() {
        CensusAnalyser censusAnalyzerObj = new CensusAnalyser();
        int numOfEntries;
        try {
            numOfEntries = censusAnalyzerObj.loadIndianStatesCodeData(CORRECT_STATE_CODE_CSV_FILE_PATH);
            Assertions.assertEquals(37, numOfEntries);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
}
