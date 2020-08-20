package com.boot.bootdemo;

import com.boot.bootdemo.coupon.MyStrategy;
import com.boot.bootdemo.listener.OrderEvent;
import com.boot.bootdemo.listener.Student;
import com.boot.bootdemo.listener.StudentAddEvent;
import com.boot.bootdemo.login.Login;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.Codec;
import org.redisson.client.codec.StringCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.beans.BeanInfo;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/1   22:52
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = BootdemoApplication.class)
public class TestAspect {

    @Autowired
    private  ApplicationContext applicationContext;

    @Autowired
    private Login login;

    @Autowired
    private RedissonClient redisson;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void login(){
       // Login login=new Login();

        System.out.println("---");
    }

    @Test
    public void testListener(){
        Student student=new Student("tom","111");
        StudentAddEvent studentAddEvent=new StudentAddEvent(this,student);
        applicationContext.publishEvent(studentAddEvent);
    }

    @Test
    public void test1(){
        OrderEvent orderEvent=new OrderEvent("我发布了消息啊");
        applicationContext.publishEvent(orderEvent);
    }

    @Test
    public void test12(){
        RBucket<Object> test = redisson.getBucket("test", StringCodec.INSTANCE);

        //System.out.println(test.get());
    }

    @Test
    public void test() throws IOException {

        final String APPLICATION_PDF = "audio/x-wav";
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
          /*  List list = new ArrayList<>();
            list.add(MediaType.APPLICATION_PDF);
            headers.setAccept(list);*/
            HttpHeaders headers = new HttpHeaders();
           // headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            headers.setContentType(MediaType.APPLICATION_PDF);
            ResponseEntity<byte[]> response = restTemplate.exchange("https://111.44.229.179/sp-jr5l5ozkv5k64m192bk6mjuum4iq/20081910030112056461784.wav?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20200819T100630Z&X-Amz-SignedHeaders=host&X-Amz-Expires=604800&X-Amz-Credential=CEC70C94735204731F91%2F20200819%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=0272cb2fa1bc37baf961f3d27e2c3bcff62feeea634f6a3faec1827eb49bad16", HttpMethod.GET, new HttpEntity<byte[]>(headers), byte[].class);

            byte[] result = response.getBody();

            inputStream = new ByteArrayInputStream(result);

            File file = new File("/aaa.wav");
            if (!file.exists()) {
                file.createNewFile();
            }

            outputStream = new FileOutputStream(file);
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = inputStream.read(buf, 0, 1024)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.flush();

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }


    @Test
    public void test22(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<Resource> httpEntity = new HttpEntity<Resource>(headers);
        RestTemplate template = new RestTemplate();
        ResponseEntity<byte[]> response = template.exchange("https://111.44.229.179/sp-jr5l5ozkv5k64m192bk6mjuum4iq/20081910030112056461784.wav?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20200819T100630Z&X-Amz-SignedHeaders=host&X-Amz-Expires=604800&X-Amz-Credential=CEC70C94735204731F91%2F20200819%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=0272cb2fa1bc37baf961f3d27e2c3bcff62feeea634f6a3faec1827eb49bad16", HttpMethod.GET,
                httpEntity, byte[].class);
        try {
            List<String> cookies = response.getHeaders().get("Set-Cookie");
            for (String cookie : cookies) {
                System.out.println(cookie);
            }
            File file = File.createTempFile("ess-", "." + response.getHeaders().getContentType().getSubtype());
            System.out.println(file.getName());
            System.out.println(file.getAbsolutePath());
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(response.getBody());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void test23(){


    }
}
