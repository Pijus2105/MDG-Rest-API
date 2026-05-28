package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateDeviceRequest {

    private String serialNumber;
    private String modelNumber;

    @JsonProperty("isMultipleUse")
    private boolean isMultipleUse;

    private List<Integer> airlineIds;
    private String deviceType;
    private String manufacturerId;
    private List<SensorType> sensorTypes;

    public CreateDeviceRequest() {
    }

    public CreateDeviceRequest(String serialNumber,
                               String modelNumber,
                               boolean isMultipleUse,
                               List<Integer> airlineIds,
                               String deviceType,
                               String manufacturerId,
                               List<SensorType> sensorTypes) {

        this.serialNumber = serialNumber;
        this.modelNumber = modelNumber;
        this.isMultipleUse = isMultipleUse;
        this.airlineIds = airlineIds;
        this.deviceType = deviceType;
        this.manufacturerId = manufacturerId;
        this.sensorTypes = sensorTypes;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    @JsonProperty("isMultipleUse")
    public boolean getIsMultipleUse() {
        return isMultipleUse;
    }

    @JsonProperty("isMultipleUse")
    public void setIsMultipleUse(boolean isMultipleUse) {
        this.isMultipleUse = isMultipleUse;
    }

    public List<Integer> getAirlineIds() {
        return airlineIds;
    }

    public void setAirlineIds(List<Integer> airlineIds) {
        this.airlineIds = airlineIds;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public List<SensorType> getSensorTypes() {
        return sensorTypes;
    }

    public void setSensorTypes(List<SensorType> sensorTypes) {
        this.sensorTypes = sensorTypes;
    }
}