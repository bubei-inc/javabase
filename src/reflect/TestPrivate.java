package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestPrivate {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        MethodsTest methodsTest = new MethodsTest();
        Class cls = methodsTest.getClass();
        //Method method = cls.getDeclaredMethod("testPrivate", String.class);
        Field privateVal = cls.getDeclaredField("address");
//        if(method != null) {
//        method.setaccessible(true);
//        }
//        method.invoke(new methodstest(), "namessss");
        System.out.println((new MethodsTest()).getAddress());
        if(privateVal != null) {
            privateVal.setAccessible(true);
            privateVal.set(methodsTest ,"SH");
            System.out.println(methodsTest.getAddress());
        }
    }
}
