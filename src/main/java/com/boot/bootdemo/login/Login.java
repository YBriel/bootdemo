package com.boot.bootdemo.login;

import com.boot.bootdemo.aspect.LogA;
import com.boot.bootdemo.entity.LoginBean;
import org.springframework.stereotype.Component;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/1   22:29
 */
@Component
public class Login {
    @LogA(title = "hhh",action = "登录")
    public void login(){
        System.out.println("登录成功");
    }

    public void login(int a){
        System.out.println("登录成功11111"+a);
    }

    public void login(String  a){
        System.out.println("登录成功11111"+a);
    }

    @LogA(title = "hhh",action = "登录")
    public void login(@LogA  LoginBean bean){

        System.out.println("登录成功11111");
        System.out.println("---------------"+ bean);
        int a=10/0;

    }


    public int login1( ){

        System.out.println("登录成功11111");
        System.out.println("---------------");
        int a=10/0;
        return 1;

    }
}
