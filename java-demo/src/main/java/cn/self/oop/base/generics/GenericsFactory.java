package cn.self.oop.base.generics;

interface IMessage {
    void send(String msg);
}

class MessageImpl implements IMessage {
    @Override
    public void send(String msg) {
        System.out.println("MessageImpl send msg: " + msg);
    }
}

class Factory {
    public static <T> T getInstance(String className) {
        if ("MessageImpl".equalsIgnoreCase(className)) {
            return (T) new MessageImpl();
        }
        return null;
    }
}

class GenericsFactory {

    public static void main(String[] args) {
        IMessage msg = Factory.getInstance("MessageImpl");
        msg.send("hahahahha");
    }
}
