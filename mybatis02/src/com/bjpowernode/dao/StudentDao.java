package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

/**
 * @Auther:leo
 * @Date:2021/2/23-12:14
 * @Description:com.bjpowernode.dao
 * @Versioin；1.0
 */
public interface StudentDao {
    public Student getById(String id);
    public void save(Student s);


}
