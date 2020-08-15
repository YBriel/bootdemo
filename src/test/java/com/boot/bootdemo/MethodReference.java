package com.boot.bootdemo;

import com.boot.bootdemo.entity.Student;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.MyResultoList;

/**
 * 方法引用
 * <p>
 * 1. 指向静态方法的方法引用
 * 2. 指向现有对象的实例方法的方法引用
 *
 * @author biezhi
 * @date 2018/2/10
 */
public class MethodReference {

    public static List<Integer> findNumbers(List<Integer> numbers, Predicate<Integer> filter) {
        List<Integer> numbersFound = numbers
                .stream()
                .filter(filter)
                .collect(toList());

        return numbersFound;
    }

    public static boolean multipleOf3(Integer number) {
        return (number % 3) == 0;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(501, 23, 6, 8, 9, 12, 14, 15);
        List<Integer> collect1 = numbers.stream().sorted(Comparator.comparing(Integer::intValue)).collect(toList());
        System.out.println(collect1);
        List<Integer> collect2 = numbers.stream().sorted(Comparator.naturalOrder()).collect(toList());
        System.out.println(collect2);
        List<Integer> collect3 = numbers.stream().sorted(Comparator.reverseOrder()).collect(toList());
        System.out.println(collect3);
        Student student = new Student("tom", 11);
        Student student1 = new Student("jerry", 21);
        Student student2 = new Student("jack", 1);
        Student student3 = new Student("jack", 1);
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        List<Student> collect4 = students.stream().sorted(Comparator.comparing(Student::getAge)).distinct().collect(toList());
        List<Student> collect5 = students.stream().sorted(Comparator.comparing(Student::getAge)).collect(toList());
        List<Student> collect6 = students.stream().filter(p -> p.getAge() > 20).collect(toList());
        // collect5.forEach(System.out::println);
        collect6.forEach(System.out::println);
        List<Integer> multiplesOf3 = findNumbers(numbers, MethodReference::multipleOf3);
        System.out.println(multiplesOf3.contains(3));
        Project project = Project.builder().name("Blade").build();
        Arrays.asList(project).stream()
                .map(Project::getName)
                .count();

        System.out.println("年龄"+students.stream().allMatch(p -> p.getAge() > 0));
        List<String> collect = Stream.of(project)
                .sorted(Comparator.comparing(Project::getStars))
                .map(Project::getName).collect(toList());
        List<Student> collect7 = Stream.of(student, student1, student2).collect(toList());
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e)).collect(toList());

        System.out.println("----------reduce----");

        //reduce
        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println(concat);
// 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println(minValue);
// 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println(sumValue);
// 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.println(sumValue);
// 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
        System.out.println(concat);

        Optional<List<Student>> students1 = Optional.of(students);
/*        Optional<List<Student>> students2 = Optional.ofNullable(students);
        System.out.println(students1.isPresent());
        students2.isPresent();
        Optional<Object> empty = Optional.empty();*/

        students.forEach(dto->
                System.out.println(dto.getAge()));

        students.forEach(dto->{
            if(dto.getAge()>1){

            }
        });
    }

}
