package com.tallentview.tallentview.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ForgotEmail 
{
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	Properties properties = new Properties();
	 Session session;
	
	public ForgotEmail() {
		// TODO Auto-generated constructor stub
		
		properties.setProperty("mail.smtp.host", "smtp.zoho.com");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.debug", "true");
        properties.put("mail.store.protocol", "pop3");
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.debug.auth", "true");
        properties.setProperty( "mail.pop3.socketFactory.fallback", "false");
        session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() 
        {   
        	@Override
            protected PasswordAuthentication getPasswordAuthentication() 
            { 
        		return new PasswordAuthentication("noreply@tallentview.com","95794090");
            }
        });
	}
 
	public static void main(String args[]) throws AddressException, MessagingException
	{
	//	generateAndSendEmail();
		ForgotEmail forgotEmail = new ForgotEmail();
		forgotEmail.sendForgotEmail1("mangeshd142@gmail.com","asdasd");
		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
		
	}
 //This class takes various attributes from webservice implementation class and send it in an email
	public static void sendForgotEmail1(String email,String temPwd) throws AddressException, MessagingException {
 
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("support@tallentview.com"));
		//generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("odd.sourabh@gmail.com"));
		generateMailMessage.setSubject("Forgot Password");
		String emailBody = "Reset your password click here http://localhost:8080/tallentview/resetPassword?email="+email+"&password="+temPwd;
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "noreply.tallentview@gmail.com", "95794090");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
	
	
	public void sendForgotEmail(String email,String temPwd) throws AddressException, MessagingException {
		 
        try 
        {   MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("noreply@tallentview.com"));
            message.setRecipients(MimeMessage.RecipientType.TO,InternetAddress.parse(email));
            message.setSubject("Forgot Password");
            //message.setText("Reset your password click here http://localhost:8080/tallentview/resetPassword?email="+email+"&password="+temPwd);
            message.setText("Reset your password click here http://www.tallentview.com/resetPassword?email="+email+"&password="+temPwd);
            Transport.send(message);
        } 
        catch (MessagingException e) 
        {   e.printStackTrace();
        }
	
	}
	
	
	
}
