<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.renjun.ems.utils.TimeUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ems/css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							<%=TimeUtils.getCurrentTime()%>
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">EmpList Page</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Name
							</td>
							<td>
								Salary
							</td>
							<td>
								Age
							</td>
							<td>
								Operation
							</td>
						</tr>

						<%
							int i = 0;
						%>

						<c:forEach items="${requestScope.emps}" var="emp" varStatus="empIndex">
							<% i++;  %>
							<tr class="<%= i%2 == 0 ? "row2":"row1" %>">
								<td>
									${emp.id}
								</td>
								<td>
									${emp.name}
								</td>
								<td>
									${emp.salary}
								</td>
								<td>
									${emp.age}
								</td>
								<td>
									<a href="${pageContext.request.contextPath}/emp/deleteEmp/${emp.id}">Delete</a>&nbsp;<a href="${pageContext.request.contextPath}/emp/findEmpById/${emp.id}">Update</a>
								</td>
							</tr>
						</c:forEach>


					</table>
					<p>
						<input type="button" class="button" value="Add Employee" onclick="location='${pageContext.request.contextPath}/ems/addEmp.jsp'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
