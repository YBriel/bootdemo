package com.boot.bootdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boot.bootdemo.aspect.*;
import com.boot.bootdemo.cache.MyCacheService;
import com.boot.bootdemo.config.MyResult;
import com.boot.bootdemo.config.MyResultUtil;
import com.boot.bootdemo.entity.MyStudentEntity;
import com.boot.bootdemo.entity.Student;
import com.boot.bootdemo.entity.TaskEntity;
import com.boot.bootdemo.mapper.StudentMapper;
import com.boot.bootdemo.service.MyFutureTask;
import com.boot.bootdemo.service.MyRunnableTest;
import com.boot.bootdemo.service.StudentService;
import com.boot.bootdemo.util.Base64ToPdf;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.result.DefaultResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/4/11   20:04
 */
@RestController
@Slf4j
public class StudentController {

    @Resource
    private StudentService studentService;

    @Resource
    private StudentMapper studentMapper;
    @Resource
    private SqlSession sqlSession;

    @Autowired
    private MyFutureTask futureTask;

    @Autowired
    private MyCacheService cacheService;

    @Resource
    private ThreadPoolTaskExecutor testThreadPool;

    private  ExecutorService executorService=Executors.newFixedThreadPool(5);;

    @RequestMapping("/testStu")
    @SameUrlData
    public void testStu(String name){
        Student student=new Student();
        student.setAge(33);
        student.setName(name);
        boolean save = studentService.save(student);
        System.out.println("最后的"+student.getId());
    }

