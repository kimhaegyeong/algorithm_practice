// 출처 : http://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
/*
 * 에러 발생 
 * Exception in thread "main" java.lang.NoClassDefFoundError: com/sun/mail/util/MailLogger
 * at javax.mail.Session.initLogger(Session.java:227)
 * at javax.mail.Session.<init>(Session.java:212)
 * at javax.mail.Session.getDefaultInstance(Session.java:315)

 *  에러 해결 방법 : 
 *  JavaEE에 com.sun.mail.util.MailLogger가 있다.
 *  JavaSE에는 없어서 에러가 발생한다.
 *  'com.sun.mail:javax.mail:1.5.2' 라이브러리를 추가한다. 
 *  출처 : http://stackoverflow.com/questions/24807472/java-mail-issue-with-session-getinstance
 *  
 *  
 *  보안 수준이 높을 때는 이메일이 발생되지 않는다.
 *  https://www.google.com/settings/security/lesssecureapps?zx=xvonmtjnhxau
 */

package javamail.test02;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Test01 {

	public static void main(String[] args) {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						// 구글 아이디, 비번.
						return new PasswordAuthentication("Google ID",
								"password");
					}
				});

		try {

			Message message = new MimeMessage(session);
			// 보내는 사람
			message.setFrom(new InternetAddress("schema9@gmail.com"));
			// 받는 사람.
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("schema9@gmail.com"));
			// 제목
			message.setSubject("Testing Subject");
			// 내용
			message.setText("Dear Mail Crawler,"
					+ "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}