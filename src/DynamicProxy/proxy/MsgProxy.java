package DynamicProxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MsgProxy implements InvocationHandler  {

    /**
     * 被代理对象
     */
    private Object realSubject;

    /**
     * 构造器
     *
     * @param realSubject 被代理对象
     */
    public MsgProxy(Object realSubject) {
        this.realSubject = realSubject;
    }

    /**
     * 获取代理对象的方法
     *
     * @return 代理对象
     */
    public Object getProxy() {
        Class<?> subjectClass = realSubject.getClass();
        return Proxy.newProxyInstance(subjectClass.getClassLoader(), subjectClass.getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //目标方法的方法名
        String methodName = method.getName();

        //打印入参（前置通知）
        System.out.println(methodName + "方法的入参"+args);
        System.out.println("this is a test demo ");
        try {

            //反射Reflect执行核心方法
            Object result = method.invoke(realSubject, args);

            //打印执行结果（返回后通知）
            System.out.println(methodName + " 方法的防止结果为"+ result);

            return result;
        } catch (Throwable e) {

            //打印异常日志（异常通知）
            System.out.println("执行目标方法发生异常"+e);
            return Boolean.FALSE;
        } finally {

            //方法执行完打印（后置通知）
            System.out.println("方法完成");
        }


    }
}
