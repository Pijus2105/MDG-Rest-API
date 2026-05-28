package pojo;

public class AlarmValue {

    private String name;
    private int attributeId;
    private String value;

    public AlarmValue() {

    }

    public AlarmValue(String name,
                      int attributeId,
                      String value) {

        this.name = name;
        this.attributeId = attributeId;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(int attributeId) {
        this.attributeId = attributeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}