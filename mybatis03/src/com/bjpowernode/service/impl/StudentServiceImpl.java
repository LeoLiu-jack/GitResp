package com.bjpowernode.service.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.util.SqlSessionUtil;

import java.util.List;

/**
 * @Auther:leo
 * @Date:2021/2/24-9:32
 * @Description:com.bjpowernode.service.impl
 * @Versioin；1.0
 */
//业务层
public class StudentServiceImpl implements StudentService {
    //接口=new 实现类 -----> 多态
    //下面这行帮我们创建了实现类
    //StudentDao应该等于一个代理类的
    private StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);
    //根据id查数据的方法
    @Override
    public Student getById(String id) {
        //基础业务，简单调用增删改查即可
        Student s = studentDao.getById((id));
        return s;
    }

    //往数据库里存数据的方法
    @Override
    public void save(Student s) {
        studentDao.save(s);

    }

    //查询所有信息的方法
    @Override
    public List<Student> getAll() {
        List<Student> sList = studentDao.getAll();
        return sList;
    }
}
