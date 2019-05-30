package MyProxy.StaticProxy.DynamicProxy;

import DynamicProxy.proxy.Person;
import MyProxy.StaticProxy.Teacher;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

    public static void main(String[] args) {
        Teacher teach = new Teacher();
        for(Method method : teach.getClass().getMethods()) {
            System.out.println(method);
        }

        for(Object obj : teach.getClass().getInterfaces()) {
            System.out.println(obj);
        }

        Person stu = (Person) Proxy.newProxyInstance(teach.getClass().getClassLoader(), teach.getClass().getInterfaces(),(proxy, method, argxs) -> {
            if(method.getName().equals("sayHello")) {
                return method.invoke(teach, argxs);
            }
            System.out.println("test");
            return null;
        });

        stu.sayHello("james");
    }

}
