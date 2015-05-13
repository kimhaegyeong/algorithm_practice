// 출처 : http://www.tutorialspoint.com/java/java_sending_email.html

package javamail.test01;
// File Name SendEmail.java

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail
{
   public static void main(String [] args)
   {    
      // Recipient's email ID needs to be mentioned.
	   // 보내는 사람의 이메일
      String to = "abcd@gmail.com";

      // Sender's email ID needs to be mentioned
      // 받는 사람의 이메일
      String from = "web@gmail.com";

      // Assuming you are sending email from localhost
      // localhost로 부터 이메일을 보낸다고 가정
      String host = "localhost";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      // 메일 서버를 설정한다. 
      properties.setProperty("mail.smtp.host", host);

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);

      try{
         // Create a default MimeMessage object.
    	  // 기본 메세지 객체생성
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));

         // Set Subject: header field
         // 제목
         message.setSubject("This is the Subject Line!");

         // Now set the actual message
         // 메세지 내용 
         message.setText("This is actual message");

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}