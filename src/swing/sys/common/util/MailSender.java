package swing.sys.common.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 电子邮件发送工具
 * @author wang_xf
 */
public class MailSender extends Thread {

	private String username;
	private String password;
	private String title;
	private String message;
	private String receiver;
	
	/**
	 * 发送邮件
	 * @param content 邮件内容
	 * @param emailTo 接收方邮箱地址
	 * @param title 邮件标题
	 */
	public void sendEmail(String content, String emailTo, String title){
		this.message = content;
		this.receiver = emailTo;
		this.title = title;
		this.run();
	}
	
	@Override
	public void run(){
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.163.com");
		properties.put("mail.smtp.auth", "true");
		Authenticator attorney = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		};
		Session session = Session.getInstance(properties, attorney);
		try {
			Message mailMessage = new MimeMessage(session);
			mailMessage.setFrom(new InternetAddress(username));
			mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(this.receiver));
			mailMessage.setSubject(title);
			mailMessage.setSentDate(new Date());
			mailMessage.setText(this.message.toString());
			Transport.send(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
