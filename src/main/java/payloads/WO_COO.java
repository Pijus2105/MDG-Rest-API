package payloads;

import org.json.JSONArray;
import org.json.JSONObject;

import autoNameGenearator.WorkOrderGenerator;

public class WO_COO {

    public static String createWorkOrderPayload() {
        JSONObject payload = new JSONObject();
        String workOrderName = WorkOrderGenerator.geNexttWorkOrderName();
        payload.put("title", workOrderName);
        payload.put("description", "Perform a daily check on facility management status (cleaning, maintenance, cafeteria, security). Coordinate with external vendors and service providers for any scheduled deliveries, repairs, or maintenance work. Log any complaints or issues reported by department heads. Ensure smooth working conditions across all office zones and production units. Share a daily checklist with Admin and report exceptions to the CEO.");
        payload.put("due_date", "2025-07-04T18:30:00.000Z");
        payload.put("due_time", "2025-07-04T07:20:00.000Z");
        payload.put("work_order_category_id", 20);
        payload.put("user_id", 153);
        payload.put("priority", "High");

        JSONArray components = new JSONArray();
        JSONObject comp1 = new JSONObject();
        comp1.put("id", 24);
        comp1.put("root_id", JSONObject.NULL);
        components.put(comp1);

        // JSONObject comp2 = new JSONObject();
        // comp2.put("id", 19);
        // comp2.put("root_id", 15);
        // components.put(comp2);

        payload.put("components", components);
        payload.put("procedure_id", new JSONArray());
        payload.put("team_id", new JSONArray());

        return payload.toString();
    }
}
