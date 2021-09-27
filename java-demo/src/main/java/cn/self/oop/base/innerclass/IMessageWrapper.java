package cn.self.oop.base.innerclass;

/**
 * 静态内部接口示例
 */
interface IMessageWrapper {

    static interface IMessage {
        String getContent();
    }

    static interface IChannel {
        boolean connect();
    }

    public static void send(IMessage msg, IChannel chl) {
        if (chl.connect()) {
            System.out.println(msg.getContent());
        }
    }
}
