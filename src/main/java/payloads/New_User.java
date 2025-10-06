package payloads;

import org.json.JSONArray;
import org.json.JSONObject;

public class New_User {

    public static String createUserPayload() {
        JSONObject payload = new JSONObject();
        payload.put("name", "Mark Henry");
        payload.put("username", "mark.henry");
        payload.put("status", "ACTIVE");
        payload.put("role_id", 11);
        payload.put("company_id", 86);
        

        JSONArray components = new JSONArray();
        JSONObject comp1 = new JSONObject();
        comp1.put("id", 24);
        comp1.put("root_id", JSONObject.NULL);
        components.put(comp1);

        // JSONObject comp2 = new JSONObject();
        // comp2.put("id", 20);
        // comp2.put("root_id", 15);
        // components.put(comp2);

        //  JSONObject comp3 = new JSONObject();
        // comp3.put("id", 22);
        // comp3.put("root_id", 20);
        // components.put(comp3);

        payload.put("components", components);

        return payload.toString();
    }
}
