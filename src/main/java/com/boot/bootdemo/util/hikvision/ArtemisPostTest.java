/*
package com.boot.bootdemo.util.hikvision;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;


*/
/**
 * Auto Create on 2021-05-13 11:45:13
 *//*

public class ArtemisPostTest {
	*/
/**
	 * 请根据自己的appKey和appSecret更换static静态块中的三个参数。
	 *//*

	static {
		ArtemisConfig.host = "open8200.hikvision.com"; // artemis网关服务器ip端口
		ArtemisConfig.appKey = "请填入appKey"; // 秘钥appkey
		ArtemisConfig.appSecret = "请填入appSecret";// 秘钥appSecret
	}
	*/
/**
	 * 能力开放平台的网站路径
	 * 路径不用修改，就是/artemis
	 *//*

	private static final String ARTEMIS_PATH = "/artemis";

	//获取所有树编码
	public static String getAllTreeCode(GetAllTreeCodeRequest getAllTreeCodeRequest ){
		String getAllTreeCodeDataApi = ARTEMIS_PATH +"/api/resource/v1/unit/getAllTreeCode";
		Map<String,String> path = new HashMap<String,String>(2){
			{
				put("https://",getAllTreeCodeDataApi);
			}
		};
		String body=JSON.toJSONString(getAllTreeCodeRequest);
		String result =ArtemisHttpUtil.doPostStringArtemis(path,body,null,null,"application/json");
		return result;
	}

	//分页获取区域列表
	public static String regions(RegionsRequest regionsRequest ){
		String regionsDataApi = ARTEMIS_PATH +"/api/resource/v1/regions";
		Map<String,String> path = new HashMap<String,String>(2){
			{
				put("https://",regionsDataApi);
			}
		};
		String body=JSON.toJSONString(regionsRequest);
		String result =ArtemisHttpUtil.doPostStringArtemis(path,body,null,null,"application/json");
		return result;
	}

	//获取根区域信息
	public static String root(RootRequest rootRequest ){
		String rootDataApi = ARTEMIS_PATH +"/api/resource/v1/regions/root";
		Map<String,String> path = new HashMap<String,String>(2){
			{
				put("https://",rootDataApi);
			}
		};
		String body=JSON.toJSONString(rootRequest);
		String result =ArtemisHttpUtil.doPostStringArtemis(path,body,null,null,"application/json");
		return result;
	}

	//根据区域编号获取下一级区域列表
	public static String subRegions(SubRegionsRequest subRegionsRequest ){
		String subRegionsDataApi = ARTEMIS_PATH +"/api/resource/v1/regions/subRegions";
		Map<String,String> path = new HashMap<String,String>(2){
			{
				put("https://",subRegionsDataApi);
			}
		};
		String body=JSON.toJSONString(subRegionsRequest);
		String result =ArtemisHttpUtil.doPostStringArtemis(path,body,null,null,"application/json");
		return result;
	}


}
*/
