package com.bjpowernode.servlet;


import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @Auther:leo
 * @Date:2021/2/19-11:33
 * @Description:com.bjpowernode.servlet
 * @Versioin；1.0
 */
public class MyServlet05 extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到学生相关的模块。。。。");
        //取得url-pattern，使用的是最多的
        String path = request.getServletPath();
        if ("/student/save.do".equals(path)){
            //添加
            //if代码块里面填写的代码不适合过多，不适合阅读和正常使用，不具有可维护性，可复用性
            //解决方案：封装成一个方法
            save(request,response);
        }else if ("/student/update.do".equals(path)){
            //修改
            update(request,response);

        }else if ("/student/delete.do".equals(path)){
            //删除
            delete(request,response);

        }else if ("/student/select.do".equals(path)){
            //查询
            select(request,response);

        }else {
            //
        }

    }

    //查询方法
    private void select(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行查询操作");
    }

    //删除方法
    private void delete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行删除操作");
    }

    //修改方法
    private void update(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行修改操作");
    }

    //添加方法
    public void save(HttpServletRequest request, HttpServletResponse response) {
        //类似之前的doPost和doGet方法
        System.out.println("执行添加操作");
    }


}
