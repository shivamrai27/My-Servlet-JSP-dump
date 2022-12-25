
<%@page import="com.entity.TodoDtls"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.DB.DbConnect"%>
<%@page import="com.DAO.TodoDAO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="components/boots_cdn.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>

	<h1 class="text-center text-success">TASK</h1>

	<!-- SUCCESS MSG -->

	<%
		String suc = (String) session.getAttribute("suc");
	if (suc != null) {
	%>
	<div class="alert alert-success text-center" role="alert"><%=suc%></div>
	<%
		session.removeAttribute("suc");
	}
	%>


	<div class="container">
		<table class="table table-striped" border=1px>
			<thead class="bg-success text-white">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Task</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				TodoDAO dao = new TodoDAO(DbConnect.getConnection());
				List<TodoDtls> todo = dao.getTodo();
				for (TodoDtls t : todo) {
				%>
				<tr>
					<th scope="row"><%=t.getId()%></th>
					<td><%=t.getTask()%></td>
					<td><%=t.getStatus()%></td>
					<td>
					<a href="edit.jsp?id=<%=t.getId()%>>" class="btn btn-sm btn-success">Edit</a> 
					<a href="" class="btn btn-sm btn-danger">Delete</a>
					</td>
				</tr>
				<%
					}
				%>



			</tbody>
		</table>
	</div>
</body>
</html>