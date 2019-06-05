package reflect;

public class MethodsTest implements Inter{
    private String address  = "NJ";


    public String getAddress() {
        return address;
    }
    public int add(int a, int b) {
        System.out.println("this is test for int");
        return a+b;
    }

    public String returnNames(String name) {
        System.out.println("this is test for String");
        return name;
    }

    @Override
    public void test() {
        System.out.println("this is a test");
    }
    private String testPrivate(String test) {
        System.out.println("this is a test for private");
        return test;
    }
}
