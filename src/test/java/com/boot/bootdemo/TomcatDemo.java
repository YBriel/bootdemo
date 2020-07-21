package com.boot.bootdemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * author: yuzq
 * create: 2020-07-21 10:31
 **/
public class TomcatDemo {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket();
        System.out.println("自定义简易tomcat启动开始！");
        serverSocket.bind(new InetSocketAddress(9999));
        System.out.println("tomcat监听9999端口成功！");
        while (true){
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            byte[] bytes;
            bytes = new byte[1024];
            int read = inputStream.read(bytes);
            System.out.println(read);
            String str = new String(bytes);
            System.out.println(str);
        }
    }
}
