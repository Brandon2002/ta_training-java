package com.epam.training.brandon_tapia.task3.model;

import java.util.Objects;

/**
 * CloudCalculatorDataModel is a data model class that represents the configuration
 * data for the Cloud Calculator. It includes details such as the number of instances,
 * operating system, provisioning model, machine type, GPU type, number of GPUs, local SSD,
 * and region.
 */
public class CloudCalculatorDataModel {
    private final int numInstances;
    private final String operatingSystem;
    private final String provisionalModel;
    private final String machineType;
    private final String gpuType;
    private final int numOfGpus;
    private final String localSsd;
    private final String region;

    /**
     * Constructor to initialize the CloudCalculatorDataModel with the specified configuration.
     *
     * @param numInstances the number of instances
     * @param operatingSystem the operating system
     * @param provisionalModel the provisioning model
     * @param machineType the machine type
     * @param gpuType the GPU type
     * @param numOfGpus the number of GPUs
     * @param localSsd the local SSD
     * @param region the region
     */
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

    /**
     * @return the number of instances
     */
    public int getNumInstances() {
        return numInstances;
    }

    /**
     * @return the operating system
     */
    public String getOperatingSystem() {
        return operatingSystem;
    }

    /**
     * @return the provisioning model
     */
    public String getProvisionalModel() {
        return provisionalModel;
    }

    /**
     * @return the machine type
     */
    public String getMachineType() {
        return machineType;
    }

    /**
     * @return the GPU type
     */
    public String getGpuType() {
        return gpuType;
    }

    /**
     * @return the number of GPUs
     */
    public int getNumOfGpus() {
        return numOfGpus;
    }

    /**
     * @return the local SSD
     */
    public String getLocalSsd() {
        return localSsd;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * Provides a string representation of the object.
     *
     * @return a string representation of the object
     */
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

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise
     */
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

    /**
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(numInstances, operatingSystem, provisionalModel, machineType, gpuType, numOfGpus, localSsd, region);
    }
}
