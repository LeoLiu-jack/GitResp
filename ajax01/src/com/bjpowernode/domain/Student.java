package com.bjpowernode.domain;

/**
 * @Auther:leo
 * @Date:2021/2/19-12:33
 * @Description:com.bjpowernode.domain
 * @Versioin；1.0
 */
public class Student {
    private String id;
    private String name;
    private Integer age;

    public Student() {
    }
    //构造方式与反射
    public Student(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
