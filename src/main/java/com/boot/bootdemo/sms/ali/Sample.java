package com.boot.bootdemo.sms.ali;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.*;
import com.aliyun.teaopenapi.models.Config;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class Sample {

    private static final Client client;

    static {
        client= Sample.createClient("LTAI4GBduxgBJo3ZG1vxKhKp", "mpLKSzyxoXCQmodW22MqEXi8lKwmfl");
    }

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

    /**
     * 发送短信
     * @param phone 手机号
     * @param signName 签名
     * @param templateCode 短信模板编码
     * @param params 参数
     */
    public static SendSmsResponse sendSms(String phone, String signName, String templateCode, Map<String, String> params) {
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers(phone)
                .setSignName(signName)
                .setTemplateCode(templateCode)//SMS_197891332
                .setTemplateParam(JSONObject.toJSONString(params));
        try {
            return client.sendSms(sendSmsRequest);
        } catch (Exception e) {
            log.error("发送短信失败",e);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 申请短信模板
     * @param tempName 模板名称
     * @param tempType 模板类型 {@link AliTemplateTypeEnum}
     * @param content 内容变量用${}
     * @param remark 申请备注
     * @return 申请结果 {@link AliTemplateCheckEnum}
     */
    public static AddSmsTemplateResponseBody applyTemplateCode(String tempName,Integer tempType,String content,String remark){
        AddSmsTemplateRequest addSmsTemplateRequest=new AddSmsTemplateRequest();
        addSmsTemplateRequest.setTemplateType(tempType).setTemplateName(tempName)
                .setTemplateContent(content).setRemark(remark);
        try {
            AddSmsTemplateResponse addSmsTemplateResponse = client.addSmsTemplate(addSmsTemplateRequest);
            return  addSmsTemplateResponse.getBody();
        } catch (Exception e) {
            log.error("短信模板申请失败",e);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询模板状态
     * @param templateCode 模板
     * @return 审核状态
     */
    public static QuerySmsTemplateResponseBody queryTempStatus(String templateCode){
        QuerySmsTemplateRequest request=new QuerySmsTemplateRequest();
        request.setTemplateCode(templateCode);
        try {
            QuerySmsTemplateResponse querySmsTemplateResponse = client.querySmsTemplate(request);
           return querySmsTemplateResponse.getBody();
        } catch (Exception e) {
            log.error("查询短信模板失败",e);
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 删除短信模板,不支持删除正在审核中的模板,删除后不可恢复
     * @param templateCode 短信模板代码
     */
    public static DeleteSmsTemplateResponseBody deleteTemplate(String templateCode){
        DeleteSmsTemplateRequest request=new DeleteSmsTemplateRequest();
        request.setTemplateCode(templateCode);
        try {
            DeleteSmsTemplateResponse deleteSmsTemplateResponse = client.deleteSmsTemplate(request);
            return deleteSmsTemplateResponse.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args_) throws Exception {
     /*   Client client = Sample.createClient("LTAI4GBduxgBJo3ZG1vxKhKp", "mpLKSzyxoXCQmodW22MqEXi8lKwmfl");
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers("13576911130")
                .setSignName("赣游通")
                .setTemplateCode("SMS_197891332")
                .setTemplateParam("{\"code\":\"1234\"}");
        // 复制代码运行请自行打印 API 的返回值
        SendSmsResponse sendSmsResponse = client.sendSms(sendSmsRequest);
        SendSmsResponseBody body = sendSmsResponse.getBody();
        log.info("发送短信返回{}", JSONObject.toJSONString(sendSmsResponse));*/
        //您正在申请手机注册，验证码为：${code}，5分钟内有效！
     /*   AddSmsTemplateResponseBody addSmsTemplateResponse = Sample.applyTemplateCode("API测试模板", AliTemplateTypeEnum.VERIFY_CODE.code,
                "您正在申请手机注册，验证码为：${code}，5分钟内有效！", "API接入测试模板");
        log.info("短信模板返回数据{}",JSONObject.toJSONString(addSmsTemplateResponse));*/


/*        QuerySmsTemplateResponseBody responseBody = Sample.queryTempStatus("SMS_219480101");
        log.info("返回值{}",JSONObject.toJSONString(responseBody));*/


    }
}