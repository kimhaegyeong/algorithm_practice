<%@page import="java.text.SimpleDateFormat"%>
<%@page import="member.LogonDataBean"%>
<%@page import="member.LogonDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="style.css" type="text/css" rel="stylesheet">
<%@ include file="setting.jsp"%>
<script src="script.js"></script>

<h2> <%=page_modify%> </h2>

<%
	String id = (String) session.getAttribute( "memId" );
	String passwd = request.getParameter( "passwd" );
%>
<%
	LogonDBBean dao = LogonDBBean.getInstance();
	int result = dao.check( id, passwd );
	
	if( result == 1 ) {
		// 비밀번호가 같다
		LogonDataBean dto = dao.getMember( id );
		%>
		<body onload="modifyfocus()">
			<form method="post" action="modifyPro.jsp"
				name="modifyform" onsubmit="return modifycheck()">
				<input type="hidden" name="auth_email" value="1">				
				<table>
					<tr>
						<th colspan="2" style="background-color: #E4E4E4">
							<%=msg_modify%>
						</th>
					</tr>	
					<tr>
						<th> <%=str_id%> </th>
						<td> &nbsp;&nbsp;<%=dto.getId()%> </td>
					</tr>
					<tr>
						<th rowspan="2">
							<%=str_passwd%>
						</th>
						<td>
							<input class="input" type="password" name="passwd"
								maxlength="15" value="<%=dto.getPasswd()%>">
						</td>
					</tr>
					<tr>
						<td>
							<input class="input" type="password" name="repasswd"
								maxlength="15" value="<%=dto.getPasswd()%>">
						</td>
					</tr>
					<tr>
						<th> <%=str_name%> </th>
						<td> &nbsp;&nbsp;<%=dto.getName()%> </td>
					</tr>
					<tr>
						<th> <%=str_jumin%> </th>
						<td> 
							&nbsp;&nbsp;<%=dto.getJumin1()%> - <%=dto.getJumin2()%>
						</td>
					</tr>
					<tr>
					<th rowspan="3"> * <%=str_address%> </th>
						<td>
							<%	
								String[] zipcode = dto.getZipcode().split("-");
							%>
							<input class="input" type="text" name="zipcode1" maxlength="3"
								style="width: 50px;" onkeyup="nextzipcode2" value="<%=zipcode[0]%>">
							- <input class="input" type="text" name="zipcode2" maxlength="3"
								style="width: 50px;" onkeyup="" value="<%=zipcode[1]%>">
							<input class="inputbutton" type="button" value="<%=btn_zipcode%>"
							style="width: 100px;" onclick="openZipcodePage()">					
						</td>				
					</tr>
					<tr>
						<td>
							<%
								String[] address = dto.getAddress().split(" ");
								String address1 = address[0] + " " + address[1] + " " + address[2];
								String address2 = dto.getAddress().substring(address1.length() + 1);
							%>
							<input class="input" type="text" name="address1" maxlength="50"
								style="width: 200px;" onkeyup="nextaddress1" value="<%=address1%>">							
						</td>
					</tr>
					<tr>
						<td>
							<input class="input" type="text" name="address2" maxlength="30"
								style="width: 200px;" onkeyup="" value="<%=address2%>">
						</td>
					</tr>
					<tr>
						<th> <%=str_tel%> </th>
						<%						
						if( dto.getTel() == null || dto.getTel().equals( "" ) ) {
							// 전화번호가 없는 경우
							%>
							<td>
								<input class="input" type="text" name="tel1"	
									maxlength="3" style="width: 40px" onkeyup="modnexttel1()">
								- <input class="input" type="text" name="tel2"	
									maxlength="4" style="width: 50px" onkeyup="modnexttel2()">	
								- <input class="input" type="text" name="tel3"	
									maxlength="4" style="width: 50px" onkeyup="modnexttel3()">
							</td>		
							<%							
						} else {
							// 전화번호가 있는 경우
							String tel[] = dto.getTel().split( "-" );
							%>
							<td>
								<input class="input" type="text" name="tel1" onkeyup="modnexttel1()"	
									maxlength="3" style="width: 40px" value="<%=tel[0]%>">
								- <input class="input" type="text" name="tel2" onkeyup="modnexttel2()"	
									maxlength="4" style="width: 50px" value="<%=tel[1]%>">	
								- <input class="input" type="text" name="tel3" onkeyup="modnexttel3()"	
									maxlength="4" style="width: 50px" value="<%=tel[2]%>">
							</td>		
							<%		
						}
						%>						
					</tr>
					<tr>
						<th> <%=str_email%> </th>
						<td>
							<%
							if( dto.getEmail() == null || dto.getEmail().equals( "" ) ) {
								// 이메일이 없는 경우
								%>
								<input class="input" type="text" name="email1"
									maxlength="15" style="width: 80px" onkeydown="modifyEmail()">
								@ <input class="input" type="text" name="email2"
									maxlength="14" style="width: 80px" onkeydown="modifyEmail()">  
								<%								
							} else {
								// 이메일이 있는 경우
								String email[] = dto.getEmail().split( "@" );
								%>
								<input class="input" type="text" name="email1"
									maxlength="15" style="width: 80px" value="<%=email[0]%>" onkeydown="modifyEmail()">
								@ <input class="input" type="text" name="email2"
									maxlength="14" style="width: 80px" value="<%=email[1]%>" onkeydown="modifyEmail()">  
								<%	
							}
							%>
							<input class="inputbutton" type="button" value="<%=btn_sendmail%>"
								style="width: 100px;" onclick="return authEmail()" name="btn_sendmail">
						</td>
					</tr>
					<tr>
						<th> <%=str_reg_date%> </th>
						<td>
							<%
							SimpleDateFormat sdf 
								= new SimpleDateFormat( "yyyy-MM-dd HH:mm" );
							%>
							&nbsp;&nbsp;<%=sdf.format( dto.getReg_date() )%>
						</td>
					</tr>
					<tr>
						<th colspan="2" style="background-color: #E4E4E4">
							<input class="inputbutton" type="submit" value="<%=btn_mod%>">
							<input class="inputbutton" type="reset" value="<%=btn_cancel%>">
							<input class="inputbutton" type="button" value="<%=btn_mod_cancel%>"
								onclick="location='main.jsp'">							
						</th>
					</tr>
				</table>
			</form>		
		</body>		
		<%		
	} else {
		// 비밀번호가 다르다
		%>
		<script type="text/javascript">
			<!--
			erroralert( loginpasswderror );
			//-->
		</script>
		<%
	}
%>