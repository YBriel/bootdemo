package com.boot.bootdemo.util;

import javax.net.ssl.*;
import java.io.*;
import java.net.URL;

/**
 * author: yuzq
 * create: 2020-08-20 09:14
 **/
public class SSLUtil {

    /**
     * 根据文件url地址来下载文件
     * @param urlPath           文件url地址
     * @param storageDirectory  文件存储目录
     * @return
     */
    public static File downloadFileByUrl(String urlPath, String storageDirectory, Long orderId)   {
        File file=null;
        try {
            SSLContext sslcontext = SSLContext.getInstance("SSL", "SunJSSE");
            sslcontext.init(null, new TrustManager[] { new X509TrustUtil() }, new java.security.SecureRandom());
            URL url = new URL(urlPath);
            HostnameVerifier ignoreHostnameVerifier = new HostnameVerifier() {
                public boolean verify(String s, SSLSession sslsession) {
                    System.out.println("WARNING: Hostname is not matched for cert.");
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(ignoreHostnameVerifier);
            HttpsURLConnection.setDefaultSSLSocketFactory(sslcontext.getSocketFactory());
            HttpsURLConnection urlCon = (HttpsURLConnection) url.openConnection();
            urlCon.setConnectTimeout(6000);
            urlCon.setReadTimeout(6000);

            BufferedInputStream bis = new BufferedInputStream(urlCon.getInputStream());
            String path= storageDirectory+orderId+"_"+System.currentTimeMillis()+".wav";
            file=new File(path);
            BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(file));
            int len;
            byte[]buf=new byte[2048];
            while ((len=bis.read(buf))!=-1){
                bos.write(buf,0,len);
            }
            bis.close();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return file;
        }

    }

    public static void main(String[] args) {
        SSLUtil.downloadFileByUrl("https://111.44.229.179/sp-jr5l5ozkv5k64m192bk6mjuum4iq/20081910030112056461784.wav?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20200819T100630Z&X-Amz-SignedHeaders=host&X-Amz-Expires=604800&X-Amz-Credential=CEC70C94735204731F91%2F20200819%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=0272cb2fa1bc37baf961f3d27e2c3bcff62feeea634f6a3faec1827eb49bad16","D:",1111L);
    }
}
