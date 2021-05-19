package com.chau.demo.dao;

import com.chau.demo.pojo.PageBean;
import com.chau.demo.pojo.Student;

import java.util.List;

/**
 * 实现Student类的数据访问接口
 * 实现对学生信息的增删改查方法的描述
 */
public interface StudentDao {

    /**
     * 自定义抽象方法藐视学生信息的显示
     * @param pageBean
     * @return
     */
    List<Student> showAllStudent(PageBean pageBean);

    /**
     * 自定义抽象方法描述添加学生的功能
     * @param student
     * @return
     */
    int addStudent(Student student);

    /**
     * 自定义抽象方法 实现按学号对学生信息进行删除
     * @param ids
     * @return
     */
    int deleteStudent(String[] ids);

    /**
     * 自定义抽象方法 实现修改学生信息的功能
     * @param student
     * @return
     */
    int updateStudent(Student student);

    /**
     * 自定义抽象方法实现按学号对学生信息进行查询
     * @param id
     * @return
     */
    Student findStudent(int id);
}
