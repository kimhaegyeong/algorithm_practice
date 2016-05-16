<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="style.css" type="text/css" rel="stylesheet">
<%@ include file="setting.jsp"%>
<script src="script.js"></script>

<h2> <%=page_input%> </h2>

<body onload="inputfocus()">
	<form method="post" action="inputPro.jsp"
		name="inputform" onsubmit="return inputcheck()">
		<input type="hidden" name="confirm" value="0">
		<input type="hidden" name="auth_email" value="0">
		<table>
			<tr>
				<th colspan="2" style="background-color: #E4E4E4">
					<%=msg_input%>
				</th>
			</tr>
			<tr>
				<th> * <%=str_id%> </th>
				<td>
					<input class="input" type="text" name="id" maxlength="15" style="width: calc(100% - 80px);">
					<input class="inputbutton" type="button" value="<%=btn_confirm%>"
						onclick="confirmid()">										
				</td>
			</tr>
			<tr>
				<th rowspan="2"> * <%=str_passwd%> </th>
				<td>
					<input class="input" type="password" name="passwd" maxlength="15">
				</td>
			</tr>
			<tr>				
				<td>
					<input class="input" type="password" name="repasswd" maxlength="15">
				</td>
			</tr>
			<tr>
				<th> * <%=str_name%> </th>
				<td>
					<input class="input" type="text" name="name" maxlength="20">
				</td>
			</tr>
			<tr>
				<th> * <%=str_jumin%> </th>
				<td>
					<input class="input" type="text" name="jumin1" maxlength="6"
						style="width: 50px;" onkeyup="nextjumin1()">
					- <input class="input" type="text" name="jumin2" maxlength="7"
						style="width: 60px;" onkeyup="nextjumin2()">
				</td>
			</tr>
			<tr>
				<th rowspan="3"> * <%=str_address%> </th>
				<td>
					<input class="input" type="text" name="zipcode1" maxlength="3"
						style="width: 50px;" onkeyup="nextzipcode2" readonly>
					- <input class="input" type="text" name="zipcode2" maxlength="3"
						style="width: 50px;" onkeyup="" readonly >
					<input class="inputbutton" type="button" value="<%=btn_zipcode%>"
						style="width: 100px;" onclick="openZipcodePage()" name="btn_zip">			
				</td>				
			</tr>
			<tr>
				<td>
					<input class="input" type="text" name="address1" maxlength="50"
						 onkeyup="nextaddress1" readonly>
				</td>				
			</tr>
			<tr>
				<td>
					<input class="input" type="text" name="address2" maxlength="30"
						onkeyup="">
				</td>
			</tr>
			<tr>
				<th> <%=str_tel%> </th>
				<td>
					<input class="input" type="text" name="tel1"	
						maxlength="3" style="width: 40px" onkeyup="nexttel1()">
					- <input class="input" type="text" name="tel2"	
						maxlength="4" style="width: 50px" onkeyup="nexttel2()">	
					- <input class="input" type="text" name="tel3"	
						maxlength="4" style="width: 50px" onkeyup="nexttel3()">	
				</td>				
			</tr>
			<tr>
				<th> <%=str_email%> </th>
				<td>
					<input class="input" type="text" name="email1"
						maxlength="20" style="width: 120px">
					@
					<select name="email2" class="input">
						<option value=""> </option>
						<option value="0"> 직접입력 </option>
						<option value="naver.com"> 네이버 </option>
						<option value="daum.net"> 다음 </option>
						<option value="gmail.com"> 구글 </option>
						<option value="nate.com"> 네이트 </option>						
					</select>	
					<input class="inputbutton" type="button" value="<%=btn_sendmail%>"
						style="width: 100px;" onclick="return authEmail()" name="btn_sendmail">	
				</td>
			</tr>			
			<tr>
				<th colspan="2" style="background-color: #E4E4E4">
					<input class="inputbutton" type="submit" value="<%=btn_join%>">
					<input class="inputbutton" type="reset" value="<%=btn_cancel%>">
					<input class="inputbutton" type="button" value="<%=btn_join_cancel%>"
						onclick="location='main.jsp'">					
				</th>
			</tr>
		</table>
	</form>
</body>