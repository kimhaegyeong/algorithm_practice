<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	session.removeAttribute( "memId" );
	response.sendRedirect( "main.jsp" );
%>