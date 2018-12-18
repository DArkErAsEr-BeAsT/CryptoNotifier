import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Main extends Object{

public static void main(String [] args)
{

    try{

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // for gmail use smtp.gmail.com
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true"); 
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("dcolonna12.dc@gmail.com", "PIERRE0802");
            }
        });


        Message msg = new MimeMessage( mailSession );

        msg.setFrom( new InternetAddress( "dcolonna12.dc@gmail.com" ) );
        msg.setRecipients( Message.RecipientType.TO,InternetAddress.parse("colonna.david0@gmail.com") );
        msg.setSentDate( new Date());
        msg.setSubject( "Hello World!" );

        msg.setText( "Hello from my first e-mail sent with JavaMail" );

        Transport.send( msg );

    }catch(Exception E){
        System.out.println( "Oops something has gone pearshaped!");
        System.out.println( E );
    }
}
}