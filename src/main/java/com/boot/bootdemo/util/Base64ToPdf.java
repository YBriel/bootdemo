package com.boot.bootdemo.util;

import sun.misc.BASE64Decoder;

import java.io.*;

/**
 * author: yuzq
 * create: 2020-10-14 14:42
 **/
public class Base64ToPdf {

    public static void base64StringToPdf(String base64Content,String filePath) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
            byte[] bytes = decoder.decodeBuffer(base64Content);//base64编码内容转换为字节数组
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytes);
            bis = new BufferedInputStream(byteInputStream);
            File file = new File(filePath);
            File path = file.getParentFile();
            if(!path.exists()){
                path.mkdirs();
            }
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[1024];
            int length = bis.read(buffer);
            while(length != -1){
                bos.write(buffer, 0, length);
                length = bis.read(buffer);
            }
            bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            assert bis != null;
            bis.close();
            assert fos != null;
            fos.close();
            bis.close();

        }
    }


    public static void main(String[] args) {

    }
}
