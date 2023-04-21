package hotel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class CustomerAdminPage extends JFrame {
	
	private JComboBox comboBox;
	private JPanel contentPane;
	private JButton customerButton;
	private JButton adminButton;
	private JButton logoutButton;
	private JLabel usernameLabel;
	private JLabel roleLabel;
	
	public CustomerAdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1015, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("High Tower Text", Font.BOLD, 22));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ROOM", "RESTAURANT"}));
		comboBox.setBounds(53, 371, 408, 48);
		contentPane.add(comboBox);
		
		customerButton = new JButton("  CUSTOMER");
		customerButton.setToolTipText("");
		customerButton.setFont(new Font("High Tower Text", Font.BOLD, 30));
		customerButton.setIcon(new ImageIcon("images\\dining (1).png"));
		customerButton.setBounds(53, 174, 408, 197);
		contentPane.add(customerButton);
		
		adminButton = new JButton("ADMIN");
		adminButton.setFont(new Font("High Tower Text", Font.BOLD, 30));
		adminButton.setIcon(new ImageIcon("images\\admin.png"));
		adminButton.setBounds(523, 174, 379, 245);
		contentPane.add(adminButton);
		
		usernameLabel = new JLabel("User:");
		usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		usernameLabel.setForeground(new Color(240, 255, 255));
		usernameLabel.setBounds(23, 450, 275, 24);
		contentPane.add(usernameLabel);

		roleLabel = new JLabel("Role:");
		roleLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		roleLabel.setForeground(new Color(240, 255, 255));
		roleLabel.setBounds(23, 485, 275, 24);
		contentPane.add(roleLabel);

		logoutButton = new JButton("LOGOUT");
		logoutButton.setFont(new Font("High Tower Text", Font.BOLD, 10));
		logoutButton.setBounds(893, 460, 90, 40);
		contentPane.add(logoutButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images\\bb.jpg"));
		lblNewLabel.setBounds(0, 0, 997, 220);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		panel.setBounds(0, 432, 997, 95);
		contentPane.add(panel);
		
		JLabel lblFromSeasideTo = new JLabel("Hotel Crescent");
		lblFromSeasideTo.setForeground(new Color(240, 255, 255));
		lblFromSeasideTo.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 60));
		panel.add(lblFromSeasideTo);
	}

	public JButton getCustomerButton() {
		return customerButton;
	}
	public JButton getAdminButton() {
		return adminButton;
	}
	public JButton getLogoutButton() {
		return logoutButton;
	}
	public String restaurantOrRoom() {
		return comboBox.getSelectedItem().toString();
	}
	public JLabel getUsernameLabel() {
		return usernameLabel;
	}
	public JLabel getRoleLabel() {
		return roleLabel;
	}
}
