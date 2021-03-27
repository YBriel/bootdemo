package com.boot.bootdemo.filter.interceptor;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.util.Base64;

/**
 * 由于request数据读取一次就无法读取，因此通过包装类来解决
 */
@Slf4j
public class RequestWrapper extends HttpServletRequestWrapper {
    private final String body1;
    
    public RequestWrapper(HttpServletRequest request) {
        /**
         * 由于继承了HttpServletRequestWrapper，HttpServletRequestWrapper又继承了ServletRequestWrapper，ServletRequestWrapper
         * 中有一个private ServletRequest request;也就是将原来的request做了一个备份，具体读到的数据放在body1中
         */
        super(request);
        body1 = inputStream2String(request);
        log.info("过滤器request请求包装结果为：" + body1);
    }

    @Override
    public ServletInputStream getInputStream() {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body1.getBytes());
        ServletInputStream servletInputStream = new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }
            @Override
            public boolean isReady() {
                return false;
            }
            @Override
            public void setReadListener(ReadListener readListener) {
            }
            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
        return servletInputStream;

    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

    private String inputStream2String(HttpServletRequest request){
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
        byte[] decode2 = Base64.getDecoder().decode(stringBuilder.toString().getBytes());
        return new String(decode2);
    }

    public String getBody() {
        return this.body1;
    }
}