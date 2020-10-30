import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;


public class FrontPage implements ActionListener {
	
	JFrame f;
	Timer t;
	JLabel poster, uname, password, logo, mail, cnt;
	JButton signin, signup, submit;
	JTextField  username, email, contact;
	JPasswordField pass;
	static int po, pop = 0;
	
	public FrontPage() {
		f = new JFrame("Online Movie Ticket Booking");
		ImageIcon icon = new ImageIcon("icon.jpg");
		f.setIconImage(icon.getImage());
		f.setVisible(true);
		f.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		f.setLayout(null);
		
		f.setContentPane(new JLabel(new ImageIcon("contentpane.jpg")));
		
		logo = new JLabel(new ImageIcon(new ImageIcon("logo.png").getImage().getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH)));
		f.add(logo);
		logo.setBounds(30, 0, 300, 200);
		
		uname = new JLabel(new ImageIcon(new ImageIcon("username-icon.png").getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		f.add(uname);
		uname.setBounds(500, 30 ,50, 50);
		
		username = new JTextField();
		f.add(username);
		username.setBounds(560, 38, 220, 30);
	    username.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
	    username.setFont(new Font("Baskerville", Font.BOLD, 14));
	    
	    password = new JLabel(new ImageIcon(new ImageIcon("password-icon.png").getImage().getScaledInstance(37, 37, java.awt.Image.SCALE_SMOOTH)));
		f.add(password);
		password.setBounds(500, 70, 50, 50);
		
		pass = new JPasswordField();
		f.add(pass);
		pass.setBounds(560, 85, 220, 30);
		pass.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
		
		mail = new JLabel(new ImageIcon(new ImageIcon("mail-icon.png").getImage().getScaledInstance(37, 37, java.awt.Image.SCALE_SMOOTH)));
		f.add(mail);
		mail.setBounds(860, 30, 50, 50);
		mail.setVisible(false);
		
		email = new JTextField();
		f.add(email);
		email.setBounds(928, 38, 220, 30);
		email.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
	    email.setFont(new Font("Baskerville", Font.BOLD, 14));
	    email.setVisible(false);
	    
	    cnt = new JLabel(new ImageIcon(new ImageIcon("phone-icon.png").getImage().getScaledInstance(37, 37, java.awt.Image.SCALE_SMOOTH)));
	    f.add(cnt);
	    cnt.setBounds(860, 73, 50, 50);
	    cnt.setVisible(false);
	    
	    contact = new JTextField();
	    f.add(contact);
	    contact.setBounds(928, 85, 220, 30);
	    contact.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
	    contact.setFont(new Font("Baskerville", Font.BOLD, 14));
	    contact.setVisible(false);
	    
	    signin = new JButton("LOGIN");
	    f.add(signin);
	    signin.setBounds(560, 138, 105, 33);
	    signin.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
	    signin.setFont(new Font("Baskerville", Font.BOLD, 14));
	    signin.addActionListener(this);
	    
	    signup = new JButton("REGISTER");
	    f.add(signup);
	    signup.setBounds(690, 138, 105, 33);
	    signup.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
	    signup.setFont(new Font("Baskerville", Font.BOLD, 14));
	    signup.addActionListener(this);
	    
	    submit = new  JButton("SUBMIT");
	    f.add(submit);
	    submit.setBounds(928, 138, 105, 33);
	    submit.setFont(new Font("Baskerville", Font.BOLD, 14));
	    submit.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
	    submit.setVisible(false);
	    submit.addActionListener(this);
	    
	    poster = new JLabel(new ImageIcon(new ImageIcon("poster-2.jpg").getImage().getScaledInstance(1370, 600, java.awt.Image.SCALE_SMOOTH)));
	    f.add(poster);
	    poster.setBounds(0, 180, 1370, 600);
	    
	    po = 1;
	    t = new Timer(3000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(po == 1)
				{
					poster.setIcon(new ImageIcon(new ImageIcon("poster-1.jpg").getImage().getScaledInstance(1370, 700, java.awt.Image.SCALE_SMOOTH)));
					po++;
				}
				
				else if(po == 2)
				{
					poster.setIcon(new ImageIcon(new ImageIcon("poster-3.jpg").getImage().getScaledInstance(1370, 550, java.awt.Image.SCALE_SMOOTH)));
					po++;
				}
				
				else if(po == 3)
				{
					poster.setIcon(new ImageIcon(new ImageIcon("poster-4.jpg").getImage().getScaledInstance(1370, 700, java.awt.Image.SCALE_SMOOTH)));
					po++;
				}
				
				else if(po == 4)
				{
					poster.setIcon(new ImageIcon(new ImageIcon("poster-5.jpg").getImage().getScaledInstance(1370, 650, java.awt.Image.SCALE_SMOOTH)));
					po++;
				}
				
				else if(po == 5)
				{
					poster.setIcon(new ImageIcon(new ImageIcon("poster-2.jpg").getImage().getScaledInstance(1370, 600, java.awt.Image.SCALE_SMOOTH)));
					po = 1;
				}
			}
		});
	    
	    t.start();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == signup) 
		{
			mail.setVisible(true);
		    email.setVisible(true);
		    cnt.setVisible(true);
		    submit.setVisible(true);
		    contact.setVisible(true);
		    signup.setVisible(false);
		    signin.setVisible(false);
		}
		
		if(e.getSource() == signin)
		{
			username.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			pass.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/customer", "root", "");
				String query = "Select * from login_database where username=? and password=?";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, username.getText());
				pst.setString(2, pass.getText());
				ResultSet rs = pst.executeQuery();
				
				if(rs.next())
				{
					username.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
					pass.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
					JOptionPane.showMessageDialog(null, "Login successful!");
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Username or Password incorrect");
					username.setText("");
					pass.setText("");
				}
				
				con.close();
			}
			
			catch (Exception exception) {
				JOptionPane.showMessageDialog(null, exception);
			}
		}
		
		if(e.getSource() == submit)
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/customer", "root", "");
				String query = "INSERT INTO login_database(username, password, email, contact) VALUES (?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, username.getText());
				ps.setString(2, pass.getText());
				ps.setString(3, email.getText());
				ps.setString(4, contact.getText());
				
				ps.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "User Registration successful!");
				
				mail.setVisible(false);
			    email.setVisible(false);
			    cnt.setVisible(false);
			    submit.setVisible(false);
			    contact.setVisible(false);
			    signup.setVisible(true);
			    signin.setVisible(true);
			    con.close();
			}
			
			catch (Exception exception) {
				JOptionPane.showMessageDialog(null, exception);
			}
		}
	}

	public static void main(String[] args) {
		new FrontPage();

	}

}
