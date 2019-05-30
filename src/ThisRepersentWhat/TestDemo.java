package ThisRepersentWhat;


public class TestDemo extends Test {
    private String name;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    private String host;

    public TestDemo(String name) {
        this(name,"SH");

    }
    public TestDemo(String name, String address) {
        this(name, address, "127.0.0.1");

    }

    public TestDemo(String name, String address, String host) {
        super("2222");
        this.name = name;
        this.address = address;
        this.host = host;

    }

}
