//package com.boot.bootdemo.util.hikvision;
//
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Slf4j
//@Data
//@ConfigurationProperties(prefix = "spring.mqtt", ignoreInvalidFields = true)
//@Configuration
//public class MqttConfig {
//    private String username;
//    private String password;
//    private String url;
//    private Integer qos;
//    /**
//     *  把配置里的 cleanSession 设为false，客户端掉线后 服务器端不会清除session，
//     *  当重连后可以接收之前订阅主题的消息。当客户端上线后会接受到它离线的这段时间的消息，
//     *  如果短线需要删除之前的消息则可以设置为true
//     *
//     * @return
//     */
//    public MqttConnectOptions getOptions() {
//        MqttConnectOptions options = new MqttConnectOptions();
//        options.setCleanSession(false);
//        options.setUserName(username);
//        options.setPassword(password.toCharArray());
//        options.setServerURIs(new String[]{url});
//        options.setConnectionTimeout(10);
//        options.setAutomaticReconnect(true);
//        //设置心跳
//        options.setKeepAliveInterval(20);
//        return options;
//    }
//
//    @Bean
//    public SimpleMqttClient simpleMqttClient() {
//        SimpleMqttClient simpleMqttClient = new SimpleMqttClient();
//        //连接emq
//        simpleMqttClient.connect(url, "27684269", username, password);
//        log.info("create MqttPushClient success!");
//        return simpleMqttClient;
//    }
//}