package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;

public class HotelController implements ActionListener{
    private HotelView hotelView;
	private String[] logged_in_as = {"", ""};

    public HotelController(HotelView hv) {
        hotelView = hv;

        hotelView.loginPage.getLoginBtn().addActionListener(e -> {
			hotelView.loginPage.getUStar().setVisible(false);
			hotelView.loginPage.getPStar().setVisible(false);

			if(hotelView.loginPage.getUserName().equals("")) {
				hotelView.loginPage.getUStar().setVisible(true);
			}
			if(hotelView.loginPage.getPassword().equals("")) {
				hotelView.loginPage.getPStar().setVisible(true);
			}
			else {
				try {
					GetConnection connect=new GetConnection();
		    		Connection conn=connect.getConnection();
					PreparedStatement ps = conn.prepareStatement("SELECT * FROM login WHERE username= ? AND password=? " );
					ps.setString(1, hotelView.loginPage.getUserName());
					ps.setString(2, hotelView.loginPage.getPassword());
					
					ResultSet rs = ps.executeQuery();
					if(rs.next()) {
						logged_in_as[0] = rs.getString("username");
						logged_in_as[1] = rs.getString("role");
						hotelView.loginPage.getFrame().setVisible(false);
						startCustomerAdmin();
					}
					else
						JOptionPane.showMessageDialog(null, "Please check user name / password", "Error",JOptionPane.ERROR_MESSAGE);
				}
				catch(SQLException p) {
					p.printStackTrace();
				}
			}
		});

		hotelView.loginPage.getCancelBtn().addActionListener(e -> {
			System.exit(0);
		});
    }

	public void startCustomerAdmin() {
		hotelView.customerAdminPage = new CustomerAdminPage();
		hotelView.customerAdminPage.setVisible(true);
		hotelView.customerAdminPage.pack();
		hotelView.customerAdminPage.setLocationRelativeTo(null);	    
		hotelView.customerAdminPage.setBounds(200,100, 1015, 574);
		hotelView.customerAdminPage.getUsernameLabel().setText("User: " + logged_in_as[0]);
		hotelView.customerAdminPage.getRoleLabel().setText("Role: " + logged_in_as[1]);

		hotelView.customerAdminPage.getCustomerButton().addActionListener(e -> {
			hotelView.customerAdminPage.setVisible(false);
			if(hotelView.customerAdminPage.restaurantOrRoom().equals("RESTAURANT")) {
				startCustomerRestaurant();
			}
			else if(hotelView.customerAdminPage.restaurantOrRoom().equals("ROOM")) {
				startCustomerRoom();
			}
		});

		hotelView.customerAdminPage.getAdminButton().addActionListener(e -> {
			if(logged_in_as[1].equals("admin")) {
				hotelView.customerAdminPage.setVisible(false);
				startAdminForm();
			}
			else {
				JOptionPane.showMessageDialog(null, "You are not an Admin!", "Error",JOptionPane.ERROR_MESSAGE);
			}
		});

		hotelView.customerAdminPage.getLogoutButton().addActionListener(e -> {
			logged_in_as[0] = "";
			logged_in_as[1] = "";
			hotelView.customerAdminPage.setVisible(false);
			hotelView.customerAdminPage = null;
			hotelView.loginPage.resetUserPwd();
			hotelView.loginPage.getFrame().setVisible(true);
		});
	}

	public void startCustomerRoom() {
		hotelView.customerRoom = new CustomerRoom();
		hotelView.customerRoom.setVisible(true);
		hotelView.customerRoom.pack();
		hotelView.customerRoom.setLocationRelativeTo(null);
		hotelView.customerRoom.setBounds(50, 50, 1236, 700);

		hotelView.customerRoom.getBackButton().addActionListener(e -> {
			hotelView.customerRoom.setVisible(false);

			hotelView.customerAdminPage.setVisible(true);
			hotelView.customerAdminPage.pack();
			hotelView.customerAdminPage.setLocationRelativeTo(null);
			hotelView.customerAdminPage.setBounds(200, 100, 1015, 574);

			hotelView.customerRoom.getBackButton().removeActionListener(this);
			hotelView.customerRoom = null;
		});
	}

