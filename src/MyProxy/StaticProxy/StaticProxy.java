package MyProxy.StaticProxy;

import DynamicProxy.proxy.Person;

public class StaticProxy implements Person{

    private Person person;

    public StaticProxy(Person person) {
        this.person = person;
    }
    @Override
    public void goodBye(String name) {
        System.out.println(name + "goodbye!");

    }

    @Override
    public void sayHello(String name) {
        System.out.println(name + "hello!");
    }


    public static void main(String[] args) {
        Teacher teacher= new Teacher();

        StaticProxy staticProxy = new StaticProxy(teacher);
        staticProxy.sayHello("james");
        staticProxy.goodBye("sophia");
    }
}
