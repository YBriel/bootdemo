package com.boot.bootdemo.controller;

import com.boot.bootdemo.login.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/1   23:19
 */
@Controller
@CrossOrigin("*")
public class LoginController extends BaseController{

    @Autowired
    private Login login;

    @RequestMapping("/login")
    public void login(){
        login.login();
    }

    @RequestMapping("/filter")
    @ResponseBody
    public String filterTest(){
            return "hello";
    }


    @RequestMapping("/myInterceptor")
    @ResponseBody
    public String myInterceptor(){
        return "myInterceptor";
    }

    @RequestMapping("/testList")
    @ResponseBody
    public void testList(@RequestBody Object person){
//        JSONObject.parseArray()

      /*  for (Person person1 : person) {
            System.out.println(person1.getName());
        }
        System.out.println(person);*/
    }

    @RequestMapping("/testPrint")
    public void testPrint(HttpServletResponse response) throws IOException {
        String s="<form name=\"punchout_form\" method=\"post\" action=\"https://openapi.alipaydev.com/gateway.do?charset=UTF-8&method=alipay.trade.wap.pay&sign=gmwafbNMvhYD9Qmwk1ihRiki8jTKBdJTg%2BKdPavOr4d3W0AU0ZYYb5kibbtujP%2B35gORPDkzbkDmNudT55ivkIn%2BdFxRK3GrUira67mXzgvDlMSH6F%2B58hknfeA12NfXbsp%2B%2FfUtNl7bYmElhi99e7a2P0Y8uRKch5iz2JuibQL3VHs16AlauX52Gejuel25mJR%2BNe%2Fg4wywPAkTyGnXkCq0gHuP9Ttl9Rv837iaetSEHacsT9YSNIRRflPQJWY4Dj88WuGFQJSwaeAKevDzaDSEExMZLKjjcflpXQuF6g85IuslqDlhiU44dIVhRCyzMFVQIhszWsbWQyBKVFnKdA%3D%3D&notify_url=http%3A%2F%2F39.106.121%3A8088%2Fcommunity%2FaliPay%2FaliNotify&version=1.0&app_id=2016100100638435&sign_type=RSA2&timestamp=2020-02-20+20%3A12%3A55&alipay_sdk=alipay-sdk-java-4.8.10.ALL&format=json\">\n" +
                "<input type=\"hidden\" name=\"biz_content\" value=\"{&quot;body&quot;:&quot;牧之社区超市&quot;,&quot;out_trade_no&quot;:&quot;202002202012551004&quot;,&quot;product_code&quot;:&quot;QUICK_WAP_WAY&quot;,&quot;subject&quot;:&quot;Car{id=1, pid=1004, price=22, num=2, desc=不酸的桃子, title=新鲜桃子, status=1, check=1}等4件商品&quot;,&quot;timeout_express&quot;:&quot;2m&quot;,&quot;total_amount&quot;:&quot;154&quot;}\">\n" +
                "<input type=\"submit\" value=\"立即支付\" style=\"display:none\" >\n" +
                "</form>\n" +
                "<script>document.forms[0].submit();</script>";

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(s);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/postTest")
    @ResponseBody
    public String postTest( int age){
        System.out.println(age);
        return "hello";
    }

    @PostMapping("/postLogin")
    @ResponseBody
    public ReturnObj postLogin( String email,String password){
        System.out.println(email+password);
        return new ReturnObj(200,"成功凉了","email");
    }

    @RequestMapping("/mstore/testHeader")
    public String testHeader(HttpServletRequest request){
        System.out.println(token);
        System.out.println(version);
        return "sss";
    }
}
