package com.bjpowernode.util;

/**
 * @Auther:leo
 * @Date:2021/2/23-12:11
 * @Description:com.bjpowernode.util
 * @Versioin；1.0
 */
public class ServiceFactory {

    //传递张三对象得到李四对象的过程
    public static Object getService(Object service){
        return new TransactionInvocationHandler(service).getProxy();

    }
}
