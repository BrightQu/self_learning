package cn.self.oop.base.innerclass;

class StrMessage implements IMessageWrapper.IMessage {

    @Override
    public String getContent() {
        return "This is a test for inner_class";
    }
}
