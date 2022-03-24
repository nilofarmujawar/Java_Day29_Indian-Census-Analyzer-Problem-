package com.day29;

/**
 * import class
 */

import com.opencsv.bean.CsvBindByName;

/**
 * create a class name as IndiaCensusCSV
 */
public class IndiaCensusCSV {

    /**
     * @CsvBindByName =
     * Specifies a binding between a column name of the CSV input and a field in a bean.
     */

    @CsvBindByName(column = "FREQUENCY", required = true)
    public String FREQUENCY;

    @CsvBindByName(column = "DATE", required = true)
    public int DATE;

    @CsvBindByName(column = "LOCATION_NAME", required = true)
    public String LOCATION_NAME;

    @CsvBindByName(column = "VARIABLE_NAME", required = true)
    public String VARIABLE_NAME;

    @CsvBindByName(column = "VALUE", required = true)
    public int VALUE;


    /**
     * overide method
     * @return frequency, value, date , location name ,variable name
     */
    @Override
    public String toString() {
        return "IndiaCensusCSV{" + "FREQUENCY='" + FREQUENCY + '\'' + ", DATE='" + DATE + '\'' + ", LOCATION_NAME='"
                + LOCATION_NAME + '\'' + ", VARIABLE_NAME='" + VARIABLE_NAME + '\'' + ",VALUE='" + VALUE + '\'' + '}';
    }
}