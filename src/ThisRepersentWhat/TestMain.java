package ThisRepersentWhat;

public class TestMain {
    public static void main(String[] args) {
        TestDemo te = new TestDemo("james");
        System.out.println(te.getAddress()+"/"+te.getHost()+"/"+te.getName());
        System.out.println(te.getPort());
    }
}
