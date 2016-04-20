package email;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class email extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					email frame = new email();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public email() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("To");
		lblNewLabel.setBounds(77, 64, 46, 25);
		contentPane.add(lblNewLabel);
		
		
		final JTextArea txt=new JTextArea("Hi Write something here ..... ");
		txt.setBounds(77, 101, 304, 99);
		contentPane.add(txt);
		
		textField = new JTextField();
		textField.setBounds(129, 67, 252, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				   
			       final String from = "javaemailtestbysayem@gmail.com";
			      final  String password = "123456j@va";
			        String to = textField.getText().toString();
			        String msg=txt.getText();
			        Properties props = new Properties();
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.starttls.enable", "true");
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.port", "587");
			        
			        Session session = Session.getInstance(props, 
			            new javax.mail.Authenticator() {
			                protected PasswordAuthentication getPasswordAuthentication() {
			                    return new PasswordAuthentication(from, password);
			                }
			            });
			        
			        try {
			            Message message = new MimeMessage(session);
			            message.setFrom(new InternetAddress(from));
			            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			            message.setSubject("Hello From Mailbox");
			            message.setText(msg);
			            Transport.send(message);
			            
			            //System.out.println("DONE!");
			            JOptionPane.showMessageDialog(null, "Email Sent :) thanks for using");
			        } catch(MessagingException ex) {
			            System.out.println(ex);
			        }
			}
		});
		
		btnSend.setBounds(241, 212, 117, 25);
		contentPane.add(btnSend);
	}

}
