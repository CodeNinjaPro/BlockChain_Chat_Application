/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

/**
 *
 * @author Roshan Withanage turn off avast for use these mail system Don't
 * forget to Disable virus gard
 */
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaEmail {

    private Properties emailProperties;
    private Session mailSession;
    private MimeMessage emailMessage;

    private String[] toEmails = {""};
    private String emailSubject = "";
    private String emailBody = "";

    private JavaEmail() {
    }

    private static final JavaEmail je = new JavaEmail();

    public static JavaEmail getInstance() {
        return je;
    }

    public void executeEmail(String[] toEmails, String emailSubject, String emailBody) throws MessagingException {
        this.toEmails = toEmails;
        this.emailSubject = emailSubject;
        this.emailBody = emailBody;

        this.setMailServerProperties();
        this.createEmailMessage();
        this.sendEmail();

    }

    public void setMailServerProperties() {

        String emailPort = "587";//gmail's smtp port

        emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", emailPort);
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");

    }

    public void createEmailMessage() throws AddressException,
            MessagingException {

        mailSession = Session.getDefaultInstance(emailProperties, null);
        emailMessage = new MimeMessage(mailSession);

        for (int i = 0; i < toEmails.length; i++) {
            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
        }

        emailMessage.setSubject(emailSubject);
        emailMessage.setContent(emailBody, "text/html");//for a html email
        //emailMessage.setText(emailBody);// for a text email

    }

    public void sendEmail() throws AddressException, MessagingException {

        String emailHost = "smtp.gmail.com";
        String fromUser = "lilyshanz12";//just the id alone without @gmail.com
        String fromUserEmailPassword = "Welcome@1";

        Transport transport = mailSession.getTransport("smtp");

        transport.connect(emailHost, fromUser, fromUserEmailPassword);
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();
        System.out.println("Email sent successfully.");
    }

}
