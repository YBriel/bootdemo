package com.boot.bootdemo.filter.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.boot.bootdemo.exception.MyExp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一处理过滤请求：校验签名是否合法
 */
@Component
@Slf4j
public class TLSignInterceptor implements HandlerInterceptor {
   /* @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (Exception ex) {
            log.error("过滤器request请求包装时出现异常", ex);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (IOException e) {
                    log.error("过滤器request请求包装关闭流出现异常", e);
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (IOException e) {
                    log.error("过滤器request请求包装关闭流出现异常", e);
                }
            }
        }
        request.setAttribute("pars",stringBuilder.toString());
        return true;
    }*/

    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        RequestWrapper requestWrapper;
        if (request instanceof RequestWrapper) {
            requestWrapper = (RequestWrapper) request;
        } else {
            requestWrapper = new RequestWrapper(request);
        }

        String requestBody = requestWrapper.getBody();
        if (StringUtils.isBlank(requestBody)) {
            return true;
        }


        JSONObject jsonObject = null;
        try {
            jsonObject = JSONObject.parseObject(requestBody);
            log.info("拦截器中请求参数格式化后为：" + jsonObject.toJSONString());
        } catch (Exception ex) {
            log.error("签名时间戳全局拦截器请求消息转化出现异常", ex);
            throw new MyExp("参数错误");
        }

/*        Long timestamp = jsonObject.getLong("timestamp");
        String sign = jsonObject.getString("sign");
        if (timestamp == null || StringUtils.isBlank(sign)) {
            log.info("签名没传");
            throw new MyException(MyExpEnum.PARAM_DECODE_ERROR.getDesc());
        }*/
        return true;
    }
}