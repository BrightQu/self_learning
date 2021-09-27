package cn.self.oop.base.innerclass;

public class TestMessageWrapper {

    public static void main(String[] args) {
        IMessageWrapper.send(new StrMessage(), new TcpChannel());
    }
}
