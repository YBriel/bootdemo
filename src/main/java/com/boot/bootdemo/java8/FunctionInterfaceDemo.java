package com.boot.bootdemo.java8;

import com.alibaba.fastjson.JSONObject;
import com.boot.bootdemo.entity.Person;
import com.boot.bootdemo.entity.Student;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.function.*;

/**
 * author: yuzq
 * create: 2021-04-05 21:12
 **/
@Slf4j
public class FunctionInterfaceDemo {

    private Student genStudent() {
        Supplier<Student> studentSupplier = () -> {
            Student s = new Student();
            s.setName("老王");
            return s;
        };
        return studentSupplier.get();
    }


    public static void main(String[] args) {
        log.info("=============断言============");
        Predicate<Student> studentPredicate = student -> student.getName().length() > 0;
        Student student = new Student();
        student.setName("23");
        boolean test = studentPredicate.test(student);
        System.out.println(test);

        log.info("=============消费============");

        Student consumerStudent = new Student();
        consumerStudent.setAge(1);
        log.info("stu年龄是{}", consumerStudent.getAge());
        Consumer<Student> studentConsumer = student1 -> {
            if (student1.getAge() > 0) {
                student1.setAge(student1.getAge() + 10);
                log.info("设置学生年龄加10");
            }
        };

        Consumer<Student> studentConsumer2 = student1 -> {
            if (student1.getName().length() > 2) {
                student1.setName("这是设置后的名字");
                log.info("设置学生名字长度加后缀");
            }
        };

        studentConsumer.accept(consumerStudent);
        Consumer<Student> studentConsumer1 = studentConsumer.andThen(studentConsumer2);
        log.info("stu年龄是{}", consumerStudent.getAge());


        log.info("============andThen消费============");

        Consumer<Integer> consumer = (x) -> {
            int num = x * 2;
            log.info("这是上面的");
            System.out.println(num);
        };
        Consumer<Integer> consumer1 = (x) -> {
            log.info("这是下面的");
            int num = x * 3;
            System.out.println(num);
        };
        consumer.andThen(consumer1).accept(10);

        log.info("=============BI消费============");
        BiConsumer<Student, Person> biConsumer = (s, p) -> {
            if (s.getAge() > 10) {
                log.info("学生年龄大于10了");
            }
            if (p.getAge() > 10) {
                log.info("老师年龄大于10了");
            }
        };

        Student biStu = new Student("tt", 10);
        Person person = new Person("12", 123);
        biConsumer.accept(biStu, person);


        log.info("=============转换============");

        Function<Student, Person> function = fun -> new Person(fun.getName(), fun.getAge());

        Student funStudent = new Student("张思", 4);
        Person apply = function.apply(funStudent);
        log.info("apply之后的数据为{}", JSONObject.toJSONString(apply));


        log.info("=============提供数据============");
        Supplier<String> uuidGenerator = () -> UUID.randomUUID().toString();
        log.info("提供数据之后的数据为{}", uuidGenerator.get());

        Supplier<Student> studentSupplier = () -> {
            Student s = new Student();
            s.setName("老王");
            return s;
        };
        log.info("提供数据之后的数据为{}", uuidGenerator.get());

        log.info("=============提供数据============");
    }
}
