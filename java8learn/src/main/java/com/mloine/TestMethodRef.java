package com.mloine;

import com.mloine.Entity.Employee;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.Random;
import java.util.function.*;

/**
 * @className: TestMethodRef
 * @Description:TOO  方法引用
 *              1.对象::实例方法名字
 *              2.类::静态方法名
 *              3.类::实例方法名
 *
 *              构造器引用
 *              1.ClassName::new
 * @Authoroine
 * @Date：2019/5/3015:56
 **/
public class TestMethodRef {


    //对象::实例方法名字
    @Test
    public void test1(){
        PrintStream ps1 = System.out;

        Consumer<String> con = (x) -> ps1.println (x);

        //方法引用
        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;

        Consumer<String> con2 = System.out::println;
        con2.accept ("abcd");
    }

    @Test
    public void test2(){
        Employee employee = new Employee ();
        employee.setEmpName ("mloine");
        Supplier<String> sup1 = ()-> employee.getEmpName ();

        Supplier<String> sup2 = employee::getEmpName;

        System.out.println (sup2.get ());
    }

    //类::静态方法名
    @Test
    public void test3(){
        Comparator<Integer> com1 = (x,y)-> Integer.compare (x,y);

        Comparator<Integer> com2  =Integer::compare;
    }

    //类::实例方法名
    public void test4(){

        BiPredicate<String,String> bp = (x,y) -> x.equals (y);

        //第一个参数 是方法的使用这 第二个参数是方法的入参
        BiPredicate<String,String> bp1 = String::equals;

    }

    //1.ClassName::new
    @Test
    public void test5(){

        Supplier<Employee> sp1 =() -> new Employee ();
        //sp1.get ();

        Supplier<Employee> sp2 = Employee::new;
    }
    @Test
    public void test6(){

        Function<Integer,Employee> fun1 = (x) -> new Employee (x);

        Function<Integer,Employee> fun = Employee::new;
        System.out.println (fun.apply (21));


        BiFunction<Integer,Integer,Employee> bf3 = Employee::new;
    }

}
