package reflect;

import java.lang.reflect.Method;

public class ReflectionMethods {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class<?> methodClass = MethodsTest.class;
        //Object cls = methodClass.newInstance();
        Method[] methods = methodClass.getMethods();
        Method[] declaredMethods = methodClass.getDeclaredMethods();
        //获取methodClass类的add方法
        Class<?>[] inface =  methodClass.getInterfaces();
        Method method = methodClass.getMethod("add", int.class, int.class);
        //getMethods()方法获取的所有方法
        /*System.out.println("getMethods获取的方法：");
        for(Method m:methods) {
            System.out.println(m);
        }

        //getDeclaredMethods()方法获取的所有方法
        System.out.println("getDeclaredMethods获取的方法：");
        for(Method m:declaredMethods)
            System.out.println(m);
*/
        for(Class<?> inter : inface) {
            
            System.out.println("james" );
            System.out.println(inter);
        }
    }
}
