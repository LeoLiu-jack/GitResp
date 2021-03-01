package com.bjpowernode.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther:leo
 * @Date:2021/2/23-11:31
 * @Description:com.bjpowernode.util
 * @Versioin；1.0
 */
public class TransactionInvocationHandler implements InvocationHandler {
    //动态代理的标志之一就是：target
    private Object target;
    //标准写法
    public TransactionInvocationHandler(Object target) {
        this.target = target;
    }

    //代理类的业务方法
    //ls的表白方法
    //invoke:代理类的业务方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //之前声明的是Connection，现在是SqlSession
        SqlSession session = null;
        Object object = null;

        try{
            //创建对象去做行不行，可以，但是不建议
            //这些方法都是使用类直接调用的
            session = SqlSessionUtil.getSession();

            //处理业务逻辑
            //method.invoke,zs的表白
            object = method.invoke(target,args);
            //处理业务逻辑后，提交事务
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            SqlSessionUtil.myClose(session);
        }
        return object;
    }
    public Object getProxy(){
        //取得李四对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);

    }
}
