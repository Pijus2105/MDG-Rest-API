package payloads;

import org.json.JSONArray;
import org.json.JSONObject;
import autoNameGenearator.FormNameGenerator;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Form {

    public static String createFormPayload() {
        JSONObject payload = new JSONObject();
        String formName = FormNameGenerator.getNextFormName();

        payload.put("name", formName);
        payload.put("schedule_type", "NO_SCHEDULE");
        payload.put("is_required_form_serial_number", true);
        payload.put("form_type", "PUBLIC");
        payload.put("auto_work_order_assignment", true);
        payload.put("reporting", false);
        payload.put("digital_signature", false);
        payload.put("is_active", true);
        payload.put("is_template", true);
        payload.put("timezone", "Asia/Calcutta");

        // Components
        JSONArray components = new JSONArray();

        components.put(new JSONObject().put("id", 24).put("root_id", JSONObject.NULL));
       // components.put(new JSONObject().put("id", 19).put("root_id", 15));
        //components.put(new JSONObject().put("id", 24).put("root_id", 22));
        // components.put(new JSONObject().put("id", 30).put("root_id", 24));

        payload.put("components", components);

        // Schedule Setting
        // JSONObject scheduleSetting = new JSONObject();
        // scheduleSetting.put("start_date", "2025-07-02T18:30:00.000Z");
        // scheduleSetting.put("end_date", "2025-07-07T07:29:00.000Z");
        // scheduleSetting.put("start_time", "2025-07-03T07:29:00.000Z");
        // payload.put("schedule_setting", scheduleSetting);

        // Dynamic Schedule Setting: Start time = now + 2 minutes
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Calcutta"));
        ZonedDateTime startTime = now.plusMinutes(2);

        // Optional: static start_date & end_date range
        ZonedDateTime startDate = now;
        ZonedDateTime endDate = now.plusDays(5);

        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

        JSONObject scheduleSetting = new JSONObject();
        scheduleSetting.put("start_date", startDate.format(formatter));
        scheduleSetting.put("end_date", endDate.format(formatter));
        scheduleSetting.put("start_time", startTime.format(formatter));
        payload.put("schedule_setting", scheduleSetting);

        // Checkpoints
        JSONArray checkpoints = new JSONArray();

        // 1. TEXT
        JSONObject cp1 = new JSONObject();
        cp1.put("name", "Initial Inspection");
        cp1.put("status", true);
        cp1.put("nfc_scanning", false);
        cp1.put("nfc_code", "");
        cp1.put("checkpoint_type", "TEXT");
        cp1.put("auto_work_order_assignment", true);
        cp1.put("work_instructions", "");
        cp1.put("checkout_values", new JSONObject());
        cp1.put("attachments", new JSONArray());
        checkpoints.put(cp1);

        // 2. NUMERIC
        JSONObject cp2 = new JSONObject();
        cp2.put("name", "Quality Verified");
        cp2.put("status", true);
        cp2.put("nfc_scanning", false);
        cp2.put("nfc_code", "");
        cp2.put("checkpoint_type", "NUMERIC");
        cp2.put("auto_work_order_assignment", true);
        cp2.put("work_instructions", "");
        JSONObject numValues = new JSONObject();
        numValues.put("from", 10);
        numValues.put("to", 17);
        numValues.put("low", JSONObject.NULL);
        numValues.put("high", JSONObject.NULL);
        numValues.put("unit", JSONObject.NULL);
        numValues.put("answer", JSONObject.NULL);
        cp2.put("checkout_values", numValues);
        cp2.put("attachments", new JSONArray());
        checkpoints.put(cp2);

        // 3. BOOLEAN
        JSONObject cp3 = new JSONObject();
        cp3.put("name", "Safety Check");
        cp3.put("status", true);
        cp3.put("nfc_scanning", false);
        cp3.put("nfc_code", "");
        cp3.put("checkpoint_type", "BOOLEAN");
        cp3.put("auto_work_order_assignment", true);
        cp3.put("work_instructions", "");
        JSONArray boolValues = new JSONArray();
        boolValues.put(new JSONObject().put("id", 1).put("name", "Yes").put("expected", true).put("answer", false));
        boolValues.put(new JSONObject().put("id", 2).put("name", "No").put("expected", false).put("answer", false));
        cp3.put("checkout_values", boolValues);
        cp3.put("attachments", new JSONArray());
        checkpoints.put(cp3);

        // 4. SINGLE_SELECT
        JSONObject cp4 = new JSONObject();
        cp4.put("name", "Equipment Condition");
        cp4.put("status", true);
        cp4.put("nfc_scanning", false);
        cp4.put("nfc_code", "");
        cp4.put("checkpoint_type", "SINGLE_SELECT");
        cp4.put("auto_work_order_assignment", true);
        cp4.put("work_instructions", "");
        JSONArray singleValues = new JSONArray();
        singleValues
                .put(new JSONObject().put("id", 1).put("name", "Working").put("expected", true).put("answer", false));
        singleValues.put(
                new JSONObject().put("id", 2).put("name", "Not Working").put("expected", false).put("answer", false));
        cp4.put("checkout_values", singleValues);
        cp4.put("attachments", new JSONArray());
        checkpoints.put(cp4);

        // 5. MULTI_SELECT
        JSONObject cp5 = new JSONObject();
        cp5.put("name", "Process Confirmation");
        cp5.put("status", true);
        cp5.put("nfc_scanning", false);
        cp5.put("nfc_code", "");
        cp5.put("checkpoint_type", "MULTI_SELECT");
        cp5.put("auto_work_order_assignment", true);
        cp5.put("work_instructions", "");
        JSONArray multiValues = new JSONArray();
        multiValues
                .put(new JSONObject().put("id", 1).put("name", "Working").put("expected", true).put("answer", false));
        multiValues
                .put(new JSONObject().put("id", 2).put("name", "Neutral").put("expected", true).put("answer", false));
        multiValues
                .put(new JSONObject().put("id", 3).put("name", "Damage").put("expected", false).put("answer", false));
        multiValues.put(
                new JSONObject().put("id", 4).put("name", "Not Working").put("expected", false).put("answer", false));
        multiValues.put(new JSONObject().put("id", 5).put("name", "Under Maintenance").put("expected", false)
                .put("answer", false));
        cp5.put("checkout_values", multiValues);
        cp5.put("attachments", new JSONArray());
        checkpoints.put(cp5);

        payload.put("checkpoints", checkpoints);

        return payload.toString();
    }
}
