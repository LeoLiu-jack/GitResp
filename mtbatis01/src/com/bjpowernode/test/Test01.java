package com.bjpowernode.test;

import com.bjpowernode.domain.Student;
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
    public static void main(String[] args)  {
        String resource = "mybatis-config.xml";
        //输入流是读，输出流是写
        InputStream inputStream = null;
        try {
            //通过加载MyBatis的主配置文件（mybatis-config.xml），创建输入流对象
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        SqlSessionFactoryBuilder():SqlSessionFactory的建造者
        通过该建造者对象调用建造方法，为我们创建一个SqlSession对象

        SqlSessionFactory对象唯一的作用就是为我们创建SqlSession对象
        我们未来所有的操作，使用的都是SqlSession对象
        * */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        /**需求：
        *   根据id查单条
         *   如果取得的是单条记录,我们需要使用selectOne方法
         *   参数1：根据命名空间.sqlId的形式找到我们需要使用的sql语句
         *   参数2：我们要为sql语句中传递的参数
         *
         *   */
        /*Student student = session.selectOne("test1.getById","A001");
        System.out.println(student);
        session.close();*/

        //查询学生信息中所有的记录

        /*List<Student> sList = session.selectList("test1.getAll");
        for (Student s:sList){
            System.out.println(s);
        }*/

  /*      //添加操作
        *//*事务：mybatis默认的是手动提交事务
        * commit：
        * rollback：*//*
        Student s = new Student();
        s.setId("A006");
        s.setName("hxm");
        s.setAge(33);
        //需不需要为sql语句传参
        session.insert("test1.save",s);
        session.commit();//手动提交事务，如果没有这一步，数据库中的数据不会发生改变
        session.close();
*/
       /* //修改操作
        Student s = new Student();
        s.setId("A006");
        s.setName("cxk");
        s.setAge(24);
        session.update("test1.update",s);
        session.commit();
        session.close();*/
       //删除操作
        session.delete("test1.delete","A006");
        session.commit();
        session.close();
        //动态代理一般写在业务层
        /*控制器，处理用户请求、
        * 业务层，处理业务逻辑
        * dao层，处理与数据库的交互
        *但是现在的 业务层有参与了事务相关的代码，变得不单一，不方便管理了*/


    }
}
