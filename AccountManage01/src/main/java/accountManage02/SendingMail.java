package accountManage02;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class SendingMail implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
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
						return new PasswordAuthentication("ID",
								"PWD");
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
