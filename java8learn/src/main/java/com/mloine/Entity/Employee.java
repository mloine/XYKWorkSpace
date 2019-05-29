package com.mloine.Entity;

/**
 * @className: Employee
 * @Description:TOO
 * @Author:mloine
 * @Date：2019/5/2915:38
 **/
public class Employee {

    private String empName;

    private Integer age;

    private Integer slary;


    public Employee() {
    }

    public Employee(String empName, Integer age, Integer slary) {
        this.empName = empName;
        this.age = age;
        this.slary = slary;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSlary() {
        return slary;
    }

    public void setSlary(Integer slary) {
        this.slary = slary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", age=" + age +
                ", slary=" + slary +
                '}';
    }
}

