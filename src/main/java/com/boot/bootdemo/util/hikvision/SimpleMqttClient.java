//package com.boot.bootdemo.util.hikvision;
//
//import lombok.extern.slf4j.Slf4j;
//import org.eclipse.paho.client.mqttv3.*;
//import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
//
//import java.util.Arrays;
//
//@Slf4j
//public class SimpleMqttClient {
//
//    //全局唯一 单例
//    private static IMqttAsyncClient client;
//
//    private static IMqttAsyncClient getClient() {
//        return client;
//    }
//    private static void setClient(IMqttAsyncClient client) {
//        SimpleMqttClient.client = client;
//    }
//
//    /**
//     * 连接MQTT服务器
//     */
//    public void connect(String serverURI, String clientID, String username, String password) {
//
//        IMqttAsyncClient client = null;
//        try {
//            client = new MqttAsyncClient(serverURI, clientID, new MemoryPersistence());
//
//            MqttConnectOptions options = new MqttConnectOptions();
//            options.setCleanSession(false);
//            options.setUserName(username);
//            options.setPassword(password.toCharArray());
//            options.setServerURIs(new String[]{serverURI});
//            options.setConnectionTimeout(100);
//            options.setAutomaticReconnect(true);
//            //设置心跳
//            options.setKeepAliveInterval(30);
//            client.setCallback(new MqttCallbackExtended() {
//                @Override
//                public void connectComplete(boolean b, String s) {
//                    log.info("重连成功！");
//                    subscribe("artemis/event_face/3187675137/admin", 0);
//                    //publish("BUS_TS_REPLY_TOPIC_湘AB7182", "7E81074000010000000060013608025900000F7E", 0, false);
//
//                }
//
//
//                @Override
//                public void connectionLost(Throwable throwable) {
//                    log.error("Lost connection!!! ",throwable);
//                    throwable.printStackTrace();
//                }
//
//                @Override
//                public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
//                    log.info("接收消息主题 : " + topic);
//                    log.info("接收消息Qos : " + mqttMessage.getQos());
//                 //   log.info("接收消息内容 : " + BaseConvert.bytesToHexString(mqttMessage.getPayload()));
//                }
//
//
//                @Override
//                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
//                    log.debug("send success ? --> {}, ", iMqttDeliveryToken.isComplete());
//                }
//            });
//            options.setAutomaticReconnect(true);
//            client.connect(options);
//            SimpleMqttClient.setClient(client);
//
//            try {
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 发布
//     *
//     * @param qos     连接方式
//     * @param retained  是否保留
//     * @param topic    主题
//     * @param message 消息体
//     */
//    public void publish(String topic, byte[] message, int qos, boolean retained) {
//
//        if(client != null && client.isConnected()) {
//            try {
//                IMqttDeliveryToken token = client.publish(topic, message, qos, retained);
//                token.waitForCompletion();
//                log.debug("Is the message sent successfully? --> {}, {}", token.isComplete());
//            } catch (MqttException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /**
//     * 订阅某个主题
//     *
//     * @param topic 主题
//     * @param qos  连接方式
//     */
//    public void subscribe(String topic, int qos) {
//        log.info("开始订阅主题: {}" , topic);
//        if (client != null && client.isConnected()) {
//            try {
//                IMqttToken token = client.subscribe(topic, qos);
//                //token.waitForCompletion();
//            } catch (MqttException e) {
//                e.printStackTrace();
//                log.error("subscribe topic {} qos {} error!", topic, qos);
//            }
//        }
//    }
//    /**
//     * 订阅多主题
//     *
//     * @param topics 主题
//     * @param qos  连接方式
//     */
//    public void subscribe(String[] topics, int[] qos) {
//        log.info("开始订阅主题集合:{}", Arrays.asList(topics));
//        if (client != null && client.isConnected()) {
//            try {
//                IMqttToken token = client.subscribe(topics, qos);
//                //token.waitForCompletion();
//            } catch (MqttException e) {
//                e.printStackTrace();
//                log.error("subscribe topic {} qos {} error!", topics, qos);
//            }
//        }
//    }
//}
//
