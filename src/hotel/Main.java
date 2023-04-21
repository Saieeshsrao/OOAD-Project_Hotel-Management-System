package hotel;

public class Main {
	public static void main(String[] args) {
		HotelView hotelView = new HotelView();
		HotelController hotelControl = new HotelController(hotelView);
		hotelView.show();
	}
}
