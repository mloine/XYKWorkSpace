import com.mloine.Entity.Employee;
import com.mloine.Interface.FilterEmployeeByAge;
import com.mloine.Interface.MyPredicate;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @className: LambdaTest
 * @Description:TOO
 * @Author:mloine
 * @Date：2019/5/2915:26
 **/
public class LambdaTest {

    @Test
    public void test(){

        Comparator<Integer> com = new Comparator<Integer> () {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare (o1, o2);
            }
        };

        TreeSet<Integer> ts  = new TreeSet<> (com);

    }


    @Test
    public void test2(){

        Comparator<Integer> com  = (x,y) -> Integer.compare ( x, y);
        TreeSet<Integer> ts  = new TreeSet<> (com);


    }

    //需求：获取当前公司中员工年龄大于35的员工信息
    List<Employee> employeeList = Arrays.asList (
            new Employee ("zhangsan",18,5999),
            new Employee ("lisi",38,6999),
            new Employee ("wangwu",50,3399),
            new Employee ("zhaoliu",16,3999),
            new Employee ("tianqi",8,7999)
     );

    public List<Employee>  filterEmployee(List<Employee> list){
        List<Employee> emps = new ArrayList<> ();

        for (Employee emp:list) {
            if(emp.getAge ()>= 35){
                emps.add (emp);
            }
        }
        return emps;
    }

    public List<Employee>  filterEmployee2(List<Employee> list){
        List<Employee> emps = new ArrayList<> ();

        for (Employee emp:list) {
            if(emp.getSlary ()>= 5000){
                emps.add (emp);
            }
        }
        return emps;
    }

    @Test
    public void test3(){
        List<Employee> employees = filterEmployee2 (employeeList);
        for (Employee emp:employees) {
            System.out.println (emp);
        }
    }

    public List<Employee> filterEmployeeinte(List<Employee> list, MyPredicate myPredicate) {
        List<Employee> emps = new ArrayList<> ();

        for (Employee emp:list) {
            if(myPredicate.test (emp)){
                emps.add (emp);
            }
        }
        return emps;
    }

    //优化：策划设计模式
    @Test
    public void test4(){
        List<Employee> employees = filterEmployeeinte (employeeList, new FilterEmployeeByAge ());
        for (Employee emp:employees) {
            System.out.println (emp);
        }
    }

    //匿名内部类
    @Test
    public void test5(){
        List<Employee> employees = filterEmployeeinte (employeeList, new MyPredicate<Employee> () {
            @Override
            public boolean test(Employee employee) {
                return employee.getSlary () < 6000;
            }
        });
        for (Employee emp:employees) {
            System.out.println (emp);
        }
    }
    //lAMBDA 表达式
    @Test
    public void test6(){
     MyPredicate<Employee> myPredicate = (employee) -> employee.getSlary () < 6000;
        List<Employee> list = filterEmployeeinte (employeeList, myPredicate);

//        List<Employee> list = filterEmployeeinte (employeeList, (e) -> e.getSlary () < 6000);
        list.forEach (System.out::print);
    }

    //lAMBDA 表达式  和Stream API结合优化
    @Test
    public void test7(){
        List<Employee> collect = employeeList.stream ()
                .filter ((e) -> e.getSlary () > 5000).collect (Collectors.toList ());
        System.out.println (collect);
        System.out.println ("-------------------------------------------------------");
        employeeList.stream ()
                .filter ((e)->e.getSlary ()>5000)
                .limit (2)
                .forEach (System.out::print);

        System.out.println ("----------------------------------");
        employeeList.stream ()
                .map (Employee::getEmpName)
                .forEach (System.out::println);

    }
}