    @RequestMapping("/testParam")
    public String testParam(@RequestParam(value = "id",required = false)String id,@RequestParam(value = "name",required = true)String name){
      //  ExecutorService executorService=Executors.newCachedThreadPool();
        boolean shutdown0 = executorService.isShutdown();
        System.out.println("是否关闭---"+shutdown0);
         //executorService= Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            System.out.println("哈哈哈;");
            System.out.println(Thread.currentThread().getName()+Thread.currentThread().getId()+"在运行");
        });
        boolean shutdown = executorService.isShutdown();
        System.out.println("是否关闭---"+shutdown);
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        System.out.println("Thread.getAllStackTraces()---"+allStackTraces.size());
        System.out.println("请求进来了:"+id+name);
        //executorService.shutdown();
        boolean shutdown2 = executorService.isShutdown();
        System.out.println("是否关闭---"+shutdown2);
        System.out.println(executorService);
        return name;
    }

    @RequestMapping("/testLambda")
    public List<Student> testLambda(){
        //boolean shutdown = executorService.isShutdown();
        //System.out.println("是否关闭---"+shutdown);
        List<Student> list1 = studentService.list();
        List<Student> list = studentService.list(new LambdaQueryWrapper<>(new Student()).select(Student::getId, Student::getName));
        //List<Student> list1 = studentService.list(new LambdaQueryWrapper<>(new Student()).);
        return list1;
    }

    @RequestMapping("/deleteStu")
    public boolean deleteStu(int id){
        List<Student> list = studentService.list();
        Student byId = studentService.getById(id);
        QueryWrapper<Student> studentQueryWrapper=new QueryWrapper<>();
        studentQueryWrapper.eq("id",id);
        Student one = studentService.getOne(studentQueryWrapper);
        return studentService.remove(studentQueryWrapper);
        //List<Student> list1 = studentService.list(new LambdaQueryWrapper<>(new Student()).);
    }

    @RequestMapping("/getStu")
    public boolean getStu(int id){
        QueryWrapper<Student> studentQueryWrapper=new QueryWrapper<>();
        studentQueryWrapper.eq("id",id);
        Student one = studentService.getOne(studentQueryWrapper);
        QueryWrapper<Student> studentQueryWrapper1r=new QueryWrapper<>();
        studentQueryWrapper1r.eq("id",id);
        Student www = studentService.getOne(studentQueryWrapper);
        return one==null;
        //List<Student> list1 = studentService.list(new LambdaQueryWrapper<>(new Student()).);
    }

    @RequestMapping("/insertStu")
    public boolean insertStu(int id){
        MyStudentEntity stu=new MyStudentEntity(id,"tom",33);
        MyStudentEntity myStudentEntity = stu.queryStudentById(id);
        MyStudentEntity myStudentEntity1 = stu.selectById(id);
        return stu.insert();
        //List<Student> list1 = studentService.list(new LambdaQueryWrapper<>(new Student()).);
    }

    @RequestMapping("/updateStu")
    public boolean updateStu(int id){
        Student byId = studentService.getById(id);
        if(byId!=null){
            byId.setName("ttt");
            return studentService.saveOrUpdate(byId);
        }
        return false;
        //List<Student> list1 = studentService.list(new LambdaQueryWrapper<>(new Student()).);
    }

    @RequestMapping("/mapperSelect")
    public boolean mapperSelect(int id) throws SQLException {

        Connection connection = sqlSession.getConnection();
     /*   PreparedStatement preparedStatement = connection.prepareStatement("select  * from student where id=" + id);
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSet resultSet1 = preparedStatement.executeQuery();
        ResultSet resultSet2 = preparedStatement.executeQuery();*/
        List<Student> objects = sqlSession.selectList("select * from student");
        sqlSession.select("select * from student where id="+id, new DefaultResultHandler());
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //SqlSession sqlSession
      /*  Student query1 = mapper.query(id);
        Student query11 = mapper.query(id);
        Student query22 = mapper.query(id);
        Student query31 = mapper.query(id);*/
        return true;
        //List<Student> list1 = studentService.list(new LambdaQueryWrapper<>(new Student()).);
    }

    @RequestMapping("/getStuLambda")
    @LogPrint(title = "测试日志")
    public List<Student> getStuLambda(int id){
        List<Student> list = studentService.list(new LambdaQueryWrapper<Student>().gt(Student::getId, 1));
        return list;
        //List<Student> list1 = studentService.list(new LambdaQueryWrapper<>(new Student()).);
    }

    @RequestMapping("/testLambda11")
    public int testLambda11() throws InterruptedException {
        for (int i = 0; i < 2850; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName()+ " will sleep");
                    Thread.sleep(5000);
                    QueryWrapper<Student> studentQueryWrapper=new QueryWrapper<>();
                    studentQueryWrapper.eq("id",Math.random());
                    Student one = studentService.getOne(studentQueryWrapper);
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
        Thread.sleep(20000);

        //List<Student> list1 = studentService.list(new LambdaQueryWrapper<>(new Student()).);
        return 1;
    }

    @RequestMapping("/testStudentDict")
   // @Dict
    @LogPrint(title = "测试日志")
    public Student query(String name,Integer age){
        Student student = studentService.queryStu(name,age);
        return student;
    }

    @RequestMapping("/querySt")
   // @EnableAuthCheck(userName = "200")
    @LogPrint(title = "querySt",desc = "查询学生",note = "标记")
    public Student querySt(Student student){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return student;
    }

    @RequestMapping("/queryStJson")
    // @EnableAuthCheck(userName = "200")
    @LogPrint(title = "queryStJson",desc = "查询学生",note = "标记")
    public Student queryStJson(@RequestBody Student student){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return student;
    }

  //  @EnableAuthCheck
    @RequestMapping("/queryStu")
    //@Dict
    public MyResult<Student> queryStu(String name, Integer age){
        System.out.println(name+"---"+age);
       /* Student student = studentService.queryStu(name,age);
        return MyResultUtil.succ(student);*/
       return MyResultUtil.succ(new Student(name,age));
    }

    @RequestMapping("/updStuById")
    public Integer updStuById(Integer id,String name){
        return studentService.updStuById(id,name);
    }

    @RequestMapping("/testException")
    public String testException(){
        Student student=new Student();
        String substring = student.getName().substring(1, 3);
        try {

            if(StringUtils.isEmpty(student.getId())){
                System.out.println("出异常了");
            }
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("出异常了");
        }
        return "哈哈哈";
    }

    @RequestMapping("/testException1")
    public String testException1(){
        Student student=new Student();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //String[] split = student.getName().split(",");
/*        if(StringUtils.isEmpty(student.getName())){
           try {

           }catch (NullPointerException e){
               e.printStackTrace();
               System.out.println("空指针异常了。。。。。。");
           }
//            throw new NullPointerException();
            System.out.println("哈哈哈哈");
        }*/
        return "哈哈哈1";
    }


    @RequestMapping("/testThreadPool")
    public String testThreadPool(){
       return studentService.testThreadPool();
    }

    @RequestMapping("/futureTask")
    public String futureTask() throws InterruptedException, ExecutionException, TimeoutException {
        String s = futureTask.futureTask();
        if(StringUtils.isEmpty(s)){
            return "ssssss";
        }
        return s;
    }

    @RequestMapping("/futureTaskDe")
    public String futureTaskDe() {
        return futureTask.futureTaskDemo();
    }

    @RequestMapping("/futureTaskDemo")
    public String futureTaskDemo(long time,long sleepTime){
        return futureTask.futureTaskDemo(time,sleepTime);
    }

    @RequestMapping("/futureTaskCall")
    public String futureTaskCall(long time,long sleepTime) throws ExecutionException, InterruptedException {
        return futureTask.futureTaskPoolCallable(time,sleepTime);
    }

    @RequestMapping("/testWait")
    public String testWait(){
       log.info("这是里面的开始");
        testThreadPool.submit(new AsyncTest());
        log.error("这是里面的开始");
        try {
            int a=10/0;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("出问题了",e);
        }
        return "success";
    }

    @RequestMapping("/testRunnable")
    public String testRunnable(){
        System.out.println("这是里面的开始");
        testThreadPool.submit(new MyRunnableTest("我是名字"));
        System.out.println("这是里面的开始");
        return "success";
    }

    @RequestMapping("/testCallable")
    public String testCallable(){
        System.out.println("这是里面的开始");
        testThreadPool.submit(new MyRunnableTest("我是名字"));
        System.out.println("这是里面的开始");
        return "success";
    }

    @RequestMapping("/testCache")
    public String testCache(String name){
        return cacheService.findUserById(name);
    }

    @RequestMapping("/uploadMethodStr")
    @LogPrint(title = "上传文件")
    public String uploadMethod(@RequestParam("file") MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String name = file.getName();
        String contentType = file.getContentType();
        long size1 = file.getSize();
        System.out.println(size1);
        if (!file.isEmpty()) {
            try {
                long size = file.getSize();
                int i = 2*1024 * 1024;
                if(size>i){
                    return "error";
                }
                Student student=new Student();
                BASE64Encoder encoder = new BASE64Encoder();
                // 通过base64来转化图片
                String data = encoder.encode(file.getBytes());
                Base64ToPdf.base64StringToPdf(data,"D:aaa.pdf");
                System.out.println(data.length());
                return "data";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @RequestMapping("/testSubmit")
    public String test111(){
        return futureTask.test111();
    }


    @RequestMapping("/testThread")
    public String test1111(){
        return futureTask.test1111();
    }
    @RequestMapping("/blockedTest")
    public void blockedTest() throws InterruptedException {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");

        a.start();
        //Thread.sleep(1000L);
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
    }

    @RequestMapping("getStudent1Ds")
    @EnableAuthCheck
    public Student getStudent1(Integer id){
        return studentService.getStudent1(id);
    }

    @RequestMapping("getStudentDs")
    public Student getStudent(Integer id){
        return studentService.getStudent(id);
    }

    private synchronized void testMethod() {
        try {
            log.info("开始执行");
            System.out.println("哈哈哈哈");
            Thread.sleep(2000L);
            log.info("开始执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testMap(){
        Map<String, String> map = studentMapper.queryAllTask().stream().collect(Collectors.toMap(TaskEntity::getJobName, TaskEntity::getJobStatus));
        //Map<String, String> map1 = studentMapper.queryAllTask().stream().collect(Collectors.toCollection());

    }
}
