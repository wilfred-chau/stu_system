package com.chau.demo.servlet;

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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentQueryServlet", urlPatterns = "/studentQueryServlet")
public class StudentQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决中文乱码问题
        response.setContentType("text/html; charset=utf-8");
        // 1.获取前端发送的学号
        String sid = request.getParameter("sid");
        // 2.通过service层实现查找操作
        StudentService studentService = new StudentServiceImpl();
        Student student = studentService.findStudentService(Integer.parseInt(sid));
        // 3.通过输出流想前台展示处理结果 再请求一次数据
        PrintWriter writer = response.getWriter();
        List<Student> studentList = new ArrayList<>();
        if (null != student) {
            // student的值不为null说明查找成功 查找成功时返回到主页面
            studentList.add(student);
            HttpSession session = request.getSession();
            // 将获取到的所有学生信息放到内置对象中，通过客户端跳转方式显示
            session.setAttribute("studentList", studentList);
            writer.write("<script>alert('查找学生成功！'); location.href='manage.jsp';</script>");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("studentList", studentList);
            writer.write("<script>alert('查找学生失败！'); location.href='manage.jsp';</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
