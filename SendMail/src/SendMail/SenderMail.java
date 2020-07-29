package SendMail;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class SenderMail {
    private String username;// GMail user name (just the part before "@gmail.com")
    private String password;// GMail password
    private String[] recipient;


    public SenderMail(String username, String password, String[] recipient) {
        setUsername(username);
        setPassword(password);
        setRecipient(recipient);
    }

    public void sendFromGMail(String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", username);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(username));
            InternetAddress[] toAddress = new InternetAddress[recipient.length];

            // To get the array of addresses
            for (int i = 0; i < recipient.length; i++) {
                toAddress[i] = new InternetAddress(recipient[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, username, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            System.out.println("Done!");

        } catch (MessagingException ae) {
            ae.printStackTrace();
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRecipient(String[] recipient) {
        this.recipient = recipient;
    }
}
