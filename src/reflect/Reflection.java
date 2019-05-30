package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
//        Class<?> c = String.class;
//        Object str = c.newInstance();
//        str = "james";
//        System.out.println(str);
        Class cls = Class.forName("reflect.MethodsTest");
        for(Method method : cls.getDeclaredMethods()) {
             System.out.println(method);
        }

//        System.out.println(cls.getFields());
    }
}
