package com.mloine.stream;

import com.mloine.Entity.Employee;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @className: TestStreamApi3
 * @Description:TOO 终止操作
 * @Author:mloine
 * @Date：2019/6/313:23
 **/
public class TestStreamApi3 {

    List<Employee> employeeList = Arrays.asList (
            new Employee ("zhangsan",18,5999, Employee.Status.FREE),
//            new Employee ("zhangsan",18,5999, Employee.Status.FREE),
//            new Employee ("zhangsan",18,5999, Employee.Status.FREE),
//            new Employee ("zhangsan",18,5999, Employee.Status.FREE),
//            new Employee ("zhangsan",18,5999, Employee.Status.FREE),
//            new Employee ("zhangsan",18,5999, Employee.Status.FREE),
            new Employee ("lisi",38,6999,Employee.Status.BUSY),
            new Employee ("wangwu",50,3399,Employee.Status.VOCATION),
            new Employee ("zhaoliu",16,6999,Employee.Status.FREE),
            new Employee ("tianqi",8,7999,Employee.Status.BUSY)

    );

    @Test
    public void test1(){

        //匹配所有元素
        boolean b = employeeList.stream ()
                .allMatch ((e) -> e.getStatus ().equals (Employee.Status.BUSY));

        System.out.println (b);

        //至少匹配一个元素
        boolean b2 = employeeList.stream ().anyMatch ((e) -> e.getStatus ().equals (Employee.Status.BUSY));

        System.out.println (b2);

        //是否所有元素不匹配
        boolean b3 = employeeList.stream ().noneMatch ((e) -> e.getStatus ().equals (Employee.Status.BUSY));
        System.out.println (b3);

        //获取第一个值
        Optional<Employee> first = employeeList.stream ()
                .sorted ((x, y) -> -Double.compare (x.getSlary (), y.getSlary ()))
                .findFirst ();
        //防止空指针
        Employee employee = first.orElse (null);

        System.out.println (employee);

        //获取任意一个
        Optional<Employee> any = employeeList.parallelStream ()//并行流
                .filter ((e) -> e.getStatus ().equals (Employee.Status.FREE))
                .findAny ();
        Employee employee1 = any.orElse (null);
        System.out.println ("空闲状态:"+employee1);
    }

    @Test
    public void test2(){
        //计数
        long count = employeeList.stream ().count ();
        System.out.println ("sum:"+count);
        //最大
        Optional<Employee> max = employeeList.stream ().max ((x, y) -> Double.compare (x.getSlary (), y.getSlary ()));
        System.out.println ("max:"+max.orElse (null));
        //最小
        Optional<Integer> min = employeeList.stream ()
                .map (Employee::getSlary)
                .min (Integer::compare);

        System.out.println ("min:"+min.get ());
    }

    //归约
    @Test
    public void test3(){
        
    }
}
