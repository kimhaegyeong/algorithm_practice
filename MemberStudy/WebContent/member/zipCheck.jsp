<%@page import="java.util.Iterator"%>
<%@page import="member.ZipcodeBean"%>
<%@page import="java.util.HashSet"%>
<%@page import="member.LogonDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="style.css" type="text/css" rel="stylesheet">
<%@ include file="setting.jsp"%>
<script src="script.js"></script>


<h2> <%=page_zipcode%> </h2>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	String area = request.getParameter("area");
%>
	<form name="confirmform" method="get" action="zipCheck.jsp"
			onsubmit="">
		<table name="">
			<tr>
				<th> 지역명을 입력하세요
				</th>
			</tr>
			<tr>
				<td>
					<input class="input" type="text" name="area" maxlength="15">
					<input class="inputbutton" type="submit" value="<%=btn_ok %>"
							onclick="findZipcode()">
				</td>
			</tr>
		</table>
	</form>
<%
	if (area != null) {
	
		LogonDBBean dao = LogonDBBean.getInstance();
		HashSet<ZipcodeBean> result = dao.getZipcodes(area);
		
		if (result == null || result.isEmpty()) {
			%> 검색 결과가 없습니다 <%
		} else {
			// 검색 결과 있음
			%> 
				<table id="zip_table">
					<tr>
						<th><%=str_zipcode %></th>
						<th colspan="2"><%=str_address %></th>
					</tr>
					<%
					Iterator<ZipcodeBean> itr = result.iterator();
					int i = 0;
		            while(itr.hasNext()) {
		            	ZipcodeBean zb = itr.next();
		            	i++;
		            	%>
		            	<tr>
		            		<td style="width: 50px;"><%=zb.getZipcode() %> </td>
		            		<td style="width: 200px;"><%=zb.getArea1() %>	 <%=zb.getArea2() %> <%=zb.getArea3() %></td>
		            		<td style="width: 30px;">
		            			<input type="radio" name="chk_info" value="<%=i%>"> 
		            		</td>
		            	</tr>
		            	<%	            	
		            }
			        %>
			        <tr>
						<th colspan="3" style="background-color: #E4E4E4">
							<input class="inputbutton" type="submit" value="<%=btn_ok%>"
								onclick="usezipcode()">
							<input class="inputbutton" type="button" value="<%=btn_ok_cancel%>" 
								onclick="javascript:self.close()">							
						</th>
					</tr>
				</table>
			<%
		}		
	}		
%>