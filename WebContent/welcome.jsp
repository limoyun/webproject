 
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
    
        <h2>欢迎 
      <%=session.getAttribute("user")%>
       登陆
      <input type="submit" name="Submit" value="修改密码" onclick="window.location.href('modify.jsp')" >
 </h2> 
    <br>  
     
        <form action="PostMessageServlet" method="post">
		<br>标题<input type="text" name="title"> <br>内容
	<textarea rows="20" cols=40 name="content"></textarea>
		<input type="submit" value="发表" />
	</form>
	   <input type="submit" name="Submit" value="搜索帖子" onclick="window.location.href('findpost.jsp')" >
        <form action="${pageContext.request.contextPath}/servlet/UploadHandleServlet" enctype="multipart/form-data" method="post">
   
        上传文件：<input type="file" name="file1"><br/>
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