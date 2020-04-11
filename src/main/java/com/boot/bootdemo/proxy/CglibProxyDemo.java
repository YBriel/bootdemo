package com.boot.bootdemo.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/25   8:18
 */
public class CglibProxyDemo implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 设置回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        printHaha();
        Object o1 = methodProxy.invokeSuper(o, objects);
        printHa();
        return o1;
    }

    private void printHaha(){
        System.out.println("哈哈哈哈");
    }

    private void printHa(){
        System.out.println("2222222");
    }

    public static void main(String[] args) {
        CglibDemo cglibDemo=new CglibDemo();
        CglibProxyDemo cglibProxyDemo=new CglibProxyDemo();
        CglibDemo instance = (CglibDemo)cglibProxyDemo.getInstance(cglibDemo);
        int a = instance.getA();
        String b = instance.getB();
        System.out.println(a+"----"+b);
        // cglibProxyDemo.intercept()
    }
}
