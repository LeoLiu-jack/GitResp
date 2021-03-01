package com.bjpowernode.servlet;

import javax.servlet.ServletException;
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
public class MyServlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("进入到servlet01");

        /*PrintWriter out = response.getWriter();
        out.print("123456");
        out.close();*/

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        response.getWriter().print("777888");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);

    }
}
