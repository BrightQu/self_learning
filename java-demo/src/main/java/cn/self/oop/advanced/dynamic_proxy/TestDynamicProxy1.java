package cn.self.oop.advanced.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestDynamicProxy1 {

    public static void main(String[] args) {
        IUser user = new UserImpl(11, "Jasmine");
        InvocationHandler userProxyHandler = new ProxyHandler(user);
        IUser userProxy = (IUser) Proxy.newProxyInstance(user.getClass().getClassLoader(),
                user.getClass().getInterfaces(), userProxyHandler);
        String result = userProxy.printUser();
        System.out.println(result);
    }
}
