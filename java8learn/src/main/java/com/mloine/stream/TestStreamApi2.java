package com.mloine.stream;

import com.mloine.Entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @className: TestStreamApi2
 * @Description:TOO Stream中间操作
 * @Author:mloine
 * @Date：2019/6/312:31
 **/
public class TestStreamApi2 {

    List<Employee> employeeList = Arrays.asList (
            new Employee ("zhangsan",18,5999),
            new Employee ("lisi",38,6999),
            new Employee ("wangwu",50,3399),
            new Employee ("zhaoliu",16,6999),
            new Employee ("tianqi",8,7999),
            new Employee ("tianqi",8,7999),
            new Employee ("tianqi",8,7999)
    );

    //中间操作 内部迭代
    @Test
    public void test1(){

        //过滤 中间操作
        Stream<Employee> employeeStream = employeeList.stream ()
                .filter ((x) -> {
                    System.out.println ("Stream API 的中间操作");
                    return x.getAge () > 35;

        });

        //终止操作 一次性执行全部操作
        employeeStream.forEach (System.out::println);
    }

    //外部迭代
    @Test
    public void test2(){
        Iterator<Employee> iterator =
                employeeList.iterator ();

        while(iterator.hasNext ()){
            System.out.println (iterator.next ());
        }

    }
    @Test
    public void test3(){
        // 截断
        employeeList.stream ()
                .filter ((e)->{
                    System.out.println ("短路！");
                       return e.getSlary ()>5000;
                })
                .limit (2)//找满足两个符合条件的数据后 后续都不会执行用于提高效率
        .forEach (System.out::println);

    }
    @Test
    public void test4(){
        //跳过
        employeeList.stream ()
                .filter ((e)->e.getSlary ()>5000)
                .skip (2)//只取后两位比较
                .distinct ()//用equals 和 hashcode 比较 去重
                .forEach (System.out::println);
    }

    //映射
    @Test
    public void test5(){
        List<String> stringList = Arrays.asList ("aaa", "bbb", "ccc", "ddd", "eee");

        stringList.stream ()
                .map ((x)-> x.toUpperCase ())
                .forEach (System.out::println);

        System.out.println ("--------------------------------");

        employeeList.stream ()
                .map ((x)->x.getEmpName ())
                .forEach (System.out::println);

        System.out.println ("--------------------------------");
        Stream<Stream<Character>> streamStream = stringList.stream ()
                .map (TestStreamApi2::filterCharacter);

        streamStream.forEach ((x)-> {
            x.forEach (System.out::println);
        });

        System.out.println ("--------------------------------");
        //flatMap
        Stream<Character> characterStream = stringList.stream ()
                .flatMap (TestStreamApi2::filterCharacter);

        characterStream.forEach (System.out::println);

    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list= new ArrayList<> ();

        for (Character ch : str.toCharArray ()){
            list.add (ch);
        }
        return list.stream ();
    }

    //排序
    @Test
    public void test7(){
        List<String> stringList = Arrays.asList ("aaa", "bbb", "ccc", "ddd", "eee");

        stringList.stream ().sorted ().forEach (System.out::println);

        employeeList.stream ()
                .sorted ((x,y) -> {
                    if(x.getAge ().equals (y.getAge ())){
                        return x.getEmpName ().compareTo (y.getEmpName ());
                    }

                    return -x.getAge ().compareTo (y.getAge ());
                }).forEach (System.out::println);
    }

}
