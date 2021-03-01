package com.bjpowernode.test;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.service.impl.StudentServiceImpl;
import com.bjpowernode.util.ServiceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Auther:leo
 * @Date:2021/2/21-13:45
 * @Description:com.bjpowernode.test
 * @Versioin；1.0
 */
public class Test01 {
    public static void main(String[] args) {
        //先创建业务层
        //StudentService ss = new StudentServiceImpl();  //zs形态
        //这样就可以了，ls形态的是可以的，zs形态不走事务
        StudentService ss = (StudentService) ServiceFactory.getService(new StudentServiceImpl());//ls形态
        /*测试添加操作
        Student s = new Student();
        s.setId("A006");
        s.setName("cxk");
        s.setAge(23);
        ss.save(s);*/

        /*//测试根据id查单条操作
        Student s = ss.getById("A005");
        System.out.println(s);*/

        //查询所有的记录
        List<Student> sList = ss.getAll();
        for (Student s:sList){
            System.out.println(s);
        }


    }
}