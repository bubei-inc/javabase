package DynamicProxy.proxy;

public class LocalMessageSend implements MsgSupport {
    @Override
    public boolean sendMsg(String content, String phoneNum) {
        //模拟异常
        int temp = 1 / 0;
        System.out.println(content + "," + phoneNum);
        return true;
    }
}
