package com.bjpowernode.dao.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @Auther:leo
 * @Date:2021/2/23-12:16
 * @Description:com.bjpowernode.dao.impl
 * @Versioin；1.0
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public Student getById(String id) {
        SqlSession session = SqlSessionUtil.getSession();
        Student s = session.selectOne("test1.getById",id);
        return s;
    }

    @Override
    public void save(Student s) {
        SqlSession session = SqlSessionUtil.getSession();
        session.insert("test1.save",s);
        //现在在dao层，与数据库相关联
        //在dao层，每一次事务都是开始与提交的过程，非常繁琐
        session.commit();


    }
}
