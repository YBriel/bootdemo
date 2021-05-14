package com.boot.bootdemo.util.hikvision;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;


/**
 * Auto Create on 2021-05-14 09:32:04
 */
public class ArtemisPostTest {
	/**
	 * 请根据自己的appKey和appSecret更换static静态块中的三个参数。
	 */
	static {
		ArtemisConfig.host = "223.82.146.66:443"; // artemis网关服务器ip端口
		ArtemisConfig.appKey = "27684269"; // 秘钥appkey
		ArtemisConfig.appSecret = "oJxn64Y3pgCElohEyzmU";// 秘钥appSecret
	}
	/**
	 * 能力开放平台的网站路径
	 * 路径不用修改，就是/artemis
	 */
	private static final String ARTEMIS_PATH = "/artemis";

	//按事件类型获取事件订阅信息
	public static String getTopicInfo(GetTopicInfoRequest getTopicInfoRequest ){
		String getTopicInfoDataApi = ARTEMIS_PATH +"/api/common/v1/event/getTopicInfo";
		Map<String,String> path = new HashMap<String,String>(2){
			{
				put("https://",getTopicInfoDataApi);
			}
		};
		String body= JSON.toJSONString(getTopicInfoRequest);
		String result =ArtemisHttpUtil.doPostStringArtemis(path,body,null,null,"application/json");
		return result;
	}

	public static void main(String[] args) {
		String topicInfo = ArtemisPostTest.getTopicInfo(new GetTopicInfoRequest(Arrays.asList("3187675137")));
		System.out.println(topicInfo);
	}

}
