package com.mloine.Interface;

import com.mloine.Entity.Employee;

/**
 * @className: FilterEmployeeByAge
 * @Description:TOO
 * @Author:mloine
 * @Date：2019/5/2915:59
 **/
public class FilterEmployeeByAge implements MyPredicate<Employee>{

    @Override
    public boolean test(Employee employee) {
        return employee.getAge () > 35;
    }
}
