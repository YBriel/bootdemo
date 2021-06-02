package com.boot.bootdemo.util.file;

import java.io.*;
import java.net.URI;
import java.net.URL;


import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

//@Component
public class EttpCustomApplicationTests {

/*    @Autowired
    ResourceLoader resourceLoader;
    
    

    public void testReaderFile() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:resource.properties");
        InputStream is = resource.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String data = null;
        while((data = br.readLine()) != null) {
            System.out.println(data);
        }
        
        br.close();
        isr.close();
        is.close();
    }*/

    public static void testReadFile() throws IOException {
//        ClassPathResource classPathResource = new ClassPathResource("resource.properties");
        Resource resource = new ClassPathResource("1902271423530473681.pfx");
        String filename = resource.getFilename();
        URI uri = resource.getURI();
        URL url = resource.getURL();
        InputStream is = resource.getInputStream();
        File cert=new File("cert.cer");
        FileUtils.copyInputStreamToFile(is,cert);
        System.out.println(cert.getAbsolutePath());
    }

    public static void main(String[] args) throws IOException {
        EttpCustomApplicationTests.testReadFile();
    }

}