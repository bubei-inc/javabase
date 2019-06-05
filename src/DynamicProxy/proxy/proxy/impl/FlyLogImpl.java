package DynamicProxy.proxy.proxy.impl;

import DynamicProxy.proxy.proxy.Flyable;

import java.util.Date;

/**
 * @author syp
 * @package_name DynamicProxy.proxy.proxy.impl
 * @date 2019-05-31 10:06
 * @description
 **/
public class FlyLogImpl implements Flyable{
    private Flyable flyable;
    public FlyLogImpl(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        System.out.println("---->  in  <----");
        flyable.fly();
        System.out.printf("----> out <----");


    }

}
