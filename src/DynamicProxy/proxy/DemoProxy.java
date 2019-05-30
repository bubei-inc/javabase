package DynamicProxy.proxy;

public class DemoProxy {
    public static void main(String[] args) {
        demo();
    }
    public static void demo() {
        MsgSupport localMessageSend = new LocalMessageSend();
        MsgSupport messageSend = (MsgSupport) new MsgProxy(localMessageSend).getProxy();
        messageSend.sendMsg("jsjsjsjsj", "13511595044");
    }
}
