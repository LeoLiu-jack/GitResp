package com.bjpowernode.service.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.dao.impl.StudentDaoImpl;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;

/**
 * @Auther:leo
 * @Date:2021/2/24-9:32
 * @Description:com.bjpowernode.service.impl
 * @Versioin；1.0
 */
//业务层
public class StudentServiceImpl implements StudentService {
    //接口=new 实现类 -----> 多态
    private StudentDao studentDao = new StudentDaoImpl();
    @Override
    public Student getById(String id) {
        //基础业务，简单调用增删改查即可
        Student s = studentDao.getById((id));
        return s;
    }

    @Override
    public void save(Student s) {
        studentDao.save(s);

    }
}
