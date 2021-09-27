package cn.self.oop.base.innerclass;

class TcpChannel implements IMessageWrapper.IChannel {

    @Override
    public boolean connect() {
        return true;
    }
}
