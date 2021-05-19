package com.chau.demo.servlet;

import com.chau.demo.pojo.User;
import com.chau.demo.service.UserService;
import com.chau.demo.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "servlet.AdminLoginServlet", urlPatterns = "/adminLoginServlet")
public class AdminLoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // 1.获取请求中的用户名和密码信息
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        // 2.创建UserService类型对象实现数据校验功能
        UserService userService = new UserServiceImpl();
        // 这一步在校验以及实现登录
        User user = userService.userLoginService(new User(userName, password));
        if (null == user) {
            // user为null则登录失败 打印错误信息
            System.out.println("登录失败，用户名或密码错误！");
            // 设置错误属性
            request.setAttribute("error", "登录失败，用户名或密码错误！");
            // 实现服务器跳转 共享request和response信息
            // 登录失败不做页面跳转
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        } else {
            // 登录成功 打印成功信息
            System.out.println("登录成功，欢迎使用！");
            // 登录成功则通过服务器跳转的方式 实现内部Servlet之间的跳转
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/studentPageQueryServlet");
            requestDispatcher.forward(request, response);
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
