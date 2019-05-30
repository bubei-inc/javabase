package MyProxy.StaticProxy;

import DynamicProxy.proxy.Person;

public class Teacher  implements Person {
    @Override
    public void goodBye(String name) {

        System.out.println(name + "goodbye!");
    }

    @Override
    public void sayHello(String name) {
        System.out.println(name + "hello!");

    }
}
