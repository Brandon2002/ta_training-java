package com.epam.training.brandon_tapia.task3.services;

import java.util.ResourceBundle;

public class DataReaderService {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment", "dev"));

    public static String getTestData(String key){ return resourceBundle.getString(key);}
}


