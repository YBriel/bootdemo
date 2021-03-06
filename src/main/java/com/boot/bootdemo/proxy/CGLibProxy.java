package com.boot.bootdemo.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
 
import java.lang.reflect.Method;

public class CGLibProxy implements MethodInterceptor
{
    /**
     * 私有静态化实例对象
     */
    private static volatile CGLibProxy instance;
    //私有化构造函数
    private CGLibProxy(){};
    //公有静态化实例方法
    public static CGLibProxy getInstance(){
        if(instance==null){
            synchronized (CGLibProxy.class)
            {
                if (instance == null)
                {
                    instance = new CGLibProxy();
                }
            }
        }
        return instance;
    }
 
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable
    {
        //随意找到前置执行方法
        AmethodClass.before();
        //重点为cglib动态代理方法的执行
        Object obj = methodProxy.invokeSuper(o, objects);
        //随意找到后置执行方法
        AmethodClass.post();
        return obj;
    }
    private Enhancer enhancer = new Enhancer();
    //生成为具体需要代理类的子类
    public <T> T getProxy(Class<T> clazz){
        enhancer.setSuperclass(clazz);
        CGLibProxy cgLibProxy=new CGLibProxy();
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }
 
}
