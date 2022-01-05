package com.example.demo;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class SendEmail {
    void sendEmail() throws MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("senderemail.com", "<Password>");
            }

        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("senderemail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("prashantsbasnet@gmail.com"));

        msg.setSubject("Sampleemail");
        msg.setContent("Sample email", "text/html");
        msg.setSentDate(new Date());


        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Tutorials point email", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        MimeBodyPart attachPart = new MimeBodyPart();
        attachPart.attachFile("/home/info/Downloads/sample3.txt");

        multipart.addBodyPart(attachPart);
        msg.setContent(multipart);
        Transport.send(msg);
    }
}
