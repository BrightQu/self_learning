package cn.self.oop.advanced.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

    private Object obj;

    public ProxyHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----------Before invoke------------");
        Object object = method.invoke(obj, args);
        System.out.println("----------After invoke------------");
        return object;
    }
}
