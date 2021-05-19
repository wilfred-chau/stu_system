package com.chau.demo.servlet;

import com.chau.demo.pojo.PageBean;
import com.chau.demo.pojo.Student;
import com.chau.demo.service.StudentService;
import com.chau.demo.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentPageQueryServlet", urlPatterns = "/studentPageQueryServlet")
public class StudentPageQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取前端页面传来的页码值 并构造分页查询的对象
        String page = request.getParameter("page");
        // 创建默认值为1，即第一个默认查询为第一页的数据内容 一页查询的记录数预设为10
        PageBean pageBean = new PageBean(1, 10);
        if (null != page && page.length() > 0) {
            pageBean.setPage(Integer.parseInt(page));
        }
        // 通过Service层及Dao层获取到所有的学员信息
        StudentService studentService = new StudentServiceImpl();
        List<Student> studentList = studentService.showAllStudentService(pageBean);
        // 将获取到的学生信息放到内置对象中，通过客户端跳转的方式显示 重定向到另一个页面中
        HttpSession session = request.getSession();
        session.setAttribute("studentList", studentList);
        response.sendRedirect("manage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
