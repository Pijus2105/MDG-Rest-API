package payloads;

import org.json.JSONArray;
import org.json.JSONObject;

public class Documents {

    public static String createDocumentPayload() {
        JSONObject payload = new JSONObject();
        payload.put("name", "Onboarding");
        payload.put("description",
                "This document contains the quality and inspection report for the facility management status, including cleaning, maintenance, cafeteria, security, and vendor coordination checks.");
        payload.put("document_id", "DOC123456");
        payload.put("document_type_id", 6);
        payload.put("version", "1.0");
        payload.put("url", "C:/Users/cx280/Documents/Vardian-REST/Attachments/company_policy_handbook.pdf");

        JSONArray components = new JSONArray();

        JSONObject doccomp1 = new JSONObject();
        doccomp1.put("id", 15);
        doccomp1.put("root_id", JSONObject.NULL);

        components.put(doccomp1);

        JSONObject doccomp2 = new JSONObject();
        doccomp2.put("id", 19);
        doccomp2.put("root_id", 15);

        components.put(doccomp2);

        payload.put("components", components);

        return payload.toString();

    }

}
