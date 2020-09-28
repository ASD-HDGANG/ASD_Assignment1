/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMailUtil;

import java.io.File;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import uts.asd.model.User;

/**
 *
 * @author Patty
 */
public class EmailService {

    private static final String FROM_ADDRESS = "hdgangganggang@gmail.com";
    private static final String PASSWORD = "hugh990104";

    public boolean sendMail(User user) {
        boolean test = false;

        String toAddress = user.getEmail();

        try {
            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");

            //get session to authenticate the host email address and password
            Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(FROM_ADDRESS, PASSWORD);
                }
            });

            //set email message details
            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(FROM_ADDRESS));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));

            //set email subject
            msg.setSubject("Your smartcard account have been created!");

            //set message text
            msg.setText("Thank you");

            //send message
            Transport.send(msg);

            test = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return test;
    }
}

