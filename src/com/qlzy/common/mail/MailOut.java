package com.qlzy.common.mail;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailOut {
	public MailOut(){
		
	}
	public static void mailok(String to, String title, String text)
	{
	   try{
		   mailOut(to,title,text);
	   }catch(Exception e){
		  e.printStackTrace();
		}
    }
	public static boolean mailOut(String to, String title, String text)throws Exception
	{
		ResourceBundle bundle = ResourceBundle.getBundle("message");
		return MailOut.mailOut(bundle.getString("host"),bundle.getString("user"),bundle.getString("pwd"),bundle.getString("from"),to,title,text);
	}
	public static  boolean mailOut(String host,String user,String pwd,String from,String to, String title, String text) throws Exception{
		 boolean flag = false;
		Properties props = new Properties();

		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		 

		Session session = Session.getDefaultInstance(props);
		session.setDebug(false);

		MimeMessage message = new MimeMessage(session);
		try{
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject(title);	
		
		//发送html格式
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(text,"text/html;charset=gb2312");
		MimeMultipart multipart =new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		message.setContent(multipart);
		
		message.setSentDate(new Date());
		message.saveChanges();
		Transport transport = session.getTransport("smtp");
		transport.connect(host, user, pwd);
		transport.sendMessage(message, message.getAllRecipients());
	 
		transport.close();	
		flag = true;
		
		}catch(Exception e){
			flag = false;
			throw e;
		}
		return flag;
	}
	public static void main(String args[]) throws Exception {
		SendEmailUtil.sendEmailCode("ceshi", "798413023@qq.com", "123456");
		System.out.println("ok!");
		
	}
}
