package DynamicProxy.proxy.proxy.impl;

import DynamicProxy.proxy.proxy.Flyable;

import java.util.Date;

/**
 * @author syp
 * @package_name DynamicProxy.proxy.proxy.impl
 * @date 2019-05-31 10:06
 * @description
 **/
public class FlyTimeImpl implements Flyable {
    private Flyable flyable;

    public FlyTimeImpl(Flyable flyable) {
        this.flyable = flyable;

    }
    @Override
    public void fly() {
        Date date = new Date();
        flyable.fly();
        Date da = new Date();
        System.out.println(da.getTime() - date.getTime());
    }
}
