package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.AuthenticationFailedException;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class sendMail.
 */
public class sendMail {

	public static String serverReportFolderPrefix = null;

	/** The user name. */
	public static String userName = null;

	/** The pass word. */
	public static String passWord = null;

	/** The email to. */
	public static String emailTo = null;

	/** The email to CC. */
	public static String emailToCC = null;

	/** The email to BCC. */
	public static String emailToBCC = null;

	/** The starttls. */
	public static String starttls = null;

	/** The host. */
	public static String host = null;

	/** The port. */
	public static String port = null;

	/** The prop. */
	public static Properties prop = new Properties();

	/** The socket factory class. */
	public static String socketFactoryClass = null;

	/** The fallback. */
	public static String fallback = null;

	/** The path. */
	public static String path = null;

	/** The module name. */
	public static String moduleName = null;

	/** The index of comma. */
	public static int indexOfComma = 0;

	/** The user full name. */
	public static String userFullName = null;

	/** The email regex. */
	public static String EMAIL_REGEX = "[a-z0-9\\_\\-\\.]+@[a-z0-9\\_\\-\\.]+\\.[a-z]+";

	/**
	 * Send email to client.
	 *
	 * @throws Exception the exception
	 */
	public static void sendEmailToClient(String body, boolean attachmentFlag, boolean urgentFlag) throws Exception { 
		
		try {
     
        String mailPropertiesFile = System.getProperty("user.dir") + "/src/main/resources/Config/mail.properties";

		prop.load(new FileInputStream(mailPropertiesFile));
		if (prop.getProperty("EmailFlag").equalsIgnoreCase("Y")) {
			userName = prop.getProperty("userName");
			passWord = prop.getProperty("passWord");
			emailTo = prop.getProperty("emailTo");
			emailToCC = prop.getProperty("emailToCC");
			emailToBCC = prop.getProperty("emailToBCC");

        Properties props = new Properties();
   props.put("mail.smtp.host", "smtp-mail.outlook.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName,passWord);
                    }
                });


       
        Message msg = new MimeMessage(session);
      
        msg.setFrom(new InternetAddress(userName, "NoReply"));
       
        if (GlobalUtil.emailflag) {
			msg.setSubject("Alert: "+GlobalUtil.reportfolder+ " scenario(s) failed on "+GlobalUtil.Environment);
		} else {
			msg.setSubject(GlobalUtil.Environment+" "+prop.getProperty("subject"));
		}
      
        if (emailTo.contains(",")) {
			String[] multipleEmailTo = emailTo.split(",");
			for (int j = 0; j < multipleEmailTo.length; j++) {
				System.out.println(multipleEmailTo[j]);
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(multipleEmailTo[j]));
			}

		} else {
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
		}

		if (!"".equals(emailToCC)) {

			if (emailToCC.contains(",")) {
				String[] multipleEmailTo = emailToCC.split(",");
				for (int j = 0; j < multipleEmailTo.length; j++) {
					msg.addRecipient(Message.RecipientType.CC, new InternetAddress(multipleEmailTo[j]));
				}

			} else {
				msg.addRecipient(Message.RecipientType.CC, new InternetAddress(emailToCC));
			}
		}

		if (!"".equals(emailToBCC)) {

			if (emailToBCC.contains(",")) {
				String[] multipleEmailTo = emailToBCC.split(",");
				for (int j = 0; j < multipleEmailTo.length; j++) {
					msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(multipleEmailTo[j]));
				}

			} else {
				msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(emailToBCC));
			}
		}
		
		
		
		BodyPart messageBodyPart = new MimeBodyPart();

		if (body.contains("<html>"))
			messageBodyPart.setContent(body, "text/html");
		else
			messageBodyPart.setText(body);
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		if (attachmentFlag) {
			messageBodyPart = new MimeBodyPart();
			 String path = System.getProperty("user.dir") +
			 "./ExecutionReports/extentReportt.html";
			String zipreportPath = ZipFolder.zipper();
			DataSource source = new FileDataSource(zipreportPath);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(GlobalUtil.reportfolder+" "
					+ HTMLReportUtil.folderName + ".zip");
			multipart.addBodyPart(messageBodyPart);
		}
		msg.setContent(multipart);

		if (urgentFlag)
			msg.setHeader("X-Priority", "1");

		Transport transport = session.getTransport("smtp");
		System.out.println(transport);

		transport.connect("smtp-mail.outlook.com", userName, passWord);

		transport.sendMessage(msg, msg.getAllRecipients());

		transport.close();
		
		
        
        System.out.println("Email sent successfully...");
     
		} }catch (AuthenticationFailedException e1) {
			JFrame wrongCredentials = new JFrame();

			// JOptionPane.showMessageDialog(wrongCredentials, "Wrong Username or
			// Password");

		} catch (Exception e) {
			e.printStackTrace();
		}
	
}
	
	/**
	 * Copy directory data.
	 *
	 * @param sourceDir the source dir
	 * @param targetDir the target dir
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void copyDirectoryData(String sourceDir, String targetDir) throws IOException {

		File srcDir = new File(System.getProperty("user.dir") + "/ExecutionReports/" + sourceDir);
		File destDir = new File(System.getProperty("user.dir") + "/ExecutionReports/ExecutionReports/" + targetDir);
		FileUtils.copyDirectory(srcDir, destDir);
	}

}