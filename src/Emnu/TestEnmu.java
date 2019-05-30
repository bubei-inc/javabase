package Emnu;

public enum TestEnmu {

    NAME("james"),
    AGE("12"),
    ADDRESS("SH");


    private String name;

    private TestEnmu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
