package com.boot.bootdemo.proxy;

/**
 * @author: yuzq
 */
public class ProxyFactory {
    public static AmethodClass newCGLibProxy() {
        return CGLibProxy.getInstance().getProxy(AmethodClass.class);
    }


    public static void main(String[] args){
        AmethodClass amethodClass= ProxyFactory.newCGLibProxy();
        amethodClass.a();
        amethodClass.b();
    }

}
