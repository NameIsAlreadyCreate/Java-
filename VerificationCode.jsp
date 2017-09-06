<%@page import="com.imooc.db.DBHelper"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">
  //事件脚本,点击图片切换验证码图片
		function change(obj){
			obj.src="VerificationCodeServlet?img="+new Date().getTime();
		}
	</script>
  </head>
  <body>
    <!--src:图片来源  VerificationCodeServlet-->
    验证码:<input type="image" alt="verifyCode" src="VerificationCodeServlet" onclick="change(this)" />
  </body>
</html>
