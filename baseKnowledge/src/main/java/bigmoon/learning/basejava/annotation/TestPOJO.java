
package bigmoon.learning.basejava.annotation;

public class TestPOJO {

    private String code;
    private String location;

    public String getCode() {
        return code;
    }

    @Test(value = "setCode", count = 1)
    public void setCode(String code) {
        this.code = code;
    }

    public String getLocation() {
        return location;
    }

    @Test(value = "location", count = 2)
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "TestPOJO{" +
                "code='" + code + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
