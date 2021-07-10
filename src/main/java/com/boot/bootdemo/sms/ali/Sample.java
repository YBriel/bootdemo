package com.boot.bootdemo.sms.ali;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.dysmsapi20170525.models.SendSmsResponseBody;
import com.aliyun.teaopenapi.models.Config;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class Sample {

    /**
     * 使用AK&SK初始化账号Client
     *
     * @param accessKeyId     LTAI4GBduxgBJo3ZG1vxKhKp
     * @param accessKeySecret mpLKSzyxoXCQmodW22MqEXi8lKwmfl
     * @return Client
     */
    public static Client createClient(String accessKeyId, String accessKeySecret) {
        Config config = new Config()
                .setAccessKeyId(accessKeyId)      // 您的AccessKey ID
                .setAccessKeySecret(accessKeySecret); // 您的AccessKey Secret
                config.endpoint = "dysmsapi.aliyuncs.com";        // 访问的域名
        try {
            return new Client(config);
        } catch (Exception e) {
            log.error("初始化短信客户端失败", e);
            return null;
        }
    }

    /**
     * 默认生成客户端
     *
     * @return 客户端信息
     */
    public static Client genClient() {
        return Sample.createClient("LTAI4GBduxgBJo3ZG1vxKhKp", "mpLKSzyxoXCQmodW22MqEXi8lKwmfl");
    }

    public static SendSmsResponseBody sendSms(String phone, String signName, String templateCode, Map<String, String> params) {
        Client client = genClient();
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers(phone)
                .setSignName(signName)
                .setTemplateCode(templateCode)//SMS_197891332
                .setTemplateParam(JSONObject.toJSONString(params));
        try {
            client.sendSms(sendSmsRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args_) throws Exception {
        Client client = Sample.createClient("LTAI4GBduxgBJo3ZG1vxKhKp", "mpLKSzyxoXCQmodW22MqEXi8lKwmfl");
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers("13576911130")
                .setSignName("赣游通")
                .setTemplateCode("SMS_197891332")
                .setTemplateParam("{\"code\":\"1234\"}");
        // 复制代码运行请自行打印 API 的返回值
        SendSmsResponse sendSmsResponse = client.sendSms(sendSmsRequest);
        SendSmsResponseBody body = sendSmsResponse.getBody();
        log.info("发送短信返回{}", JSONObject.toJSONString(sendSmsResponse));
    }
}