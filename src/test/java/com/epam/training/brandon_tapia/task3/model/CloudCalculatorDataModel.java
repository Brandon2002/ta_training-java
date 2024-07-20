package com.epam.training.brandon_tapia.task3.model;

import java.util.Objects;

public class CloudCalculatorDataModel {
    private int numInstances;
    private String operatingSystem;
    private String provisionalModel;
    private String machineType;
    private String gpuType;
    private int numOfGpus;
    private String localSsd;
    private String region;

    public CloudCalculatorDataModel(int numInstances, String operatingSystem, String provisionalModel,
                                 String machineType, String gpuType, int numOfGpus,
                                 String localSsd, String region) {
        this.numInstances = numInstances;
        this.operatingSystem = operatingSystem;
        this.provisionalModel = provisionalModel;
        this.machineType = machineType;
        this.gpuType = gpuType;
        this.numOfGpus = numOfGpus;
        this.localSsd = localSsd;
        this.region = region;
    }

    public int getNumInstances() {
        return numInstances;
    }

    public void setNumInstances(int numInstances) {
        this.numInstances = numInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getProvisionalModel() {
        return provisionalModel;
    }

    public void setProvisionalModel(String provisionalModel) {
        this.provisionalModel = provisionalModel;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public int getNumOfGpus() {
        return numOfGpus;
    }

    public void setNumOfGpus(int numOfGpus) {
        this.numOfGpus = numOfGpus;
    }

    public String getLocalSsd() {
        return localSsd;
    }

    public void setLocalSsd(String localSsd) {
        this.localSsd = localSsd;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "CloudCalculatorConfig{" +
                "numInstances=" + numInstances +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", provisionalModel='" + provisionalModel + '\'' +
                ", machineType='" + machineType + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", numOfGpus=" + numOfGpus +
                ", localSsd='" + localSsd + '\'' +
                ", region='" + region + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CloudCalculatorDataModel)) return false;
        CloudCalculatorDataModel that = (CloudCalculatorDataModel) o;
        return Objects.equals(numInstances, that.numInstances) &&
                Objects.equals(numOfGpus, that.numOfGpus) &&
                Objects.equals(operatingSystem, that.operatingSystem) &&
                Objects.equals(provisionalModel, that.provisionalModel) &&
                Objects.equals(machineType, that.machineType) &&
                Objects.equals(gpuType, that.gpuType) &&
                Objects.equals(localSsd, that.localSsd) &&
                Objects.equals(region, that.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numInstances, operatingSystem, provisionalModel, machineType, gpuType, numOfGpus, localSsd, region);
    }
}
