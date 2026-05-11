package payloads;

import org.json.JSONArray;
import org.json.JSONObject;

import autoGenearator.DeviceSerialNumberGenerator;

public class CreateDevicePayload {

    public static String createDevice() {

        JSONObject payload = new JSONObject();

        payload.put("serialNumber", DeviceSerialNumberGenerator.getNextSerialNumber());
        payload.put("modelNumber", "TZ-TempU04");
        payload.put("isMultipleUse", true);
        payload.put("airlineIds", new JSONArray());
        payload.put("deviceType", "PASSIVE");
        payload.put("manufacturerId", "3");

        JSONArray sensorTypesArray = new JSONArray();

        // ---------------- SENSOR 1 ----------------
        JSONObject sensor1 = new JSONObject();
        sensor1.put("sensorId", 1);

        JSONArray alarmValues1 = new JSONArray();
        JSONArray innerArray1 = new JSONArray();

        innerArray1.put(new JSONObject()
                .put("name", "minimum_temp")
                .put("attributeId", 1)
                .put("value", "8"));

        innerArray1.put(new JSONObject()
                .put("name", "maximum_temp")
                .put("attributeId", 2)
                .put("value", "10"));

        innerArray1.put(new JSONObject()
                .put("name", "alert_message")
                .put("attributeId", 3)
                .put("value", "Temperature Exceeds"));

        alarmValues1.put(innerArray1);
        sensor1.put("alarmValues", alarmValues1);

        sensorTypesArray.put(sensor1);

        // ---------------- SENSOR 2 ----------------
        JSONObject sensor2 = new JSONObject();
        sensor2.put("sensorId", 2);

        JSONArray alarmValues2 = new JSONArray();
        JSONArray innerArray2 = new JSONArray();

        innerArray2.put(new JSONObject()
                .put("name", "minimum_humid")
                .put("attributeId", 4)
                .put("value", "0"));

        innerArray2.put(new JSONObject()
                .put("name", "maximum_humid")
                .put("attributeId", 5)
                .put("value", "18"));

        innerArray2.put(new JSONObject()
                .put("name", "alert_message")
                .put("attributeId", 6)
                .put("value", "Humidity"));

        alarmValues2.put(innerArray2);
        sensor2.put("alarmValues", alarmValues2);

        sensorTypesArray.put(sensor2);

        // ---------------- SENSOR 3 ----------------
        JSONObject sensor3 = new JSONObject();
        sensor3.put("sensorId", 3);

        JSONArray alarmValues3 = new JSONArray();
        JSONArray innerArray3 = new JSONArray();

        innerArray3.put(new JSONObject()
                .put("name", "vibrations")
                .put("attributeId", 7)
                .put("value", "8 - Fall height more than 150cm"));

        innerArray3.put(new JSONObject()
                .put("name", "alert_message")
                .put("attributeId", 8)
                .put("value", "Shock event detected!"));

        alarmValues3.put(innerArray3);
        sensor3.put("alarmValues", alarmValues3);

        sensorTypesArray.put(sensor3);

        // ---------------- SENSOR 4 ----------------
        JSONObject sensor4 = new JSONObject();
        sensor4.put("sensorId", 4);

        JSONArray alarmValues4 = new JSONArray();
        JSONArray innerArray4 = new JSONArray();

        innerArray4.put(new JSONObject()
                .put("name", "light")
                .put("attributeId", 9)
                .put("value", "5"));

        innerArray4.put(new JSONObject()
                .put("name", "alert_message")
                .put("attributeId", 10)
                .put("value", "Light Alert"));

        alarmValues4.put(innerArray4);
        sensor4.put("alarmValues", alarmValues4);

        sensorTypesArray.put(sensor4);

        // Add sensorTypes to main payload
        payload.put("sensorTypes", sensorTypesArray);

        return payload.toString();
    }
}
