package com.day29;

import com.opencsv.bean.CsvBindByName;

public class IndiaCensusCSV {

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


    @Override
    public String toString() {
        return "IndiaCensusCSV{" + "FREQUENCY='" + FREQUENCY + '\'' + ", DATE='" + DATE + '\'' + ", LOCATION_NAME='"
                + LOCATION_NAME + '\'' + ", VARIABLE_NAME='" + VARIABLE_NAME + '\'' + ",VALUE='" + VALUE + '\'' + '}';
    }
}