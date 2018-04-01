/*    */ package swing.sys.common.util;
/*    */ 
/*    */ import java.io.PrintWriter;
/*    */ import java.io.StringWriter;
/*    */ import java.util.Date;
/*    */ import java.util.Properties;
/*    */ import javax.mail.Authenticator;
/*    */ import javax.mail.Message;
/*    */ import javax.mail.PasswordAuthentication;
/*    */ import javax.mail.Session;
/*    */ import javax.mail.Transport;
/*    */ import javax.mail.internet.InternetAddress;
/*    */ import javax.mail.internet.MimeMessage;
/*    */ 
/*    */ public class EmailSender extends Thread
/*    */ {
	private static String username;
	private static String password;
			String title;
/*    */   StringBuffer message;
/*    */   String receiver;
/*    */ 
/*    */   public static EmailSender getInstance(String Emal_to, String title, String message, Exception e)
/*    */   {
/* 34 */     return new EmailSender(message, e, Emal_to, title);
/*    */   }
/*    */   private EmailSender(String word, Exception e, String Emal_to, String title) {
			this.title = title;
/* 37 */     this.receiver = Emal_to;
/* 38 */     this.message = new StringBuffer(word + "\n");
/* 39 */     if (e == null)
/* 40 */       return;
/* 41 */     StringWriter sw = new StringWriter();
/* 42 */     e.printStackTrace(new PrintWriter(sw));
/* 43 */     this.message.append("message=").append(e.getMessage()).append("\n").append("cause=")
/* 44 */       .append(e.getCause()).append("\n").append(sw.toString());
/*    */   }
/*    */ 
/*    */   public void run() {
/* 49 */     String title = "系统异常提醒通知";
/* 50 */     Properties properties = new Properties();
/* 51 */     properties.put("mail.smtp.host", "smtp.163.com");
/* 52 */     properties.put("mail.smtp.auth", "true");
/* 53 */     Authenticator attorney = new Authenticator() {
/*    */ 
/*    */       protected PasswordAuthentication getPasswordAuthentication() {
/* 58 */         return new PasswordAuthentication(username, password);
/*    */       }
/*    */     };
/* 61 */     Session session = Session.getInstance(properties, attorney);
/*    */     try {
/* 63 */       Message mailMessage = new MimeMessage(session);
/* 64 */       mailMessage.setFrom(new InternetAddress(username));
/* 65 */       mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(this.receiver));
/* 66 */       mailMessage.setSubject(title);
/* 67 */       mailMessage.setSentDate(new Date());
/* 68 */       mailMessage.setText(this.message.toString());
/* 69 */       Transport.send(mailMessage);
/*    */     } catch (Exception e) {
/* 71 */       e.printStackTrace();
/* 72 */       System.out.println(0);
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\swingWang\mail.jar
 * Qualified Name:     xiaoFei.swing.mailUtil.MailSender
 * JD-Core Version:    0.6.2
 */