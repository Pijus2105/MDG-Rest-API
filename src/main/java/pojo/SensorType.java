package pojo;

import java.util.List;

public class SensorType {

    private int sensorId;
    private List<List<AlarmValue>> alarmValues;

    public SensorType() {

    }

    public SensorType(int sensorId,
                      List<List<AlarmValue>> alarmValues) {

        this.sensorId = sensorId;
        this.alarmValues = alarmValues;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public List<List<AlarmValue>> getAlarmValues() {
        return alarmValues;
    }

    public void setAlarmValues(List<List<AlarmValue>> alarmValues) {
        this.alarmValues = alarmValues;
    }
}