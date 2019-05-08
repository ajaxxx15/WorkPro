package com.stackroute.ProjectDetails.service;

import com.stackroute.ProjectDetails.domain.EmailMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Service
public class GeneratemailApplication {
    public GeneratemailApplication() {
    }

    @Value("${gmail.username}")
    private String username;
    @Value("${gmail.password}")
    private String password;

    public void sendmail(EmailMessage emailmessage) throws AddressException, MessagingException, IOException {

        System.out.println(emailmessage);
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(username, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailmessage.getTo()));
        msg.setSubject("Congratulations! you are invited!!" );
        System.out.println(msg.getSubject());
        msg.setContent(emailmessage.getBody(), "text/html");
//         msg.setContent("<h3>Hello Freelancer!! </h3><br><h2>Greetings for the day!</h2><br> you have been invited for bidding on a project.Please refer the link below for further details<br> http://workpro.stackroute.io/#/projectDetailsComponent/b3125687-784d-459c-80e8-b4ea725849c3/ajaykapil15@gmail.com","text/html" );
        System.out.println(msg.getContent());
        msg.setSentDate(new Date());
        Transport.send(msg);

    }
}
