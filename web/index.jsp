<%--
  Created by IntelliJ IDEA.
  User: ChauTsuen
  Date: 2021/1/11
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link href="css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-3.3.1.min.js"></script>
    <title>系统登录</title>
  </head>
  <style>
    .form-signin
    {
      max-width: 330px;
      padding: 15px;
      margin: 0 auto;
    }
    .form-signin .form-signin-heading, .form-signin .checkbox
    {
      margin-bottom: 10px;
    }
    .form-signin .checkbox
    {
      font-weight: normal;
    }
    .form-signin .form-control
    {
      position: relative;
      font-size: 16px;
      height: auto;
      padding: 10px;
      -webkit-box-sizing: border-box;
      -moz-box-sizing: border-box;
      box-sizing: border-box;
    }
    .form-signin .form-control:focus
    {
      z-index: 2;
    }
    .form-signin input[type="text"]
    {
      margin-bottom: -1px;
      border-bottom-left-radius: 0;
      border-bottom-right-radius: 0;
    }
    .form-signin input[type="password"]
    {
      margin-bottom: 10px;
      border-top-left-radius: 0;
      border-top-right-radius: 0;
    }
    .account-wall
    {
      margin-top: 20px;
      padding: 40px 0px 20px 0px;
      background-color: #f7f7f7;
      -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
      -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
      box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    }
    .login-title
    {
      color: #555;
      font-size: 26px;
      font-weight: 400;
      display: block;
    }
    .profile-img
    {
      width: 96px;
      height: 96px;
      margin: 0 auto 10px;
      display: block;
      -moz-border-radius: 50%;
      -webkit-border-radius: 50%;
      border-radius: 50%;
    }
    .need-help
    {
      margin-top: 10px;
    }
    .new-account
    {
      display: block;
      margin-top: 10px;
    }
  </style>
  <body>
  <div class="container">
    <div class="row">
      <div class="col-sm-6 col-md-4 col-md-offset-4">
        <h1 class="text-center login-title">学生系统登录</h1>
        <div class="account-wall">
          <img class="profile-img" src="images/user.png" alt="头像">
          <form class="form-signin" action="adminLoginServlet" method="post">
            <input type="text" name="userName" class="form-control" placeholder="username.." required autofocus>
            <input type="password" name="password" class="form-control" placeholder="password.." required>
            <button type="submit" class="btn btn-primary btn-block">登&nbsp;&nbsp;录</button>
            <label class="checkbox pull-left">
              <input type="checkbox" value="remember-me">
              Remember me
            </label>
            <a href="#" class="pull-right need-help">Need help?</a><span class="clearfix"></span>
          </form>
        </div>
        <a href="#" class="text-center new-account">点此注册</a>
      </div>
    </div>
  </div>
  </body>
</html>
