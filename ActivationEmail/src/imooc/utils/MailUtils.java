package imooc.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/07
 **/
public class MailUtils {

    public static void sendEmail(String to, String code) throws MessagingException {

        // 1. Create a connection to mail server
        Properties properties = new Properties();
        //properties.setProperty("host","localhost");
        Authenticator authenticator = new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("service@jmail.com","111");
            }
        };
        Session session = Session.getInstance(properties, authenticator);

        // 2. Create an email object
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("service@jmail.com"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
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
