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

    private Status status;


    public Employee() {
    }

    public Employee(Integer age) {
        this.age = age;
    }

    public Employee(Integer age, Integer slary) {
        this.age = age;
        this.slary = slary;
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
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (!getEmpName ().equals (employee.getEmpName ())) return false;
        if (!getAge ().equals (employee.getAge ())) return false;
        return getSlary ().equals (employee.getSlary ());
    }

    @Override
    public int hashCode() {
        int result = getEmpName ().hashCode ();
        result = 31 * result + getAge ().hashCode ();
        result = 31 * result + getSlary ().hashCode ();
        return result;
    }

    public Employee(String empName, Integer age, Integer slary, Status status) {
        this.empName = empName;
        this.age = age;
        this.slary = slary;
        this.status = status;
    }

    public enum Status{
        FREE,
        BUSY,
        VOCATION;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

