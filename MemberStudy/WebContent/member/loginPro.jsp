<%@page import="member.LogonDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp"%>
<script src="script.js"></script>

<h2> <%=page_login%> </h2>
<%
	String id = request.getParameter( "id" );
	String passwd = request.getParameter( "passwd" );	
%>
<%
	LogonDBBean dao = LogonDBBean.getInstance();
	int result = dao.check( id, passwd );
	
	if( result == 0 ) {
		// 아이디가 없는 경우
		%>
		<script type="text/javascript">
			<!--
			erroralert( loginiderror );
			//-->
		</script>
		<%
	} else if( result == -1 ) {
		// 아이디가 있는 경우 - 비밀번호가 다른 경우
		%>
		<script type="text/javascript">
			<!--
			erroralert( loginpasswderror );
			//-->
		</script>
		<%
	} else {
		// 아이디가 있는 경우 - 비밀번호가 같은 경우
		session.setAttribute( "memId", id );
		response.sendRedirect( "main.jsp" );		
	}
%>