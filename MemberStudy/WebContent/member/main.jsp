<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="style.css" type="text/css" rel="stylesheet">
<%@ include file="setting.jsp"%>
<script src="script.js"></script>

<h2> <%=page_main%> </h2>

<%
	if( session.getAttribute( "memId" ) == null ) {
		// session 없는 경우 - 로그인 안 된 상태
		%>
		<body onload="mainfocus()">
			<form method="post" action="loginPro.jsp" name="mainform"
				onsubmit="return maincheck()">
				<table>
					<tr>
						<th colspan="2" style="background-color: #E4E4E4">
							<%=msg_main%>
						</th>
					</tr>
					<tr>
						<th> <%=str_id%> </th>
						<td>
							<input class="input" type="text" name="id" maxlength="15"> 
						</td>
					</tr>
					<tr>
						<th> <%=str_passwd%> </th>
						<td>
							<input class="input" type="password" name="passwd" maxlength="15">
						</td>
					</tr>
					<tr>
						<th colspan="2" style="background-color: #E4E4E4">
							<input class="inputbutton" type="submit" value="<%=btn_login%>">
							<input class="inputbutton" type="reset" value="<%=btn_cancel%>">
							<input class="inputbutton" type="button" value="<%=btn_input%>"
								onclick="window.location='inputForm.jsp'">
						</th>
					</tr>
				</table>
			</form>	
		</body>		
		<%		
	} else {
		// session 있는 경우 - 로그인 된 상태
		%>
		<table>
			<tr>
				<td align="center" style="width: 350px">
					<span><%=session.getAttribute( "memId" )%></span>
					<%=msg_login%>
				</td>
			</tr>
			<tr>
				<th style="background-color: #E4E4E4">
					<input class="inputbutton" type="button" value="<%=btn_modify%>"
						onclick="location='modifyForm.jsp'">
					<input class="inputbutton" type="button" value="<%=btn_delete%>"
						onclick="location='deleteForm.jsp'">
					<input class="inputbutton" type="button" value="<%=btn_logout%>"
						onclick="location='logout.jsp'">
				</th>
			</tr>		
		</table>		
		<%		
	}
%>