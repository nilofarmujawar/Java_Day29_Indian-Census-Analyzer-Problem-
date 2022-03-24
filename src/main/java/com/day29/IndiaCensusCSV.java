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

    @CsvBindByName(column = "State", required = true)
    public String state;

    @CsvBindByName(column = "Population", required = true)
    public int population;

    @CsvBindByName(column = "AreaInSqKm", required = true)
    public int areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm", required = true)
    public int densityPerSqKm;


    /**
     * overide method
     * @return state, population, areaInsqKm,DestityPerSqkm
     */
    @Override
    public String toString() {
        return "IndiaCensusCSV{" + "State='" + state + '\'' + ", Population='" + population + '\'' + ", AreaInSqKm='"
                + areaInSqKm + '\'' + ", DensityPerSqKm='" + densityPerSqKm + '\'' + '}';
    }
}