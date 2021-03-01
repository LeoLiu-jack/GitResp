package com.bjpowernode.test;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.util.SqlSessionUtil;
import com.bjpowernode.vo.StudentAndClassroomVo;
import sun.security.util.AuthResources_it;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther:leo
 * @Date:2021/2/25-18:09
 * @Description:com.bjpowernode.test
 * @Versioin；1.0
 */
public class Test02 {
    public static void main(String[] args) {


        StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);
       /* //1.测试parameterType，使用简单数据类型String
        Student s = studentDao.select1("A006");
        System.out.println(s);*/

        //2.测试parameterType，使用简单数据类型int
        //查询所有年龄为23的成员详细信息
        /*List<Student> studentList = studentDao.select2(23);
        for (Student s:studentList){
            System.out.println(s);
                    }
*/

        //3.测试parameterType，查询name为wyf，age为23岁的学员信息
        //绝对不可以为sql语句传递多个参数
        /*List<Student> sList = studentDao.select3("wyf",23);
        for (Student s:sList){
            System.out.println(s);
        }*/

        //如果我们要为sql语句传递多个参数，我们应该将这多个参数封装到一个domain对象中，
        // 或者打包到一个map集合中

        //测试parameterType，使用domain为参数 Student s
        //查询name为wyf，age为23岁的学员信息
       /* Student s = new Student();
        s.setName("wyf");
        s.setAge(23);
        List<Student> studentList = studentDao.select4(s);
        for (Student ss:studentList){
            System.out.println(ss);
        }
*/
        //5.测试：parameterType，使用map为参数
        //需求：查询出姓名为wyf，年龄为23岁的学员信息
        /*Map<String,Object> map = new HashMap<String,Object>();
        map.put("name", "wyf");
        map.put("age", 23);
        List<Student> sList = studentDao.select5(map);
        for(Student s1:sList){
            System.out.println(s1);
        }*/

        /*测试：多级联查，查询出学生和班级所有信息，加VO

            在实际的项目开发中，如果需要为前端展现的数据，使用一个domain类型不足以表现出来这些数据，
            这时我们可以考虑使用两种技术来实现
            分别为：
                使用map以及使用vo

                例如这样的需求
                    查询出学生和班级所有信息
                    得到的结果，使用学生的domain或者班级的domain都不能够封装这些结果

                    所以我们可以使用map去保存这些信息
                    同时我们也可以使用vo类来保存这些信息

                    vo指的是创建出来一个类，这个类中的属性是完全由我们自己去定义，属性会保存所有需要展现的信息
                    例如我们现在的这个例子，我们可以使用vo来封装所有与学生和班级相关的信息


        * */

        List<StudentAndClassroomVo> sList = studentDao.select21();
        for (StudentAndClassroomVo ss:sList){
            System.out.println(ss);
        }


    }
}
