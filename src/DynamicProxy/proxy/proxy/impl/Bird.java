package DynamicProxy.proxy.proxy.impl;

import DynamicProxy.proxy.proxy.Flyable;

/**
 * @author syp
 * @package_name DynamicProxy.proxy.proxy.impl
 * @date 2019-05-31 10:15
 * @description
 **/
public class Bird implements Flyable {

    @Override
    public void fly() {
        System.out.println("fly");
    }
}
