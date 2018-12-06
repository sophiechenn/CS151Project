public class HotelReservationSystem {
	
	public static void main(String[] args) {
		HotelModel hotel = new HotelModel(null);
		HotelFrame frame = new HotelFrame(hotel);
		hotel.attach(frame);
	}
}