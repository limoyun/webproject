<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title>修改密码界面</title>  
      
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!-- 
    <link rel="stylesheet" type="text/css" href="styles.css"> 
    -->  
  
  </head>  
    
  <body>  
  <center>  
    <div>  
    <h1>修改密码</h1>  
    <form action="MofifyServlet" method="post">  
    请输入帐号：<input type="text" name="username"><br/>  
    请输入原密码：<input type="password" name="oldpassword"><br/>  
    请输入密码：<input type="password" name="password"><br/>  
    请确认密码：<input type="password" name="rpsw"><br/>  
    <input type="submit" value="修改">  
    </form>  
    <input type="submit" name="Submit" value="返回" onclick="window.location.href('index.jsp')" >
    <br>
   <font color="red" size="2"> ${msg }</font>  
    </div>  
    </center>  
  </body>  
</html>  