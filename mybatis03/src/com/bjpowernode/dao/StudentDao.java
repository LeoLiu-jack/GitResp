package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;
import com.bjpowernode.vo.StudentAndClassroomVo;

import java.util.List;
import java.util.Map;

/**
 * @Auther:leo
 * @Date:2021/2/23-12:14
 * @Description:com.bjpowernode.dao
 * @Versioin；1.0
 */
public interface StudentDao {
    //一个方法对应一套标签---->StudentDao.xml上相互对应
    public Student getById(String id);
    public void save(Student s);


    List<Student> getAll();

    Student select1(String az006);

    List<Student> select2(int i);

    List<Student> select3(String name, int i);


    List<Student> select4(Student s);

    List<Student> select5(Map<String, Object> map);

    List<StudentAndClassroomVo> select21();
}
