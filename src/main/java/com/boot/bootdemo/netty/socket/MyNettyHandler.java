package com.boot.bootdemo.netty.socket;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/6/5   8:13
 */
@Slf4j
@Component
public class MyNettyHandler {

    private Map<Integer, SocketIOClient> noClientMap = new ConcurrentHashMap<>(16);

    @OnConnect
    public void onConnect(SocketIOClient client) {
        String no0 = client.getHandshakeData().getSingleUrlParam("no");
        log.info("工号为no = {}的用户建立WebSocket连接", no0);
        int no = 0;
        try {
            no = Integer.parseInt(no0);
        } catch (Exception e) {
            log.error("建立WebSocket连接，获取工号信息异常");
        }
        if (no != 0) {
            noClientMap.put(no, client);
        }
    }


    @OnDisconnect
    public void onDisConnect(SocketIOClient client) {
        String no0 = client.getHandshakeData().getSingleUrlParam("no");

        log.info("工号为no = {}的用户断开WebSocket连接", no0);

        int no = 0;
        try {
            no = Integer.parseInt(no0);
        } catch (Exception e) {
            log.error("建立WebSocket连接，获取工号信息异常");
        }
        if (no != 0) {
            noClientMap.remove(no, client);
        }

    }


    @OnEvent(value = "noEvent")
    public void onEvent(SocketIOClient client, Integer data, AckRequest request) {
        log.info("工号no = {}的用户推送消息", data    );
        if (data != null && data > 0) {
            noClientMap.put(data, client);
        }
    }



   // @Override
    public void toOne(int no, String eventName, Object data) {
        SocketIOClient socketIOClient = noClientMap.get(no);
        if (socketIOClient != null) {
            try {
                // 推送消息即为调用SocketIOClient的sendEvent方法
                socketIOClient.sendEvent(eventName, data);
            } catch (Exception e) {
                log.info("推送消息给工号为no = {}的用户异常{}", no, e.getMessage());
            }
        }

    }

   // @Override
/*    public void toAll(Object data) {
        for (Integer no : noClientMap.keySet()) {
            toOne(no, NettyEventEnum.RUNNING_TASK.getName(), data);
        }
    }*/
}
