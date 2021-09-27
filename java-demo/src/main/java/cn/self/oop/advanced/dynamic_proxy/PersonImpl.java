package cn.self.oop.advanced.dynamic_proxy;

public class PersonImpl implements IPerson {

    @Override
    public void sayHello(String str) {
        System.out.println("Person sayHello: [" + str + "]");
    }
}
