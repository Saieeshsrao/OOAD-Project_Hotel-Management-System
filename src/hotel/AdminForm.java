package hotel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AdminForm extends JFrame {

	private JPanel contentPane;
	private JButton btnManageRooms;
	private JButton btnManageDishes;
	private JButton btnBack;
	private JLabel usernameLabel;
	private JLabel roleLabel;

	public AdminForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnManageRooms = new JButton("MANAGE ROOMS");
		btnManageRooms.setIcon(new ImageIcon("images\\bed (1).png"));
		btnManageRooms.setFont(new Font("High Tower Text", Font.BOLD, 22));
		btnManageRooms.setBounds(229, 227, 383, 256);
		contentPane.add(btnManageRooms);
		
		btnManageDishes = new JButton("MANAGE DISHES");
		btnManageDishes.setIcon(new ImageIcon("images\\dining (2).png"));
		btnManageDishes.setFont(new Font("High Tower Text", Font.BOLD, 20));
		btnManageDishes.setBounds(622, 228, 369, 256);
		contentPane.add(btnManageDishes);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("images\\user (1).png"));
		label.setBounds(0, 0, 253, 221);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 204));
		panel.setBounds(23, 172, 183, 357);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 204));
		panel_1.setBounds(168, 30, 811, 172);
		panel_1.setLayout(null);
		contentPane.add(panel_1);
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("High Tower Text", Font.BOLD, 22));
		btnBack.setBounds(651, 528, 169, 45);
		contentPane.add(btnBack);

		usernameLabel = new JLabel("User:");
		usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		usernameLabel.setForeground(new Color(240, 255, 255));
		usernameLabel.setBounds(300, 50, 275, 24);
		panel_1.add(usernameLabel);

		roleLabel = new JLabel("Role:");
		roleLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		roleLabel.setForeground(new Color(240, 255, 255));
		roleLabel.setBounds(300, 85, 275, 24);
		panel_1.add(roleLabel);
	}

	public JButton getManageRooms() {
		return btnManageRooms;
	}
	public JButton getManageDishes() {
		return btnManageDishes;
	}
	public JButton getBackButton() {
		return btnBack;
	}
	public JLabel getUsernameLabel() {
		return usernameLabel;
	}
	public JLabel getRoleLabel() {
		return roleLabel;
	}
}
