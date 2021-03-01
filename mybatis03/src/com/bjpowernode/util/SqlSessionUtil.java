package com.bjpowernode.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther:leo
 * @Date:2021/2/22-13:28
 * @Description:com.bjpowernode.util
 * @Versioin；1.0
 */
//用来处理sqlsession的工具类，类似与jdbc
public class SqlSessionUtil {
    private SqlSessionUtil() {
    }

    private static SqlSessionFactory sqlSessionFactory;
    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    private static ThreadLocal<SqlSession> t = new ThreadLocal<SqlSession>();


    //取得sqlsession对象
    public static SqlSession getSession(){
        SqlSession session = t.get();
        if (session==null){
            //sqlSessionFactory与SqlSessionFactory的区别
            session = sqlSessionFactory.openSession();
            t.set(session);
        }

        return session;
    }
    //关闭sqlsession对象
    public static void myClose(SqlSession session){
        if (session != null){
            session.close();
            //这句必须加，非常容易忘
            t.remove();

        }

    }
}
