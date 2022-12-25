<%@page import="com.entity.TodoDtls"%>
<%@page import="com.DAO.TodoDAO"%>
<%@page import="com.DB.DbConnect"%>
<%@page import="java.sql.Connection"%>
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

	<div class="container">
		<div class="row p-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">ADD TASK</h3>

						<!-- Faile msg -->

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						TodoDAO dao = new TodoDAO(DbConnect.getConnection());
						TodoDtls t = dao.getTodoById(id);
						%>

						<%
							String fail = (String) session.getAttribute("fail");
						if (fail != null) {
						%>
						<div class="alert alert-danger text-center" role="alert"><%=fail%></div>
						<%
							session.removeAttribute("fail");
						}
						%>


						<form action="add_task" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Task</label> <input type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="task"
									value="<%=t.getTask()%>">
							</div>

							<div class="form-group ">
								<label for="inputState">Status</label> <select id="inputState"
									class="form-control" name="status">
									<%
										if ("Pending".equals(t.getStatus())) {
									%>
									<option value="Pending">Pending</option>
									<option value="Completed">Completed</option>
									<%
										} else {
									%>
									<option value="Completed">Completed</option>
									<option value="Pending">Pending</option>
									
									<%
										}
									%>


								</select>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary btn-center">ADD</button>
							</div>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>