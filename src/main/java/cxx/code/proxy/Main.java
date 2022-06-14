package cxx.code.proxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        DynamicProxy inter = new DynamicProxy(new Vendor());
        Sell sell = (Sell)(Proxy.newProxyInstance(Sell.class.getClassLoader(), new Class[] {Sell.class}, inter));
        sell.sell();
    }
}
