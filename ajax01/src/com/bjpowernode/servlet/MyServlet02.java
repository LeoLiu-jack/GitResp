package com.bjpowernode.servlet;

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
public class MyServlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("进入到servlet02");
        //{"str1":"aaa","str2":"bbb","str3":"ccc"}
        String str = "{\"str1\":\"aaa\",\"str2\":\"bbb\",\"str3\":\"ccc\"}";

        PrintWriter out = response.getWriter();
        out.println(str);
        out.close();



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);

    }
}
