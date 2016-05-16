<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="style.css" type="text/css" rel="stylesheet">
<%@ include file="setting.jsp"%>
<script src="script.js"></script>

<h2> <%=page_delete%> </h2>

<body onload="passwdfocus()">
	<form method="post" action="deletePro.jsp"
		name="passwdform" onsubmit="return passwdcheck()">
		<table>
			<tr>
				<th colspan="2" style="background-color: #E4E4E4">
					<%=msg_passwd%> 
				</th>
			</tr>	
			<tr>
				<th> <%=str_passwd%> </th>
				<td>
					<input class="input" type="password" name="passwd"
						maxlength="15">
				</td>
			</tr>
			<tr>
				<th colspan="2" style="background-color: #E4E4E4">
					<input class="inputbutton" type="submit" value="<%=btn_del%>">
					<input class="inputbutton" type="button" value="<%=btn_del_cancel%>"
						onclick="location='main.jsp'">
				</th>
			</tr>
		</table>
	</form>
</body>