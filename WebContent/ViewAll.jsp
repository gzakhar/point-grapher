<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>View All Points</title>
	</head>

	<body>
	
	
		<sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
			url = "jdbc:mysql://localhost:3306/hibernate_db"
			user = "root"  />
		<sql:query dataSource = "${snapshot}" var = "result">
         SELECT * FROM points;
		</sql:query>	
		
		<table border = "1" width = "100%">
			<tr>
				<th>id</th>
				<th>x</th>
				<th>y</th>
			</tr>
			<c:forEach var = "row" items= "${result.rows}">
				<tr>
					<td><c:out value = "${row.id}"/></td>
					<td><c:out value = "${row.x}"/></td>
					<td><c:out value = "${row.y}"/></td>
				</tr>
			</c:forEach>
		</table>

	</body>

</html>