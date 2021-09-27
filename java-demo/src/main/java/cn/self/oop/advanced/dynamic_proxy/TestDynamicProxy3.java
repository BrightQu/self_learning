package cn.self.oop.advanced.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestDynamicProxy3 {

    public static <T> T getProxy(Class<T> clazz, Object obj) {
        return (T) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new Class<?>[]{clazz},
                new ProxyHandler(obj));
    }

    static class ProxyHandler implements InvocationHandler {

        private Object obj;

        ProxyHandler (Object obj) {
            this.obj = obj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Before ...");
            Object object = method.invoke(obj, args);
            System.out.println("After ...");
            return object;
        }
    }

    public static void main(String[] args) {
        IUser user = new UserImpl(33, "Jasmine");
        IUser userProxy = getProxy(IUser.class, user);
        String result = userProxy.printUser();
        System.out.println(result);

        IPerson person = new PersonImpl();
        IPerson personProxy = getProxy(IPerson.class, person);
        personProxy.sayHello("Good Morning!");
    }
}
