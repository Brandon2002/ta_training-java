package com.epam.training.brandon_tapia.task3.services;

import java.util.ResourceBundle;

/**
 * DataReaderService provides methods to read test data from property files.
 * The property files are selected based on the environment specified via a system property.
 */
public class DataReaderService {

    /**
     * ResourceBundle instance to manage the property files.
     * The bundle is loaded based on the system property "environment", defaulting to "dev".
     */
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment", "dev"));

    /**
     * Retrieves the value associated with the specified key from the property file.
     *
     * @param key The key for which the value needs to be retrieved
     * @return The value associated with the given key
     */
    public static String getTestData(String key){ return resourceBundle.getString(key);}
}


