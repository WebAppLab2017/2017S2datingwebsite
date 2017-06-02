/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author TuanAnh
 */
public class Email {

    static Properties mailServerProperties;
    static Session mailSession;
    static MimeMessage mailMessage;

    public static void registerAndSendEmail(String email, String username, String password, String fullname, String phone) throws AddressException, MessagingException {

        //Step1 : setup Mail Server Properties 
        String protocal = "smtp";
        String host = "smtp.gmail.com";
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.ssl.trust", host);
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        //Step2 : get Mail Session    
        InternetAddress mailTo = new InternetAddress(email);
        InternetAddress mailCC = new InternetAddress("tin.thai2705@gmail.com");
        InternetAddress mailBCC = new InternetAddress("tin.thai2705@gmail.com");
        mailSession = Session.getDefaultInstance(mailServerProperties, null);
        mailMessage = new MimeMessage(mailSession);
        mailMessage.addRecipient(Message.RecipientType.TO, mailTo);
        mailMessage.addRecipient(Message.RecipientType.CC, mailCC);
        mailMessage.addRecipient(Message.RecipientType.BCC, mailBCC);
        mailMessage.setSubject("Registration new account");
        String emailBody = "Dear <b>" + fullname + "</b>, <br><br>Thank you for signing up with us. Your new account has been setup and you can now login to our members area using the details below. <br><br>Email Address: <b>" + email 
                + "</b><br><br>Username: " + username 
                + "</b><br><br>Password: " + password 
                + "</b><br><br>Phone number: " + phone 
                + "<br><br>Best regards, <br>Administrator";
        mailMessage.setContent(emailBody, "text/html");

        //Step3 : Get Session and Send mail            
        Transport transport = mailSession.getTransport(protocal);
        String mailFrom = "tin.thai2705@gmail.com";
        String pass = "thaitrungtin";
        transport.connect(host, mailFrom, pass);
        transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
        transport.close();

        // Get Store 
        Store store = mailSession.getStore(protocal);
        store.connect(host, mailFrom, pass);
        if (store != null) {
            Folder folder = store.getFolder("INBOX");
        }
    }

    public static void generateAndSendEmail(String email, String username, String password) throws AddressException, MessagingException {

        //Step1 : setup Mail Server Properties 
        String protocal = "smtp";
        String host = "smtp.gmail.com";
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.ssl.trust", host);
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        //Step2 : get Mail Session    
        InternetAddress mailTo = new InternetAddress(email);
        InternetAddress mailCC = new InternetAddress("tin.thai2705@gmail.com");
        InternetAddress mailBCC = new InternetAddress("tin.thai2705@gmail.com");
        mailSession = Session.getDefaultInstance(mailServerProperties, null);
        mailMessage = new MimeMessage(mailSession);
        mailMessage.addRecipient(Message.RecipientType.TO, mailTo);
        mailMessage.addRecipient(Message.RecipientType.CC, mailCC);
        mailMessage.addRecipient(Message.RecipientType.BCC, mailBCC);
        mailMessage.setSubject("Recovery password");
        String emailBody = "Hello <b>" + username + "</b>, <br><br>We have received a request about forget password from you. <br><br>This is your old password: <b>" + password + "</b><br><br>Please login against with this password and change your new password.<br><br>Best regards, <br>Administrator";
        mailMessage.setContent(emailBody, "text/html");

        //Step3 : Get Session and Send mail            
        Transport transport = mailSession.getTransport(protocal);
        String mailFrom = "tin.thai2705@gmail.com";
        String pass = "thaitrungtin";
        transport.connect(host, mailFrom, pass);
        transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
        transport.close();

        // Get Store 
        Store store = mailSession.getStore(protocal);
        store.connect(host, mailFrom, pass);
        if (store != null) {
            Folder folder = store.getFolder("INBOX");
        }
    }
}
