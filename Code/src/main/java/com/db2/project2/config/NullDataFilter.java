package com.db2.project2.config;

import com.opencsv.bean.CsvToBeanFilter;

/*
This class will eliminate all columns with value as 'null'
 */
public class NullDataFilter implements CsvToBeanFilter {
    @Override
    public boolean allowLine(String[] strings) {
        if (strings.length > 0) {
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].trim().equals("null")) {
                    strings[i] = null;
                }
            }
        }
        return true;
    }
}
