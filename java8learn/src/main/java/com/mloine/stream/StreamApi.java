package com.mloine.stream;

import com.mloine.Entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @className: StreamApi
 * @Description:TOO
 *              1.创建stream
 *              2.中间操作
 *              3.终止操作（终端操作）
 * @Author:mloine
 * @Date：2019/5/3112:44
 **/
public class StreamApi {
    @Test
    public void test(){
        //1.可以通过Collection系列集合提供的stream() 或 paralleStream()
        List<String> list = new ArrayList<> ();

        Stream<String> stream1 = list.stream ();

        //2.通过Arrays 中的静态方法 stream() 获取数组刘
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream (emps);

        //3.通过Stream中的静态方法
        Stream<String> stream3 = Stream.of ("aa", "bb", "cc");

        //4.创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate (0, (x) -> x + 2);
//        stream4.forEach (System.out::println);
        stream4.limit (10).forEach (System.out::println);

        //生成
        Stream<Double> generate = Stream.generate (() -> Math.random ()*100);
        generate.limit (5).forEach (System.out::println);
    }
}
