package util.pon.al;

import hibernate.pon.al.entity.UserE;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {

    private final String WARMSTAR_EMAIL = "mainwarmstar@gmail.com";
    private final String WARMSTAR_PASSWORD = "warmStar1992";
    private Properties properties;
    private Session session;
    private Message message;
    private UserE userE;
    private String subject;
    private String textMessage;
    private String nameNoName;
    private String emailNoName;

    public Email(UserE user, String sub, String m){
        properties = new Properties();
        userE = user;
        subject = sub;
        textMessage = m;
        setProperties();
    }

    public Email(String name, String sub, String m, String email){
        properties = new Properties();
        subject = sub;
        textMessage = m;
        nameNoName = name;
        emailNoName = email;
        setProperties();
    }
    private void setProperties(){
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
    }

    private Properties getProperties(){
        return properties;
    }

    private Session getSession(String email, String password) {
        session = Session.getInstance(getProperties(),new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        return session;
    }

    public void sendEmail(){
        message = new MimeMessage(getSession(WARMSTAR_EMAIL, WARMSTAR_PASSWORD));
        try {
                message.setFrom(new InternetAddress(WARMSTAR_EMAIL));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(userE.getEmail()));
                message.setSubject(subject);
                message.setText(textMessage);

                Transport.send(message);
        }catch(MessagingException m){
            m.printStackTrace();
        }
    }

    public void sendUserEmail(){
        message = new MimeMessage(getSession(WARMSTAR_EMAIL, WARMSTAR_PASSWORD));
        try {
                message.setFrom(new InternetAddress(WARMSTAR_EMAIL));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress("furriets@gmail.com"));
                message.setSubject(subject);
                message.setText(textMessage + " От " + userE.getEmail() + "---- " );

                Transport.send(message);
        }catch(MessagingException m){
            m.printStackTrace();
        }
    }

    public void sendNoNameUserEmail(){
        message = new MimeMessage(getSession(WARMSTAR_EMAIL, WARMSTAR_PASSWORD));
        try {
            message.setFrom(new InternetAddress(WARMSTAR_EMAIL));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("furriets@gmail.com"));
            message.setSubject(subject);
            message.setText(textMessage + " from: " + emailNoName + " Name : " + nameNoName);

            Transport.send(message);
        }catch(MessagingException m){
            m.printStackTrace();
        }
    }

}
