<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
table.hovertable {
    font-family: verdana,arial,sans-serif;
    font-size:11px;
    color:#333333;
    border-width: 1px;
    border-color: #999999;
    border-collapse: collapse;
}
table.hovertable th {
    background-color:#c3dde0;
    border-width: 1px;
    padding: 8px;
    border-style: solid;
    border-color: #a9c6c9;
}
table.hovertable tr {
    background-color:#d4e3e5;
}
table.hovertable td {
    border-width: 1px;
    padding: 8px;
    border-style: solid;
    border-color: #a9c6c9;
}
</style>
<body>
	<table border="1" width="50%" class="hovertable">
		<tr>
			<th>姓名</th>
			<th>id</th>
			<th>平均分</th>
			<th>出生日期</th>
			<th>备注</th>
			<th></th>
		</tr>
		<c:forEach items="${pageResult.currentlist}" var="employee">
		<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
			<td>${employee.name }</td>
			<td>${employee.id }</td>
			<td>${employee.avgscore }</td>
			<td>${employee.birthday }</td>
			<td>${employee.description}</td>
			<td><a href="./remove?cmd=remove&&id=${employee.id }">删除</a> <a href="./edit?cmd=edit&&id=${employee.id }">修改</a></td>
		</tr>
		</c:forEach>
		<tr><td><a href="./change?cmd=paging&currentPage=1">首页 </a></td>	
		    <td><a href="./change?cmd=paging&currentPage=${pageResult.prePage }">上一页</a></td> 	
		    <td><a href="./change?cmd=paging&currentPage=${pageResult.nextPage }">下一页</a></td>
		    <td><a href="./change?cmd=paging&currentPage=${pageResult.totalPage }">末页</a></td>
		    <td><a href="./add.jsp">+</a></td>
		    <td>第${pageResult.currentPage }/${pageResult.totalPage }页		总条数:${pageResult.totalItems }</td>
		 </tr>
	</table>
	
</body>
</html>