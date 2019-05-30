package service;

import java.util.HashMap;

public class TestXCan {

    public static void main(String[] args) {
        HashMap<String, String> changes = new HashMap<>();
        putall(changes);
        String names = null;
        int a = 0;
        changes(a);

        change(names);
        System.out.println(names);
        System.out.println(changes);
        System.out.println(a);


        String yuzhou = "yuzhou";
        yuzhou = "universe";
        System.out.println(yuzhou);
    }
    static void  putall(HashMap<String, String> changes) {
        changes.put("name","james");
        changes.put("age", "12");
    }

    static void change(String name) {
        name = "james";
    }
    static void changes(int a)  {
        a = 10;
    }
}
