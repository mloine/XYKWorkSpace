package com.mloine;

import com.mloine.Entity.Employee;
import com.mloine.Interface.MyFunction;
import com.mloine.Interface.MyFunction2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @className: Lambda
 * @Description:TOO
 * @Author:mloine
 * @Date：2019/5/2915:24
 **/
public class Lambda {

    List<Employee> employeeList = Arrays.asList (
            new Employee ("zhangsan",18,5999),
            new Employee ("lisi",38,6999),
            new Employee ("wangwu",50,3399),
            new Employee ("zhaoliu",16,3999),
            new Employee ("tianqi",8,7999)
    );

    @Test
        public void test1(){

        Collections.sort (employeeList,(x, y) -> {
            int compare = Integer.compare (x.getAge (), y.getAge ());
            return compare == 0 ? x.getEmpName ().compareTo (y.getEmpName ()) :compare;
        });

        employeeList.stream ().forEach (System.out::println);
//        System.out.println (employeeList);
    }

    //需求用语处理字符串额方法  指定字符串 做指定处理
    public String strHandler(String str,MyFunction mf){
            return mf.getVallue (str);
    }

    @Test
    public void strHandler() {
       // MyFunction mf = (x) -> x.toUpperCase ();
        System.out.println (strHandler("xYk  ",(x) -> x.toUpperCase ().trim ()));

        System.out.println (strHandler("xYk1  ",(x) -> x.toLowerCase ().trim ().substring (0,2)));


    }

    public void op(Long l1, Long l2, MyFunction2<Long,Long> mf){
        System.out.println (mf.getValue (l1,l2));
    }

    @Test
    public void test3(){
        op(100L,200L,(x,y) -> x + y );
        op(100L,200L,(x,y) -> x * y );

    }



}

