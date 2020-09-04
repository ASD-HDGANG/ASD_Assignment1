/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamail;


import ASD.Email.Model.User1;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Patty
 */
public class SendEmail {

    //generate vrification code
    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    //send email to the user email
    public boolean sendEmail(User1 user) {

        System.out.println("Preparing to send email");

        boolean test = false;

        String toEmail = user.getEmail();
        final String fromEmail = "hdgangganggang@gmail.com";
        final String password = "hugh990104";

        try {

            // your host email smtp server details
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            // get session to authenticate the host email address and password
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            // Should send different email msg according below methods;
            Message verifyEmail = verifyEmail(session, fromEmail, toEmail, user);

            // Edit user email, notify user account has been mod
            //send the message
            Transport.send(verifyEmail);
            System.out.println("Message sent successfully");

            test = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }

    private Message verifyEmail(Session session, String fromEmail, String toEmail, User1 user) {
        try {
            //set email message details
            Message msg = new MimeMessage(session);
            //set from email address
            msg.setFrom(new InternetAddress(fromEmail));
            //set to email address or destination email address
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            //set email subject
            msg.setSubject("[Test] Email Verification - ASD Smartcard Project");
            //set message text
            String html = "Hi " + user.getFirstName() + "," +
                    "<br/><br/>Welcome, your UTS-ASD smartcard account has successfully created. Please verify your account using this code below, <br/><br/> "
                    + "<b>" + user.getCode() + "</b>" + "<br/><br/> Regards <br/> ASD team ";
            msg.setContent(html, "text/html");

            return msg;

        } catch (Exception ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
