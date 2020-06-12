<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Point</title>
</head>

<body>

	<%-- <h1><%request.getParameter("name"); %>></h1> --%>

	<table border="1" width="100%">
		<tr>
			<th>id</th>
			<th>x</th>
			<th>y</th>
		</tr>
		<tr>
			<td>
				<%=request.getParameter("id")%>
			</td>
			<td>
				<%=request.getParameter("x")%>
			</td>
			<td>
				<%=request.getParameter("y")%>
			</td>
		</tr>
	</table>

</body>

</html>