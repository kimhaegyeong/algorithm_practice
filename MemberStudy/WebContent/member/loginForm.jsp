<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="style.css" type="text/css" rel="stylesheet">
<%@ include file="setting.jsp"%>
<script src="script.js"></script>

<h2> <%=page_login%> </h2>

<body onload="loginfocus()">
	<form method="post" action="loginPro.jsp"
		name="loginform" onsubmit="return logincheck()">
		<table>
			<tr>
				<th colspan="2">
					<%=msg_login_ok%>
				</th>
			</tr>
			<tr>
				<th> <%=str_id%> </th>
				<td>
					<input class="input" type="text" name="id"
						maxlength="15">
				</td>
			</tr>
			<tr>
				<th> <%=str_passwd%> </th>
				<td>
					<input class="input" type="password" name="passwd"
						maxlength="15">
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input class="inputbutton" type="submit" value="<%=btn_login%>">
					<input class="inputbutton" type="reset" value="<%=btn_cancel%>">
					<input class="inputbutton" type="button" value="<%=btn_login_cancel%>"
						onclick="location='main.jsp'">
				</th>
			</tr>		
		</table>	
	</form>
</body>