package com.mloine.Interface;

import com.mloine.Entity.Employee;

/**
 * @className: MyPredicate
 * @Description:TOO
 * @Author:mloine
 * @Date：2019/5/2915:57
 **/
@FunctionalInterface
public interface MyPredicate<T> {

    public boolean test(T t);

}
