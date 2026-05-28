package payloads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import autoGenearator.DeviceSerialNumberGenerator;
import pojo.AlarmValue;
import pojo.CreateDeviceRequest;
import pojo.SensorType;

public class CreateDevice {

    public static CreateDeviceRequest createDevicePayload() {

        AlarmValue minTemp = new AlarmValue(
                "minimum_temp",
                1,
                "8"
        );

        AlarmValue maxTemp = new AlarmValue(
                "maximum_temp",
                2,
                "10"
        );

        AlarmValue alertMessage = new AlarmValue(
                "alert_message",
                3,
                "Temperature Exceeds"
        );

        List<AlarmValue> alarmList = Arrays.asList(
                minTemp,
                maxTemp,
                alertMessage
        );

        List<List<AlarmValue>> alarmValues = Arrays.asList(alarmList);

        SensorType sensorType = new SensorType(
                1,
                alarmValues
        );

        List<SensorType> sensorTypes = Arrays.asList(sensorType);

        return new CreateDeviceRequest(
                DeviceSerialNumberGenerator.getNextSerialNumber(),
                "TZ-TempU02",
                true,
                new ArrayList<>(),
                "PASSIVE",
                "3",
                sensorTypes
        );
    }
}