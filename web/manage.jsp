<%@ page import="java.util.List" %>
<%@ page import="com.chau.demo.pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: wilfred
  Date: 2021/5/19
  Time: 下午4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <title>信息管理页面</title>
</head>
<body>
<div style="padding: 100px;">
    <%-- 构造一个响应式表格 --%>
    <div class="table-responsive">
    <%-- 构造一个10行7列的表格 用于显示所有的学生信息 最开始没有信息表格置空即可 让表格填充整个页面 --%>
        <table class="table">
        <%-- 提供相关功能对应的按钮，其中添加和修改使用的是同一个模态框 其他则通过js进行处理 --%>
            <caption>
                <button class="btn btn-info" id="show">显示学生</button>
                <button class="btn btn-info" id="student_add" data-toggle="modal" data-target="#myModal">增加学生</button>
                <button class="btn btn-info" id="student_delete">删除学生</button>
                <button class="btn btn-info" id="student_update" data-toggle="modal" data-target="#myModal">修改学生</button>
                <button class="btn btn-info" id="student_find">查询学生</button>
                <input type="text" id="s_code" placeholder="按学号查询..." style="width: 130px; height: 33px">
            </caption>

            <%-- 绘制1行7列的表头 --%>
            <thead>
            <tr>
                <th>选择</th>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>出生日期</th>
                <th>邮箱</th>
                <th>备注</th>
            </tr>
            </thead>
            <tbody id="tbody"></tbody>

            <%-- 绘制10行7列的假数据内容填充到表格中占位 --%>
            <%-- 获取内置对象中放入的所有学生信息 在这里进行展示 --%>
            <%
                List<Student> studentList = (List<Student>) session.getAttribute("studentList");
                for (int i = 0; i < studentList.size(); i++) {
            %>
            <tr>
                <td><input type="checkbox" value="<%= studentList.get(i).getSid() %>"></td>
                <td><%= studentList.get(i).getSid()%></td>
                <td><%= studentList.get(i).getSname()%></td>
                <td><%= studentList.get(i).getGender()%></td>
                <td><%= studentList.get(i).getBirth()%></td>
                <td><%= studentList.get(i).getEmail()%></td>
                <td><%= studentList.get(i).getRemarks()%></td>
            </tr>
            <%
                }
            %>
        </table>

        <%-- 编写管理学生信息的模态框 --%>
        <div class="modal" id="myModal" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button class="close" data-dismiss="modal" aria-hidden="true">
                            <span>&times;</span>
                        </button>
                        <h4 class="modal-title" id="myModalLabelAdd">学生信息</h4>
                    </div>
                    <form action="studentAddServlet" method="post">
                        <input type="hidden" id="flag" name="flag"/>
                        <div class="modal-body" id="modal-body">
                            <label for="name">姓名：</label>
                            <input type="text" class="form-control" id="m_name" name="name" placeholder="请输入姓名">
                            <label for="name">性别：</label>
                            <input type="text" class="form-control" id="m_gender" name="gender" placeholder="请输入性别">
                            <label for="name">出生日期：</label>
                            <input type="text" class="form-control" id="m_birth" name="birth" placeholder="请输入出生日期">
                            <label for="name">邮箱：</label>
                            <input type="text" class="form-control" id="m_email" name="email" placeholder="请输入邮箱">
                            <label for="name">备注：   </label>
                            <input type="text" class="form-control" id="m_remarks" name="remarks" placeholder="请补充备注">
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary">保存</button>
                            <button type="reset" class="btn btn-default" data-dismiss="modal">取消</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="pagination_div">

        <ul class="pagination">
            <%
                // 声明一个局部变量i负责实现当前页面和上一页、下一页的控制
                int i = 1;
                // 声明一个变量来获取总页数
                int len = studentList.size() / 10 + 1;
            %>

            <li><a href="studentPageQueryServlet?page=<%=(i>1?--i:i)%>">上一页</a></li>
            <%
                // 循环所有页码
                for (int j = 1; j <= len; j++) {
            %>
            <li><a href="studentPageQueryServlet?page=<%=j%>" id=<%=j%>> <%=j%> </a></li>
            <%
                }
            %>
            <li><a href="studentPageQueryServlet?page=<%=(i<len?++i:i)%>">下一页</a></li>
        </ul>
    </div>
</div>
</body>
</html>

<%-- js实现 --%>
<script type="text/javascript">
    // 显示学生
    $("#show").on("click", function () {
        // 获取模块路径信息：/stu_system/manage.jsp
        var modulePathName = window.document.location.pathname;
        // 获取模块名称： /stu_system
        var moduleName = modulePathName.substring(0, modulePathName.substr(1).indexOf('/') + 1);
        // 拼接结果为：id=1&id=2
        window.location.href = moduleName + "/studentPageQueryServlet";
    });

    // 增加学生
    $("#student_add").on("click", function (flag) {
        $("#flag").val("add");
        // alert($("#flag").val());
    });

    // 修改学生
    $("#student_update").on("click", function (flag) {
        var checkboxs = $("input[type='checkbox']:checked");
        // 处理用户没有勾选时候的情况
        if (checkboxs.length == 0) {
            alert("请选择一个学生！");
            return false;
        } else if (checkboxs.length > 1) {
            alert("只能选择一个学生！");
            return false;
        } else {
            $("#flag").val(checkboxs[0].value);
        }
    });

    // 删除用户
    $("#student_delete").on("click", function () {
        // 获取勾选的复选框
        var checkboxs = $("input[type='checkbox']:checked");
        // 根据勾选的复选框 将后面对应的值拼接起来
        var idsStr = "";
        for (var i = 0; i < checkboxs.length; i++) {
            idsStr += "id=" + checkboxs[i].value;
            if (i != checkboxs.length - 1) {
                idsStr += "&";
            }
        }
        // 处理没有勾选的情况
        if (checkboxs.lenght == 0) {
            alert("请至少选择一个用户！")
        } else {
            // 获取模块路径信息
            var modulePathName = window.document.location.pathname;
            // 获取模块名称
            var moduleName = modulePathName.substring(0, modulePathName.substr(1).indexOf('/') + 1);
            // 拼接结果为id=1&id=2
            window.location.href = moduleName + "/studentDeleteServlet?" + idsStr;
        }
    });

    // 查询学生
    $("#student_find").on("click", function () {
        var codeLike = $(this).siblings("#s_code").val();
        if (0 == codeLike.length) {
            alert("必须输入学号！")
            return false;
        } else if (/^\d{0,4}$/g.test(codeLike)) {
            // 获取模块路径信息
            var modulePathName = window.document.location.pathname;
            // 获取模块名称
            var moduleName = modulePathName.substring(0, modulePathName.substr(1).indexOf('/') + 1);
            // 拼接结果为id=1&id=2
            window.location.href = moduleName + "/studentDeleteServlet?" + codeLike;
        } else {
            alert("学号必须是数字！")
        }
    });
</script>