	public void startCustomerRestaurant() {
		hotelView.customerRestaurant = new CustomerRestaurant();
		hotelView.customerRestaurant.setVisible(true);
		hotelView.customerRestaurant.pack();
		hotelView.customerRestaurant.setLocationRelativeTo(null);
		hotelView.customerRestaurant.setBounds(50, 50, 1367, 772);

		hotelView.customerRestaurant.getBackButton().addActionListener(e -> {
			hotelView.customerRestaurant.setVisible(false);

			hotelView.customerAdminPage.setVisible(true);
			hotelView.customerAdminPage.pack();
			hotelView.customerAdminPage.setLocationRelativeTo(null);
			hotelView.customerAdminPage.setBounds(200, 100, 1015, 574);

			hotelView.customerRestaurant.getBackButton().removeActionListener(this);
			hotelView.customerRestaurant = null;
		});
	}

	public void startAdminForm() {
		hotelView.adminForm = new AdminForm();
		hotelView.adminForm.setVisible(true);
		hotelView.adminForm.pack();
		hotelView.adminForm.setLocationRelativeTo(null);
		hotelView.adminForm.setBounds(200, 100, 1038, 623);
		hotelView.adminForm.getUsernameLabel().setText("User: " + logged_in_as[0]);
		hotelView.adminForm.getRoleLabel().setText("Role: " + logged_in_as[1]);

		hotelView.adminForm.getManageRooms().addActionListener(e -> {
			hotelView.adminForm.setVisible(false);
			startAddRooms();
		});

		hotelView.adminForm.getManageDishes().addActionListener(e -> {
			hotelView.adminForm.setVisible(false);
			startAddDishes();
		});

		hotelView.adminForm.getBackButton().addActionListener(e -> {
			hotelView.adminForm.setVisible(false);

			hotelView.customerAdminPage.setVisible(true);
			hotelView.customerAdminPage.pack();
			hotelView.customerAdminPage.setLocationRelativeTo(null);
			hotelView.customerAdminPage.setBounds(200, 100, 1015, 574);

			hotelView.adminForm.getBackButton().removeActionListener(this);
			hotelView.adminForm = null;
		});
	}

	public void startAddRooms() {
		hotelView.addRooms = new AddRooms();
		hotelView.addRooms.setVisible(true);
		hotelView.addRooms.pack();
		hotelView.addRooms.setLocationRelativeTo(null);
		hotelView.addRooms.setBounds(50, 50, 965, 577);

		hotelView.addRooms.getBackButton().addActionListener(e -> {
			hotelView.addRooms.setVisible(false);

			hotelView.adminForm.setVisible(true);
			hotelView.adminForm.pack();
			hotelView.adminForm.setLocationRelativeTo(null);
			hotelView.adminForm.setBounds(200, 100, 1080, 633);
			
			hotelView.addRooms.getBackButton().removeActionListener(this);
			hotelView.addRooms = null;
		});
	}

	public void startAddDishes() {
		hotelView.addDishes = new AddDishes();
		hotelView.addDishes.setVisible(true);
		hotelView.addDishes.pack();
		hotelView.addDishes.setLocationRelativeTo(null);
		hotelView.addDishes.setBounds(50,50, 965, 577);

		hotelView.addDishes.getBackButton().addActionListener(e -> {
			hotelView.addDishes.setVisible(false);

			hotelView.adminForm.setVisible(true);
			hotelView.adminForm.pack();
			hotelView.adminForm.setLocationRelativeTo(null);
			hotelView.adminForm.setBounds(200, 100, 1080, 633);
			
			hotelView.addDishes.getBackButton().removeActionListener(this);
			hotelView.addDishes = null;
		});
	}
}
