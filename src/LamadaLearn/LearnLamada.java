package LamadaLearn;


public class LearnLamada {
    public static void main(String[] args) {
        LamadaTest<String, Integer> lamadaTest = (form) -> Integer.valueOf(form);
        Integer testVal = lamadaTest.testlamada("111111");
        System.out.println(testVal);
    }



 }
