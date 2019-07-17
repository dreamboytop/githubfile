<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工的编辑</title>
</head>
<style>
input,button{
    width: 240px;
    height: 35px;
    margin: 0px 8px;
    border-radius: 10px; /*圆角矩形*/
    text-indent: 10px; /*里面隐形的字体首行缩进*/
    margin: 10px auto;
}
body{
    margin: 0px;
    padding: 0px;
    height: 180px;
}
form {
 position: relative;
 z-index: 1;
 background: #FFFFFF;
 max-width: 360px;
 margin: 0 auto 100px;
 padding: 45px;
 text-align: center;
 box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}

</style>
<body>
	<form action="./add" method="post" >
		姓         名：  <input type="text" name="name" value="${student.name }"><br/>
		i d    &nbsp&nbsp&nbsp&nbsp : <input disabled="disabled" type="text" name="id" value="${student.id }"><br/>
		出生日期:   <input type="text" name="birthday" value="${student.birthday }"><br/>
		备        注 ：      <input type="text" name="description" value="${student.description }"><br/>
		平均分    :<input  disabled="disabled" type="text" name="avgscore" value="${student.avgscore }"><br/>
		<input type="hidden" name="id" value = "${student.id }">
		<input type="hidden" name="avgscore" value = "${student.avgscore }">
		<input type="submit" value="提交">
	</form>
</body>
</html>