package cxx.code.proxy;

public class Vendor implements Sell {

    @Override
    public void sell() {
        System.out.println("sell method");
    }

    @Override
    public void ad() {
        System.out.println("ad method");
    }
}
