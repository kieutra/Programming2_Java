import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//Thi Thanh Tra KIEU #261066512
class ReservationTest {
	private static Room kingRoom;
	private static String name;
	private static Reservation res1;
	@BeforeAll
	@Test
	 public static void setup() {
		kingRoom = new Room("king");
		name = "client 1";
		res1 = new Reservation(kingRoom, name);
	}
	@Test
	public void testGetName() {
		assertEquals("client 1", res1.getName());	
	}
	
	@Test
	public void testGetRoom() {
		assertEquals(kingRoom, res1.getRoom());
	}
}
