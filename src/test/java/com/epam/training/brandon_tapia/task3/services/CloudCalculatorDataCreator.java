package com.epam.training.brandon_tapia.task3.services;

import com.epam.training.brandon_tapia.task3.model.CloudCalculatorDataModel;

public class CloudCalculatorDataCreator {
    public static final String TESTDATA_NUM_INSTANCES = "testdata.num.instances";
    public static final String TESTDATA_OPERATING_SYSTEM = "testdata.operating.system";
    public static final String TESTDATA_PROVISIONAL_MODEL = "testdata.provisional.model";
    public static final String TESTDATA_MACHINE_TYPE = "testdata.machine.type";
    public static final String TESTDATA_GPU_TYPE = "testdata.gpu.type";
    public static final String TESTDATA_NUM_OF_GPUS = "testdata.num.of.gpus";
    public static final String TESTDATA_LOCAL_SSD = "testdata.local.ssd";
    public static final String TESTDATA_REGION = "testdata.region";

    public static CloudCalculatorDataModel withCredentialsFromProperty() {
        return new CloudCalculatorDataModel(
                Integer.parseInt(DataReaderService.getTestData(TESTDATA_NUM_INSTANCES)),
                DataReaderService.getTestData(TESTDATA_OPERATING_SYSTEM),
                DataReaderService.getTestData(TESTDATA_PROVISIONAL_MODEL),
                DataReaderService.getTestData(TESTDATA_MACHINE_TYPE),
                DataReaderService.getTestData(TESTDATA_GPU_TYPE),
                Integer.parseInt(DataReaderService.getTestData(TESTDATA_NUM_OF_GPUS)),
                DataReaderService.getTestData(TESTDATA_LOCAL_SSD),
                DataReaderService.getTestData(TESTDATA_REGION)
        );
    }
}
