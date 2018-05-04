package com.qlzy.email.util;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.qlzy.util.LoadpropertiesUtil;

public class EmailUtils {
	
	private static String FROM = "";
	private static String pwd = "";
	
	
	/**
	 * 发送重设密码链接的邮件
	 */
	public static void sendResetPasswordEmail(String email,String userName,String userId,String userType) {
		LoadpropertiesUtil pr = new LoadpropertiesUtil();
		Properties propertie = pr.loadproperties("shopSet.properties");
		 FROM = propertie.getProperty("fromAddress");
		Session session = getSession();
		MimeMessage message = new MimeMessage(session);
		try {
			message.setSubject("找回您的帐户与密码");
			message.setSentDate(new Date());
			message.setFrom(new InternetAddress(FROM));
			message.setRecipient(RecipientType.TO, new InternetAddress(email));
			message.setContent("要使用新的密码, 请使用以下链接启用密码:<br/><a href='" + GenerateLinkUtils.generateResetPwdLink(userName,userId,userType) +"'>点击重新设置密码</a>","text/html;charset=utf-8");
			// 发送邮件
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Session getSession() {
		LoadpropertiesUtil pr = new LoadpropertiesUtil();
		Properties propertie = pr.loadproperties("shopSet.properties");
		 FROM = propertie.getProperty("fromAddress");
		 pwd = propertie.getProperty("fromPwd");
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", "smtp.ym.163.com");
		props.setProperty("mail.smtp.port", "25");
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM, pwd);
			}
			
		});
		return session;
	}
}
