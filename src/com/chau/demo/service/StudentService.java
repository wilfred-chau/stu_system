package com.chau.demo.service;

import com.chau.demo.pojo.PageBean;
import com.chau.demo.pojo.Student;

import java.util.List;

/**
 * 实现学生类业务层接口
 */
public interface StudentService {

    /**
     * 自定义抽象方法描述显示所有学生的业务功能
     * @param pageBean
     * @return
     */
    List<Student> showAllStudentService(PageBean pageBean);

    /**
     * 自定义抽象方法描述增加学生的业务功能
     * @param student
     * @return
     */
    int addStudentService(Student student);

    /**
     * 自定义抽象方法描述按学号删除学生信息的业务功能
     * @param ids
     * @return
     */
    int deleteStudentService(String[] ids);

    /**
     * 自定义抽象方法描述修改学生信息的业务功能
     * @param student
     * @return
     */
    int updateStudentService(Student student);

    /**
     * 自定义抽象方法描述按学号查找学生信息的业务功能
     * @param id
     * @return
     */
    Student findStudentService(int id);
}
