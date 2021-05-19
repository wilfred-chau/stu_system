package com.chau.demo.servlet;

import com.chau.demo.pojo.Student;
import com.chau.demo.service.StudentService;
import com.chau.demo.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 该Servlet中实现新增和修改的两个实现 不止是新增
 */
@WebServlet(name = "StudentAddServlet", urlPatterns = "/studentAddServlet")
public class StudentAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 预先设置编码方式，避免中文乱码问题
        response.setContentType("text/html; charset=utf-8");
        // 1.获取前台页面发送的标志位和数据内容
        String flag = request.getParameter("flag");
        String sname = request.getParameter("sname");
        String gender = request.getParameter("gender");
        String birth = request.getParameter("birth");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String email = request.getParameter("email");
        String remarks = request.getParameter("remarks");
        // 设置标志位的目的在于区分是要进行新增操作还是修改操作 因为新增和修改在前端页面使用的是同一个模态框
        // 2.打包数据后通过Service层实现对应的功能
        StudentService studentService = new StudentServiceImpl();
        // 根据隐藏域的结果分别实现增加和修改的功能
        int res = 0;
        Student student = null;
        if ("add".equals(flag)) {
            student = new Student(sname, gender, date, email,remarks);
        } else {
            student = new Student(Integer.parseInt(flag), sname, gender, date, email, remarks);
            res = studentService.updateStudentService(student);
            System.out.println("修改数据的结果为：" + res);
        }
        // 3.通过输出流向前台页面显示处理结果 然后重新请求一次数据
        PrintWriter writer = response.getWriter();
        // 获取模块的名称
        String contextPath = this.getServletContext().getContextPath();
        // 拼接请求路径
        String hrefPath = contextPath + "/studentPageQueryServlet";
        if (0 != res) {
            writer.print("<script>alert('管理学生信息成功！'); location.href='" + hrefPath + "';</script>");
        } else {
            writer.print("<script>alert('管理学生信息失败！'); location.href='" + hrefPath + "';</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
