package DynamicProxy.proxy.proxy;

        import DynamicProxy.proxy.proxy.impl.Bird;
        import DynamicProxy.proxy.proxy.impl.FlyLogImpl;
        import DynamicProxy.proxy.proxy.impl.FlyTimeImpl;
        import singleInstanse.SingleInstance;

/**
 * @author syp
 * @package_name DynamicProxy.proxy.proxy
 * @date 2019-05-31 10:14
 * @description
 **/
public class TestMain {
    public static void main(String[] args) {
        Bird bird = new Bird();
        FlyLogImpl flyLog = new FlyLogImpl(bird);
        FlyTimeImpl flyTime = new FlyTimeImpl(flyLog);
        flyTime.fly();

    }
}
