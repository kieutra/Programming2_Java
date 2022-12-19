import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//Thi Thanh Tra KIEU #261066512
class BookingSystemTest {
	private static int [] randomNumbers;
	private static String[] myRooms;
	
	@BeforeAll
	public static void setup() {
		randomNumbers = new int[50];
		myRooms = new String[50];
	}
	@Test
	void testGetRandomType() {
		String type = "";
		BookingSystem bs = new BookingSystem();
		for(int i = 0 ; i < 50; i++) {
			type = BookingSystem.getRandomType();
			myRooms[i] = type;
		}
		assertEquals("double", myRooms[0]);
		assertEquals("queen", myRooms[1]);
		assertEquals("king", myRooms[2]);		
	}
	
	@Test
	void testGetRandomNumberOfRooms() {
		int value = 0;
		for(int i = 0; i<50; i++) {
			value = BookingSystem.getRandomNumberOfRooms();
			randomNumbers[i] = value;
		}
		for(int i = 0; i<50; i++) {
			assertTrue(randomNumbers[i] >=1);
			assertTrue(randomNumbers[i] <=50);
		}
	}
	
	@Test
	void testCreateRooms() {
		int numberOfRooms = 5;
		Room[] rooms = new Room[5];		
		rooms = BookingSystem.createRooms(numberOfRooms);
		assertEquals("king", rooms[0].getType());
		assertEquals("king", rooms[1].getType());
		assertEquals("king", rooms[2].getType());
		assertEquals("king", rooms[3].getType());
		assertEquals("double", rooms[4].getType());
	}
}
