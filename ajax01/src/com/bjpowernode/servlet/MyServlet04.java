package com.bjpowernode.servlet;

import com.bjpowernode.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther:leo
 * @Date:2021/2/19-11:33
 * @Description:com.bjpowernode.servlet
 * @Versioin；1.0
 */
public class MyServlet04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("进入到servlet04");
        //需求：为前端提供一个对象
        //实体类，跟数据库做交互，需要记住，一般是domain

        //一个json代表一个对象
        //{"id":"?","name":"?","age":"?"}key不能重复
        //{"s1":{"id":"?","name":"?","age":"?"},"s2":{"id":"?","name":"?","age":"?"}}

        Student s1 = new Student("A001","zs",18);
        Student s2 = new Student("A002","ls",19);
        String str = "{\"s1\":{\"id\":\""+s1.getId()+"\",\"name\":\""+s1.getName()+"\",\"age\":\""+s1.getAge()+"\"}," +
                "\"s2\":{\"id\":\""+s2.getId()+"\",\"name\":\""+s2.getName()+"\",\"age\":\""+s2.getAge()+"\"}}";
        PrintWriter out = response.getWriter();
        out.println(str);
        out.close();



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);

    }
}
