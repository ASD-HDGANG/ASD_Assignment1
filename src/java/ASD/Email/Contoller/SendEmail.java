/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASD.Email.Contoller;

import ASD.Email.Model.UserEmail;
import ASD.SmartCard.Model.User;
import ASD.Email.Model.User1;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Patty
 */
public class SendEmail extends HttpServlet {

    //generate vrification code
    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    //send email to the user email
    public boolean sendEmail(User1 user) {
        boolean test = false;

        String toEmail = user.getEmail();
        String fromEmail = "hdgangganggang@gmail.com";
        String password = "hugh990104";

        try {

            // your host email smtp server details
            Properties pr = new Properties();
            pr.setProperty("mail.smtp.host", "smtp.gmail.com");
            pr.setProperty("mail.smtp.port", "587");
            pr.setProperty("mail.smtp.auth", "true");
            pr.setProperty("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.socketFactory.port", "465");
            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            //set email message details
            Message msg = new MimeMessage(session);

            //set from email address
            msg.setFrom(new InternetAddress(fromEmail));
            //set to email address or destination email address
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            //set email subject
            msg.setSubject("[Test] Email Verification - ASD assignment");

            //set message text
            msg.setText("Hi " + user.getFirstName() + ", Your UTS-ASD smartcard account registered successfully.Please verify your account using this code: " + user.getCode());

            //send the message
            Transport.send(msg);

            test = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }

}
