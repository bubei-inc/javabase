package Emnu;

public class TestMain {
    public static void main(String[] args) {
        TestEnmu[] values = TestEnmu.values();
        for(TestEnmu val :values) {
            System.out.println(val.name());
        }

    }
}
