package com.day29;

/**
 * import class
 */

import com.opencsv.bean.CsvBindByName;

/**
 * crete a class name as CSVStatesCode
 */
public class CSVStatesCode {

    /**
     * @CsvBindByName =
     * Specifies a binding between a column name of the CSV input and a field in a bean.
     */

    @CsvBindByName(column = "SrNo", required = true)
    public String srNo;

    @CsvBindByName(column = "stateName", required = true)
    public String stateName;

    @CsvBindByName(column = "TIN", required = true)
    public int tin;

    @CsvBindByName(column = "StateCode", required = true)
    public String stateCode;

    /**
     * overide method
     * @return srNo, Statename, tin , statecode
     */
    @Override
    public String toString() {
        return "IndiaStateCodeCSV{" + "srNo='" + srNo + '\'' + ", stateName=" + stateName + ", tin=" + tin
                + ", stateCode=" + stateCode + '}';
    }
}