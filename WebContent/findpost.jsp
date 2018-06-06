 
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title>findpost</title>  
      <script type='text/javascript' src='/FileUploadDownLoad/jquery-2.1.1.js'></script>  
          
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
    
      
    <br>  
     
        <form action="findpostServlet" method="post">
		<br>帖子<input type="text" name="title"> <br>
		<input type="submit" value="查找" />
	</form>
   ${msg }
   <br>
	<input type="submit" name="Submit" value="返回" onclick="window.history.back()" >
	 
        
  </body>  
</html>  