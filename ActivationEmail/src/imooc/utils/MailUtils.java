package imooc.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.security.Security;
import com.sun.net.ssl.internal.ssl.Provider;

import java.util.Properties;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/07
 **/
public class MailUtils {

    public static void sendEmail(String to, String code) throws MessagingException {
        Security.addProvider(new Provider());
        // 1. Create a connection to mail server
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.debug", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "jerryzhang4013@gmail.com", "3229891zjc");
                    }
                });

        session.setDebug(true);

        // 2. Create an email object
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("jerryzhang4013@gmail.com"));
        String[] recipients = { to };
        InternetAddress[] addressTo = new InternetAddress[recipients.length];
        for (int i = 0; i < recipients.length; i++) {
            addressTo[i] = new InternetAddress(recipients[i]);
        }
        message.setRecipients(Message.RecipientType.TO, addressTo);
        message.setSubject("Activate your account by clicking the link.");
        message.setContent(
                "<h1>Activate your account by clicking the link blow: </h1>" +
                        "<h3><a href='http://localhost:8080/ActiveServlet?code="+code+"'>" +
                        "http://localhost:8080/ActiveServlet?code="+code+"</a></h3>",
                "text/html; charset=UTF-8");

        // 3. Send the activation email
        Transport.send(message);
    }
}
