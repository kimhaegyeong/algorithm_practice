<%@page import="member.LogonDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="style.css" type="text/css" rel="stylesheet">
<%@ include file="setting.jsp"%>
<script src="script.js"></script>

<h2> <%=page_confirm%> </h2>

<%
	String id = request.getParameter("id");
%>
<%
	LogonDBBean dao = LogonDBBean.getInstance();
	int result = dao.check(id);
	if (result == 0) {
		// 아이디가 없다
		%> 
		<table>
			<tr>
				<td align="center">
					<span><%=id %></span><%=msg_id_o %>
				</td>
			</tr>
			<tr>
				<input class="inputbutton" type="button" 
					value="<%=btn_ok%>" onclick="useid( '<%=id%>' )">
			</tr>
		</table>
		<%
	} else {
		// 아이디가 있다
		%> 		
		<body onload="confirmfocus()">
			<form name="confirmform" method="post" action="confirmId.jsp"
				onsubmit="return confirmcheck()">
				<table>
					<tr>
						<th colspan="2" style="background-color: #E4E4E4">
							<span><%=id %></span><%=msg_id_x %>
						</th>
					</tr>
					<tr>
						<th><%=str_id %></th>
						<td>
							<input class="input" type="text" name="id" maxlength="15">
						</td>
					</tr>
					<tr>
						<th colspan="2" style="background-color: #E4E4E4">
							<input class="inputbutton" type="submit" value="<%=btn_ok%>">
							<!-- self.close() : 나 자신을 닫아라 -->
							<input class="inputbutton" type="button" value="<%=btn_ok_cancel%>" 
								onclick="javascript:self.close()">							
						</th>
					</tr>
				</table>
			</form>
		</body>
		<%
	}
%>