package com.bjpowernode.service;

import com.bjpowernode.domain.Student;

import java.util.List;

/**
 * @Auther:leo
 * @Date:2021/2/24-9:31
 * @Description:com.bjpowernode.service
 * @Versioin；1.0
 */
public interface StudentService {
    public Student getById(String id);
    public void save(Student s);

    List<Student> getAll();
}
