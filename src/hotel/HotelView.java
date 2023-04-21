package hotel;

public class HotelView {
    
    public LoginPage loginPage;
    public CustomerAdminPage customerAdminPage;

    public CustomerRestaurant customerRestaurant;
    public CustomerRoom customerRoom;

    public AdminForm adminForm;
    public AddDishes addDishes;
    public AddRooms addRooms;

    public HotelView() {
        loginPage = new LoginPage();
    }

    public void show() {
        loginPage.show();
    }
}
