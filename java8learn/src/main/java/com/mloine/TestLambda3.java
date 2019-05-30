package com.mloine;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @className: TestLambda3
 * @Description:TOO java8中内置的四大核心函数式接口
 *                      1.Consumer<T> :消费型接口
 *                          void accept(T t);
 *                      2.Supplier<T> : 供给型接口
 *                          T get();
 *                      3.Function<T,R> :函数型接口
 *                          R apply(T t);
 *                      4.Predicate<T> :断言型接口
 *                          Boolean test(T t);
 * @Author:mloine
 * @Date：2019/5/3012:44
 **/
public class TestLambda3 {

    //Consumer<T> 消费型接口
    @Test
    public void test1(){
        happy (100,(x) -> System.out.println ("大保健消费剩余"+ (x-50)));
    }

    public void happy(double money, Consumer<Double> con){
        con.accept (money);
    }

   //2.Supplier<T> : 供给型接口
   @Test
   public void test2(){
       List<Integer> numlist = getNumlist (10, () -> (int) (Math.random () * 100));

       System.out.println (numlist);
   }

   public List<Integer> getNumlist(int num,Supplier<Integer> sp){
        List<Integer> list = new ArrayList<> ();
        for (int i=0;i<num;i++){
            Integer e = sp.get ();
            list.add (e);
        }
        return list;
   }

    // 3.Function<T,R> :函数型接口
    //    R apply(T t);
      @Test
      public void test3(){
          System.out.println (strHandler("\t\t\t\t\t Xyk",(x)-> x.trim ().toUpperCase ()));
      }

      public String strHandler(String str, Function<String,String> fun){
          return fun.apply (str);
      }


      //4.Predicate<T> :断言型接口
      //Boolean test(T t);
        //需求将满足条件的字符串 放入集合中
      @Test
      public void test4(){
           List<String> strlist  = Arrays.asList ("xxz","xzxz","mloine","tom");
          List<String> stringList = filterStr (strlist, (x) -> x.length () > 3);
          stringList.stream ().forEach (System.out::println);
      }

      public List<String> filterStr(List<String> list, Predicate<String> p){
          List<String> stringList = new ArrayList<> ();
          for (String str:list) {
              if(p.test (str)){
                  stringList.add (str);
              }
          }
          return stringList;
      }
}
