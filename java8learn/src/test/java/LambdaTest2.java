import com.mloine.Interface.MyFun;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * @className: LambdaTest2  语法糖
 * @Description:TOO   Lambda 表达式的基础语法
 *                          -> 箭头操作符号引入
 *               左侧：Lambda 表达式的参数列表
 *               右侧：Lambda 表达式所需要执行的功能，即Lambda体
 *
 *       语法格式1：无参数 无返回值
 *                      () -> System.out.println("Hello Lambda!")
 *       语法格式2：有一个参数，并且无返回值
 *                      (x) -> System.out.println (x)
 *       语法格式3：只有一个参数，小括号可以不写,
 *                      x -> System.out.println (x)
 *        语法格式4：有两个以上的参数并且Lambda体中有多条语句 并且有返回值
 *                  (x,y) -> {
                    System.out.println ("函数式接口");
                    return Integer.compare (x,y);
                    };
        语法格式5：有两个以上的参数并且Lambda体中只有一条语句 并且有返回值 那么retuen 和 {} 都可以不写
                    (x,y) -> Integer.compare (x,y)

        语法格式6：Lambda 表达式的参数列表的数据类型可以不写，因为JVM的编译器可以通过上下文推断出数据类型
                    (Integer x,Integer y) -> Integer.compare (x,y)


        Lambda表达式需要函数式接口的支持
            若接口中只有一个函数的抽象方法 那么称之为函数式接口
             @FunctionalInterface  修饰的接口必须是函数式接口

 * @Author:mloine
 * @Date：2019/5/2916:44
 **/
public class LambdaTest2 {

    @Test
    public void test1(){
       final int num = 0;//jdk 1.7以前必须是final  1.8实际上也是不能变的

        Runnable runnable1 =  new Runnable () {
            @Override
            public void run() {
                System.out.println ("Hello Lambda"+num);
            }
        };
        runnable1.run ();
        System.out.println ("---------------------------------------------");

        Runnable runnable = ()->System.out.print ("Hello Lambda"+num);
        runnable.run ();

    }


    @Test
    public void test2(){

//        Consumer<String> con = (x) -> System.out.println (x);
        Consumer<String> con = x -> System.out.println (x);

        con.accept ("mloine");
    }

    @Test
    public void test3(){
        Comparator<Integer> con = (x,y) -> {
            System.out.println ("函数式接口");
            return Integer.compare (x,y);
        };

        con.compare (1,2);
    }

    @Test
    public void test4(){
        Comparator<Integer> con = (x,y) -> Integer.compare (x,y);
        Comparator<Integer> con1= (Integer x,Integer y) -> Integer.compare (x,y);

        con.compare (1,2);
    }

    @Test
    public void test5(){
        String[] strs = {"sas","sasa","trytt"};

        List<String> list = new ArrayList<> ();

        show(new HashMap<> ());
    }

    public void show(Map<String,Integer> map){

    }

    //需求：对一个数进行运算
    @Test
    public void test6(){

        Integer operation = operation (100, (e) -> e * e);
        System.out.println (operation);

        System.out.println (operation(200,(e) -> e+200));


    }

    public Integer operation(Integer num, MyFun my){
        return my.getValue (num);
    }
}
