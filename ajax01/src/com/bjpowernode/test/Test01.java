package com.bjpowernode.test;

import java.util.UUID;

/**
 * @Auther:leo
 * @Date:2021/2/21-10:13
 * @Description:com.bjpowernode.test
 * @Versioin；1.0
 */
public class Test01 {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        str = str.replaceAll("-","");
        System.out.println(str);
        System.out.println(str.length());
        /*以后使用UUID作为数据库表的主键
        UUID为我们生成36为的由数字、字母、以及横杠所组成的随机串，这个随机串是世界唯一的
        * */
    }
}
