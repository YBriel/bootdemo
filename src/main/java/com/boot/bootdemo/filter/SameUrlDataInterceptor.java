package com.boot.bootdemo.filter;

import com.alibaba.fastjson.JSONObject;
import com.boot.bootdemo.aspect.SameUrlData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Title: 防止用户重复提交数据拦截器
 * Description: 将用户访问的url和参数结合token存入redis，每次访问进行验证是否重复请求接口
 */
//@Component
public class SameUrlDataInterceptor extends HandlerInterceptorAdapter {

  private static Logger LOG = LoggerFactory.getLogger(SameUrlDataInterceptor.class);

  private static ConcurrentHashMap<String,Object> mapp= new ConcurrentHashMap<>();

  /**
   * 是否阻止提交,fasle阻止,true放行
   * @return
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    return true;
   /* LOG.info("走了这个拦截器");
    if (handler instanceof HandlerMethod) {
      HandlerMethod handlerMethod = (HandlerMethod) handler;
      Method method = handlerMethod.getMethod();
      SameUrlData annotation = method.getAnnotation(SameUrlData.class);
      if (annotation != null) {
        if(repeatDataValidator(request)){
          //请求数据相同
          LOG.warn("please don't repeat submit,url:"+ request.getServletPath());
          JSONObject result = new JSONObject();
          result.put("statusCode","500");
          result.put("message","请勿重复请求");
          response.setCharacterEncoding("UTF-8");
          response.setContentType("application/json; charset=utf-8");
          response.getWriter().write(result.toString());
          response.getWriter().close();
//          拦截之后跳转页面
//          String formRequest = request.getRequestURI();
//          request.setAttribute("myurl", formRequest);
//          request.getRequestDispatcher("/WebRoot/common/error/jsp/error_message.jsp").forward(request, response);
          return false;
        }else {//如果不是重复相同数据
          return true;
        }
      }
      return true;
    } else {
      return super.preHandle(request, response, handler);
    }*/
  }
  /**
   * 验证同一个url数据是否相同提交,相同返回true
   * @param httpServletRequest
   * @return
   */
  public boolean repeatDataValidator(HttpServletRequest httpServletRequest){
    //获取请求参数map
    Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
    Iterator<Map.Entry<String, String[]>> it = parameterMap.entrySet().iterator();
    String token = "";
    Map<String, String[]> parameterMapNew = new HashMap<>();
    while(it.hasNext()){
      Map.Entry<String, String[]> entry = it.next();
      if(!entry.getKey().equals("timeStamp") && !entry.getKey().equals("sign")){
        //去除sign和timeStamp这两个参数，因为这两个参数一直在变化
        parameterMapNew.put(entry.getKey(), entry.getValue());
        if(entry.getKey().equals("token")) {
          token = entry.getValue()[0];
        }
      }
    }
/*    if (StringUtils.isBlank(token)){
      //如果没有token，直接放行
      return false;
    }*/
    //过滤过后的请求内容
    String params = JSONObject.toJSONString(parameterMapNew);

    System.out.println("params==========="+params);

    String url = httpServletRequest.getRequestURI();
    Map<String,String> map = new HashMap<>();
    //key为接口，value为参数
    map.put(url, params);
    String nowUrlParams = map.toString();

    //StringRedisTemplate smsRedisTemplate = SpringKit.getBean(StringRedisTemplate.class);
    String redisKey = token + url;
   Object preUrlParams=  mapp.get(redisKey);
   // String preUrlParams = smsRedisTemplate.opsForValue().get(redisKey);
    if(preUrlParams == null){
      //如果上一个数据为null,表示还没有访问页面
      //存放并且设置有效期，2秒
      mapp.put(redisKey,nowUrlParams);
      //smsRedisTemplate.opsForValue().set(redisKey, nowUrlParams, 2, TimeUnit.SECONDS);
      return false;
    }else{//否则，已经访问过页面
      if(preUrlParams.equals(nowUrlParams)){
        //如果上次url+数据和本次url+数据相同，则表示重复添加数据
        return true;
      }else{//如果上次 url+数据 和本次url加数据不同，则不是重复提交
        mapp.put(redisKey,nowUrlParams);
        //smsRedisTemplate.opsForValue().set(redisKey, nowUrlParams, 1, TimeUnit.SECONDS);
        return false;
      }
    }
  }
}