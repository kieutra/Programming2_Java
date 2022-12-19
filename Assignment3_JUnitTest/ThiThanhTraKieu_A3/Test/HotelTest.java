import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//Thi Thanh Tra KIEU #261066512
class HotelTest {
private static Room[]rooms;
private static Hotel myHotel;
	@BeforeAll
	@Test
	 public static void setup() {
		Room kingRoom1 = new Room("king");
		Room kingRoom2 = new Room("king");
		Room doubleRoom1 = new Room("double");
		Room doubleRoom2 = new Room("double");
		Room queenRoom1 = new Room("queen");
		Room queenRoom2 = new Room("queen");
		rooms = new Room[]{kingRoom1, doubleRoom1, queenRoom1, kingRoom2, doubleRoom2, queenRoom2};
		myHotel = new Hotel("My Hotel", rooms);
	}
	

	@Test
	void testCreateReservation_WhenNoTypeMatched() {
		String name = "client 1";
		String type = "noType";
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		myHotel.createReservation(name, type);			
		assertEquals("Sorry client 1, we have no available rooms of the desired type.", out.toString().trim());
	}
	
	@Test
	void testCancelReservation_Success() {
		myHotel.createReservation("client 1", "King");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		myHotel.cancelReservation("client 1", "king");	
		assertEquals("client 1, your reservation for a kingroom has been successfully cancelled.", out.toString().trim());
	}

	@Test
	void testCancelReservation_Failed() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		myHotel.cancelReservation("client 3", "King");	
		assertEquals("There is no reservation for a King room under the name of client 3.", out.toString().trim());
	}
	
	@Test
	void testCreateReservation_WhenKingAvailable() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));		
		myHotel.createReservation("client 1", "King");			
		assertEquals("You have successfully reserved a King room under the name client 1. We look forward having you at My Hotel", out.toString().trim());
	}
	
	@Test
	void testCreateReservation_AllQueenOccupied() {
		myHotel.createReservation("client2", "Queen");
		myHotel.createReservation("client4", "Queen");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		myHotel.createReservation("client 10", "Queen");	
		assertEquals("Sorry client 10, we have no available rooms of the desired type.", out.toString().trim());
	}
	@Test
	void testCreateReservation_1QueenOccupied() {
		myHotel.cancelReservation("client2", "queen");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		myHotel.createReservation("client 15", "queen");
		assertEquals("You have successfully reserved a queen room under the name client 15. We look forward having you at My Hotel", out.toString().trim());
	}
	
	@Test
	void testPrintInvoice_Success() {
		myHotel.createReservation("CLIENT 2", "King");	
		myHotel.createReservation("CLIENT 2", "Double");	
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		myHotel.printInvoice("client 2");
		assertEquals("client 2's invoice is of $240.0", out.toString().trim());
	}
	
	@Test
	void testStringToString() {
		myHotel.cancelReservation("client4", "Queen");
		myHotel.cancelReservation("client 1", "King");
		assertEquals("Hotel name: My Hotel\nAvailable Rooms: 1 double, 1 queen, 1 king.", myHotel.toString());
	}	
}
