 
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
      
    <title>欢迎来到额没想好</title>  
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
    <h1>此页可以上传文件哦！</h1>
    <h2>${msg }</h2>  
    <br>  
      
        
        <form action="${pageContext.request.contextPath}/servlet/UploadHandleServlet" enctype="multipart/form-data" method="post">
        上传用户：<input type="text" name="username"><br/>
        上传文件1：<input type="file" name="file1"><br/>
        上传文件2：<input type="file" name="file2"><br/>
        <input type="submit" value="提交">
    </form> 
    <font color="red" size="2"> ${message}</font>  
    <a href="${pageContext.request.contextPath}/servlet/ListFileServlet">上传文件列表</a><br>
      <!-- 遍历Map集合 -->
    <c:forEach var="me" items="${fileNameMap}">
        <c:url value="/servlet/DownLoadServlet" var="downurl">
            <c:param name="filename" value="${me.key}"></c:param>
        </c:url>
        ${me.value}<a href="${downurl}">下载</a>
        <br/>
    </c:forEach>
  </body>  
</html>  