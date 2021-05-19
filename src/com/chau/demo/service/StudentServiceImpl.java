package com.chau.demo.service;

import com.chau.demo.dao.StudentDao;
import com.chau.demo.factory.DaoFactory;
import com.chau.demo.pojo.PageBean;
import com.chau.demo.pojo.Student;

import java.util.List;

/**
 * @author wilfred
 * StudentService实现类
 */
public class StudentServiceImpl implements StudentService {

    /**
     * 自定义成员变量用于记录学生数据访问对象
     */
    private StudentDao studentDao;

    /**
     * 定义构造方法实现学生访问对象的初始化
     */
    public StudentServiceImpl() {
        studentDao = DaoFactory.getStudentDao();
    }

    @Override
    public List<Student> showAllStudentService(PageBean pageBean) {
        return studentDao.showAllStudent(pageBean);
    }

    @Override
    public int addStudentService(Student student) {
        return studentDao.addStudent(student);
    }

    @Override
    public int deleteStudentService(String[] ids) {
        return studentDao.deleteStudent(ids);
    }

    @Override
    public int updateStudentService(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public Student findStudentService(int id) {
        return studentDao.findStudent(id);
    }
}
