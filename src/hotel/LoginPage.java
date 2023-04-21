package hotel;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class LoginPage {

	private JFrame frame;
	private JTextField tfusername;
	private JPasswordField tfpwd;
	private JButton btnLogin;
	private JButton btnCancel;
	private JLabel Ustar;
	private JLabel Pstar;

	public LoginPage() {
		Ustar = new JLabel("*");
		Pstar = new JLabel("*");
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 23));
		frame.setBounds(200,100, 898, 624);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN ");
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblLogin.setBounds(389, 190, 212, 67);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblUsername.setBounds(280, 324, 155, 50);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblPassword.setBounds(280, 413, 133, 38);
		frame.getContentPane().add(lblPassword);
		
		tfusername = new JTextField();
		tfusername.setFont(new Font("Times New Roman", Font.BOLD, 23));
		tfusername.setBounds(489, 331, 208, 38);
		frame.getContentPane().add(tfusername);
		tfusername.setColumns(10);
		
		tfpwd = new JPasswordField();
		tfpwd.setFont(new Font("Times New Roman", Font.BOLD, 23));
		tfpwd.setBounds(489, 414, 208, 38);
		frame.getContentPane().add(tfpwd);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnLogin.setBounds(288, 513, 147, 50);
		frame.getContentPane().add(btnLogin);
		
		btnCancel = new JButton("QUIT");
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnCancel.setBounds(565, 513, 155, 51);
		frame.getContentPane().add(btnCancel);
		
		Ustar.setForeground(Color.RED);
		Ustar.setFont(new Font("Times New Roman", Font.BOLD, 28));
		Ustar.setBounds(699, 347, 46, 21);
		frame.getContentPane().add(Ustar);
		
		Pstar.setForeground(Color.RED);
		Pstar.setFont(new Font("Times New Roman", Font.BOLD, 28));
		Pstar.setBounds(699, 430, 46, 21);
		frame.getContentPane().add(Pstar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("images\\login (8).png"));
		label.setBounds(12, 234, 314, 283);
		frame.getContentPane().add(label);
		
		JLabel lblHotelManagementSystem = new JLabel("HOTEL CRESCENT");
		lblHotelManagementSystem.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		lblHotelManagementSystem.setBounds(279, 72, 636, 80);
		frame.getContentPane().add(lblHotelManagementSystem);
		
		Ustar.setVisible(false);
		Pstar.setVisible(false);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	public JButton getLoginBtn() {
		return btnLogin;
	}
	public JButton getCancelBtn() {
		return btnCancel;
	}

	public String getUserName() {
		return tfusername.getText();
	}
	public String getPassword() {
		char[] passwordChars = tfpwd.getPassword();
		return String.valueOf(passwordChars);
	}
	public void resetUserPwd() {
		tfusername.setText("");
		tfpwd.setText("");
	}

	public JLabel getUStar() {
		return Ustar;
	}
	public JLabel getPStar() {
		return Pstar;
	}

	public void show() {
        frame.setVisible(true);
    }
}
