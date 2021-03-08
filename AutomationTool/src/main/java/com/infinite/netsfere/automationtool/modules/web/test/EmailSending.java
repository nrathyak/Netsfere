package com.infinite.netsfere.automationtool.modules.web.test;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.infinite.netsfere.automationtool.suits.EndToENdSanity;

public class EmailSending {
	
	 private static Logger log = LogManager.getLogger(EmailSending.class.getName());

	public void ReportSending() {
		final String username = "sanjay.kumar@netsfere.com";
	    final String password = "Netsfere1234";
	    
	    Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

	    Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });

	    try {

	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(username));
	        message.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse("himadri.chidananda@netsfere.com"));
	        message.setSubject("AUTOMATION REPORT");
	        message.setText("Attached is the Netsfere Automation report ------ > PFA");

	        MimeBodyPart messageBodyPart = new MimeBodyPart();

	        Multipart multipart = new MimeMultipart();

	        messageBodyPart = new MimeBodyPart();
	        String project_Dir = System.getProperty("user.dir");
	        String file = project_Dir + "/test-output/NetsfereAutomationReport.html";
	        String fileName = "ExtentReportsTestNG.html";
	        DataSource source = new FileDataSource(file);
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        messageBodyPart.setFileName(fileName);
	        multipart.addBodyPart(messageBodyPart);

	        message.setContent(multipart);
	        
            log.info("Sending");
	        

	        Transport.send(message);
            log.info("Done");
	        

	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	  }
}
