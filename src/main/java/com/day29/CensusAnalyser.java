package com.day29;
/**
 * UC1 :- Ability for the analyser to load the Indian States Census Information from a csv file
 *        - Create a StateCensusAnalyser Class to load  the State Census CSV Data
 *        - Create CSVStateCensus Class to load the CSV Data
 *        - Use Iterator to load the data
 *        - Check with StateCensusAnalyser to ensure no of record matches.
 * TC1.1 :- Given the States Census CSV file, Check to ensure the Number of Record matches
 *          - This is a Happy Test Case where the records are checked
 *
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
     * file path
     */
    private static String CSV_FILE_PATH="C:\\Users\\admin\\Desktop\\java\\Day29Indian-Census-Analyzer-Problem\\Java_Day29_Indian-Census-Analyzer-Problem-\\src\\test\\resources\\IndianStateCensusData.csv";

    /**
     * crete a method name as loadIndiaCensusData,this is parameterized method
     * @param csvFilePath where ur file saved
     * @return no of entries
     */
    public int loadIndiaCensusData(String csvFilePath) {
        /**
         * using try catch block for exception handling
         */
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));

            /**
             * crete a object name as csvToBeanBuilder
             */
            CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<IndiaCensusCSV>(reader);
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
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * create main method ,all program execute in main method
     * @param args no arguments
     */
    public static void main(String[] args) {
        /**
         * create object name as censusAnalyzerObj for CensusAnalyser class
         */
        CensusAnalyser censusAnalyzerObj=new CensusAnalyser();
        /**
         * calling loadIndiaCensusData method from censusAnalyxerObj object and store result in num of Enteries
         */
        int numOfEntries=censusAnalyzerObj.loadIndiaCensusData(CSV_FILE_PATH);
        /**
         * print no of entries
         */
        System.out.println(numOfEntries);
    }
}