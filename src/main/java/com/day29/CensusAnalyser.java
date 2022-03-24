package com.day29;
/**
 * UC1 :- Ability for the analyser to load the Indian States Census Information from a csv file
 *        - Create a StateCensusAnalyser Class to load  the State Census CSV Data
 *        - Create CSVStateCensus Class to load the CSV Data
 *        - Use Iterator to load the data
 *        - Check with StateCensusAnalyser to ensure no of record matches.
 *
 */


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CensusAnalyser {
    private static String CSV_FILE_PATH="C:\\Users\\admin\\Desktop\\java\\Day29Indian-Census-Analyzer-Problem\\Java_Day29_Indian-Census-Analyzer-Problem-\\src\\test\\resources\\statewise-census-data-in-india-1901-2011.csv";
    public int loadIndiaCensusData(String csvFilePath) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));

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

    public static void main(String[] args) {
        CensusAnalyser censusAnalyzerObj=new CensusAnalyser();
        int numOfEntries=censusAnalyzerObj.loadIndiaCensusData(CSV_FILE_PATH);
        System.out.println(numOfEntries);
    }
}