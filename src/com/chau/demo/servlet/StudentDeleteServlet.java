package com.chau.demo.servlet;

import com.chau.demo.service.StudentService;
import com.chau.demo.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudentDeleteServlet", urlPatterns = "/studentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决中文乱码问题
        response.setContentType("text/html; charset=utf-8");
        // 1.获取前台页面发送过来的学号
        String[] sids = request.getParameterValues("sid");
        // 2.通过service层实现删除操作
        StudentService studentService = new StudentServiceImpl();
        int res = studentService.deleteStudentService(sids);
        // 3.通过输出流给前台页面展示处理结果 然后重新请求一次数据
        PrintWriter writer = response.getWriter();
        // 获取模块名称
        String contextPath = this.getServletContext().getContextPath();
        // 拼接请求路径
        String hrefPath = contextPath + "/studentPageQueryServlet";
        if (0 != res) {
            writer.print("<script>alert('删除成功！'); location.href='" + hrefPath + "';</script>");
        } else {
            writer.print("<script>alert('删除失败！'); location.href='" + hrefPath + "';</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
