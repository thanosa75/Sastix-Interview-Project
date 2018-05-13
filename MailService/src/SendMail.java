import java.util.Properties;
import javax.mail.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SendMail {
	public String getEmail;
	public String mailTo ;
	public String getSubject;
	public String getMessage;
	
	public SendMail(String from,String to,String sub,String mess){
		getEmail=from;
		mailTo=to;
		getSubject=sub;
		getMessage=mess;
	}
	
	public void send() {
			final String authAddress = "mailserviceproj@gmail.com";      
			final String authPassword = "MailService123";        
	        String fullMessage="";
	        
	        try{    
	        	Properties props = new Properties();
	        	props.put("mail.smtp.auth", "true");
	    		props.put("mail.smtp.starttls.enable", "true");
	    		props.put("mail.smtp.host", "smtp.gmail.com");
	    		props.put("mail.smtp.port", "587");      
		            // create some properties and get the default Session
		            Session sessionMail = Session.getInstance(props, new Authenticator() {
		                 public PasswordAuthentication getPasswordAuthentication() {      
		                         return new PasswordAuthentication(authAddress, authPassword);
		                 }                                                                    
		                });            
	
		            	sessionMail.setDebug(true);
		            
		            
		    			Message message = new MimeMessage(sessionMail);
		    			message.setFrom(new InternetAddress(getEmail));
		    			message.setRecipients(Message.RecipientType.TO,
		    			InternetAddress.parse(mailTo));
		    			message.setSubject(getSubject);
		    			fullMessage="Hi There!\nYou just received an email from "+getEmail+""+" having the following subject and message: \nSubject: \n"+getSubject+"\nMessage: \n"+getMessage+"\nThank You";
		    			message.setText(fullMessage);
		    			Transport.send(message);
		    			System.out.println("Done");
		   } catch (MessagingException e) {
		    	throw new RuntimeException(e);
		   }
	}
}
