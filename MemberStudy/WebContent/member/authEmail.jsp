<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.Multipart"%>
<%@page import="javax.mail.internet.MimeBodyPart"%>
<%@page import="javax.mail.internet.MimeMultipart"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Session"%>
<%@page import="javax.mail.PasswordAuthentication"%>
<%@page import="javax.mail.Authenticator"%>
<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link href="style.css" type="text/css" rel="stylesheet">
<%@ include file="setting.jsp"%>
<script src="script.js"></script>

<h2> <%=page_confirm%> </h2>

<%
	String receiver = request.getParameter("email");
%>
<%
	if (session.getAttribute("isSendMail") == null) {
		session.setAttribute("isSendMail", true);
		%>
		<div> 
			<p><%=msg_sending_email %></p>
		</div>
		<meta http-equiv="refresh" content="0; url=authEmail.jsp?email=<%=receiver%>">
		<%
	} else {
		String authNum = null;

		Properties props = new Properties(); 
		props.setProperty("mail.transport.protocol", "smtp"); 
		props.setProperty("mail.host", "smtp.gmail.com"); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.port", "465"); 
		props.put("mail.smtp.socketFactory.port", "465"); 
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
		props.put("mail.smtp.socketFactory.fallback", "false"); 
		props.setProperty("mail.smtp.quitwait", "false"); 
		 
		Authenticator auth = new Authenticator(){
		    protected PasswordAuthentication getPasswordAuthentication() { 
		        return new PasswordAuthentication("구글 이메일 주소", "비밀번호"); 
		    }
		};
		
		Session mailSession = Session.getInstance(props, auth);
		
	    MimeMessage message = new MimeMessage(mailSession); 
	    message.setSender(new InternetAddress("이메일 주소")); 
	    message.setSubject(str_email_title); 

	    message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver)); 
	    
	    String msgText = str_email_content;
		Double num = Math.floor(Math.random() * 1000000) + 100000;
		if(num > 1000000){
			num = num - 100000;
		}
		
		authNum = String.format("%.0f", num);
		msgText += authNum;
	    
	    Multipart mp = new MimeMultipart();
	    MimeBodyPart mbp1 = new MimeBodyPart();
	    mbp1.setText(msgText);
	    mp.addBodyPart(mbp1);
	     
	    message.setContent(mp);
	     
	    Transport.send(message);
	    
	    session.removeAttribute("isSendMail");
	    %>
		<table>
			<tr> 
				<td>
					<p>
					<%=msg_sended_email %>			
					</p>
				</td>
			</tr>
			<tr>
				<td>
					<input type="hidden" id="auth_email" value="0">	
					<input type="text" class="input" name="input_num" style="width: calc(100% - 100px);">
					<input type="button" class="inputButton" onclick="checkAuthNum(<%=authNum %>)" value="확인">
				</td>
			</tr>
			<tr>
				<th style="background-color: #E4E4E4">
					<input class="inputButton" type="submit" value="<%=btn_ok%>"
						onclick="return useAuthEmail()">
					<input class="inputButton" type="button" value="<%=btn_ok_cancel%>" 
						onclick="javascript:self.close()">	
				</th>
			</tr>
		</table>
		<%
	}
%>