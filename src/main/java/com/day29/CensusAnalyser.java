package com.day29;
/**
 * UC1 :-   Ability for the analyser to load the Indian States Census Information from a csv file
 *          - Create a StateCensusAnalyser Class to load  the State Census CSV Data
 *          - Create CSVStateCensus Class to load the CSV Data
 *          - Use Iterator to load the data
 *          - Check with StateCensusAnalyser to ensure no of record matches.
 * TC1.1 :- Given the States Census CSV file, Check to ensure the Number of Record matches
 *          - This is a Happy Test Case where the records are checked
 * TC1.2 :- Given the State Census CSV File if incorrect Returns a custom Exception
 *          - This is a Sad Test Case to verify if the exception is raised.
 * TC1.3 :- Given the State Census  CSV File when correct but type incorrect Returns a custom Exception
 *          - This is a Sad Test Case to verify if the type is incorrect then exception is raised.
 * TC1.4 :- Given the State Census CSV File when correct but delimiter incorrect Returns a custom Exception
 *          - This is a Sad Test Case to verify if the file delimiter is incorrect then exception is raised.
 * TC1.5 :- Given the State Census CSV File when correct but csv header incorrect Returns a custom Exception
 *          - This is a Sad Test Case to verify if the header is incorrect then exception is raised.
 *
 *  UC2  :- Ability for the analyser to load the Indian States Code Information from a csv  file
 *          - Create CSVStates Class to load the CSV Data
 *          - Use Iterator to load the data
 *          - Check with StateCensusAnalyser to ensure number of record matches
 * TC2.1 :- Given the States Census CSV file, Check to ensure the Number of Record matches
 *          - This is a Happy Test Case where the records are checked
 */

/**
 * import all classes
 */

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * create class name as CensusAnalyser
 */
public class CensusAnalyser {

    /**
     * crete a method name as loadIndiaCensusData,this is parameterized method
     * @param csvFilePath where ur file saved
     * @return no of entries
     */
    public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {
        /**
         * using try catch block for exception handling
         */
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));

            /**
             * crete a object name as csvToBeanBuilder
             */
            CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndiaCensusCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);

            CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();

            int numOfEntries = 0;
            while (censusCSVIterator.hasNext()) {
                numOfEntries++;
                censusCSVIterator.next();
            }
            return numOfEntries;
        } catch (Exception e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

    /**
     *  create a method name as loadIndianStatesCodeData, this is parameterized method
     * @param stateCodecsvFilePath
     * @return
     * @throws CensusAnalyserException
     */
    public static int loadIndianStatesCodeData(String stateCodecsvFilePath) throws CensusAnalyserException {
        /**
         * using try catch block for exception handling
         */
        try {
            Reader reader = Files.newBufferedReader(Paths.get(stateCodecsvFilePath));

            /**
             * create object for CsvToBeanBuilder, object name as csvToBeanBuilder
             */
            CsvToBeanBuilder<CSVStatesCode> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(CSVStatesCode.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);

            CsvToBean<CSVStatesCode> csvToBean = csvToBeanBuilder.build();
            Iterator<CSVStatesCode> censusCSVIterator = csvToBean.iterator();

            int numOfEntries = 0;
            while (censusCSVIterator.hasNext()) {
                numOfEntries++;
                censusCSVIterator.next();
            }
            return numOfEntries;
        } catch (Exception e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

}
