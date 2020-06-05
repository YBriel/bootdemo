package com.boot.bootdemo.netty.socket;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.springframework.context.annotation.Bean;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/6/5   8:11
 */
@org.springframework.context.annotation.Configuration
public class SocketIoConfig {

/*    @Value("${my.server.host}")
    private String host;
    @Value("${my.server.port}")
    private Integer port;*/

    @Bean
    public SocketIOServer socketIOServer() {
        Configuration config = new Configuration();
        config.setOrigin(null);   // 注意如果开放跨域设置，需要设置为null而不是"*"
        config.setHostname("localhost");
        config.setPort(9002);
        config.setSocketConfig(new SocketConfig());
        config.setWorkerThreads(100);
        config.setAuthorizationListener(handshakeData -> true);
        final SocketIOServer server = new SocketIOServer(config);
        server.start();
        System.out.println("socket服务器启动成功！");
        return server;

    }

    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketIOServer){
        return new SpringAnnotationScanner(socketIOServer);
    }
}
