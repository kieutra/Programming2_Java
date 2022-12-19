import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


//Thi Thanh Tra KIEU #261066512
class RoomTest {
private static Room kingRoom1, kingRoom2, doubleRoom1, doubleRoom2, queenRoom1, queenRoom2;


	@BeforeAll
	@Test
	 public static void setup() {
		
		kingRoom1 = new Room("king");
		kingRoom2 = new Room("king");
		doubleRoom1 = new Room("double");
		doubleRoom2 = new Room("double");
		queenRoom1 = new Room("queen");
		queenRoom2 = new Room("queen");
		}
	
	//====================================ROOM TEST==================================
	//=======Throw Exception======		
	@Test
	void testTypeRoomThrowIllegalArgumentException() {
		Exception exception = assertThrows(IllegalArgumentException.class,()->{
			Room a = new Room("A");	
		});
		assertEquals("No room of type 'a' can be created", exception.getMessage());
	}	
	
	/*=====================getType=======================*/
	@Test
	void testRoomKingType() {
		assertEquals("king", kingRoom1.getType());
	}
	@Test
	void testRoomQueenType() {
		assertEquals("queen", queenRoom1.getType());
		
	}
	@Test
	void testRoomDoubleType() {
		assertEquals("double", doubleRoom1.getType());	
	}
	
	/*=====================getPrice=======================*/
	@Test
	void testRoomKingPrice() {		
		assertTrue(kingRoom1.getPrice()==150);		
	}
	@Test
	void testRoomQueenPrice() {		
		assertTrue(queenRoom1.getPrice()==110);		
	}
	@Test
	void testRoomDoublePrice() {
		assertTrue(doubleRoom1.getPrice()==90);		
	}
	
	/*=====================getAvailability=======================*/
	/****King Room should available*****/
	@Test
	void testRoomKingAvailability() {
		assertEquals(true, kingRoom1.getAvailability());	
	}

	@Test
	void testRoomQueenAvailability() {
		assertEquals(true, queenRoom1.getAvailability());	
	}
	@Test
	void testRoomDoubleAvailability() {
		assertEquals(true, doubleRoom1.getAvailability());	
	}
	
	
	/*=====================ChangeAvailability=======================*/
	@Test
	void testRoomKingChangeAvailabilityFromTrueToFalse() {
		kingRoom2.changeAvailability();
		assertEquals(false, kingRoom2.getAvailability());			
	}
	@Test
	void testRoomQueenChangeAvailabilityFromTrueToFalse() {	
		queenRoom2.changeAvailability();
		assertEquals(false, queenRoom2.getAvailability());
	
	}
	@Test
	void testRoomDoubleChangeAvailabilityFromTrueToFalse() {
		doubleRoom2.changeAvailability();
		assertEquals(false, doubleRoom2.getAvailability());	
	}

	@Test
	void testRoomKingChangeAvailabilityFromFalseToTrue() {
		Room roomKing = new Room("KIng");
		roomKing.changeAvailability();
		roomKing.changeAvailability();
		assertEquals(true,roomKing.getAvailability());
	}
	@Test
	void testRoomQueenChangeAvailabilityFromFalseToTrue() {
		Room roomQueen = new Room("QUEEN");
		roomQueen.changeAvailability();
		roomQueen.changeAvailability();
		assertEquals(true, roomQueen.getAvailability());
	}
	@Test
	void testRoomDoubleChangeAvailabilityFromFalseToTrue() {
		Room roomDouble = new Room("DOUBLe");
		roomDouble.changeAvailability();
		roomDouble.changeAvailability();
		assertEquals(true, roomDouble.getAvailability());
		
	}

	/*=====================findAvailableRoomReturnsNull=======================*/
	
	//Return Null when No type matched
	@Test
	void findAvailableRoomIfNoTypeMatched() {
		Room kingRoom1 = new Room("king");
		Room kingRoom2 = new Room("king");
		Room doubleRoom1 = new Room("double");
		Room doubleRoom2 = new Room("double");
		Room queenRoom1 = new Room("queen");
		Room queenRoom2 = new Room("queen");
		Room[]rooms = {kingRoom1, doubleRoom1, queenRoom1, kingRoom2, doubleRoom2, queenRoom2};
		String typeK="";	
		assertEquals(null, Room.findAvailableRoom(rooms, typeK));	
	}	
	
	@Test
	void findAvailableRoomIfAllOccupied() {
		Room kingRoom1 = new Room("king");
		Room kingRoom2 = new Room("king");
		Room doubleRoom1 = new Room("double");
		Room doubleRoom2 = new Room("double");
		Room queenRoom1 = new Room("queen");
		Room queenRoom2 = new Room("queen");
		Room[]rooms = {kingRoom1, doubleRoom1, queenRoom1, kingRoom2, doubleRoom2, queenRoom2};
		
		for(int i = 0; i<rooms.length; i++) 
			rooms[i].changeAvailability();
		
		//King Type
		for(int i = 0; i<rooms.length; i++) 
			assertEquals(null, Room.findAvailableRoom(rooms, "King"));	

		
		//Double Type
		for(int i = 0; i<rooms.length; i++) 
			assertEquals(null, Room.findAvailableRoom(rooms, "Double"));
		
		//Queen Type
		for(int i = 0; i<rooms.length; i++) 
			assertEquals(null, Room.findAvailableRoom(rooms, "queen"));

	}
	
	@Test
	void findAvailableKingRoomIfAllKingOccupied() {
		Room kingRoom1 = new Room("king");
		Room kingRoom2 = new Room("king");
		Room doubleRoom1 = new Room("double");
		Room doubleRoom2 = new Room("double");
		Room queenRoom1 = new Room("queen");
		Room queenRoom2 = new Room("queen");
		Room[]rooms = {kingRoom1, doubleRoom1, queenRoom1, kingRoom2, doubleRoom2, queenRoom2};
		
		rooms[0].changeAvailability();
		rooms[3].changeAvailability();
	
		for(int i = 0; i<rooms.length; i++) 
				assertEquals(null, Room.findAvailableRoom(rooms, "King"));	
	}
	
	@Test
	void findAvailableDoubleRoomIfAllDoubleOccupied() {
		Room kingRoom1 = new Room("king");
		Room kingRoom2 = new Room("king");
		Room doubleRoom1 = new Room("double");
		Room doubleRoom2 = new Room("double");
		Room queenRoom1 = new Room("queen");
		Room queenRoom2 = new Room("queen");
		Room[]rooms = {kingRoom1, doubleRoom1, queenRoom1, kingRoom2, doubleRoom2, queenRoom2};
		
		rooms[1].changeAvailability();
		rooms[4].changeAvailability();
		for(int i = 0; i<rooms.length; i++) 
			assertEquals(null, Room.findAvailableRoom(rooms, "DOUBLE"));
	}
		
	@Test
	void findAvailableQueenRoomIfAllQueenOccupied() {
		Room kingRoom1 = new Room("king");
		Room kingRoom2 = new Room("king");
		Room doubleRoom1 = new Room("double");
		Room doubleRoom2 = new Room("double");
		Room queenRoom1 = new Room("queen");
		Room queenRoom2 = new Room("queen");
		Room[]rooms = {kingRoom1, doubleRoom1, queenRoom1, kingRoom2, doubleRoom2, queenRoom2};
		
		rooms[2].changeAvailability();
		rooms[5].changeAvailability();
		for(int i = 0; i<rooms.length; i++) 
			assertEquals(null, Room.findAvailableRoom(rooms, "queen"));
	}

	/*===============================findAvailableRoomWhenTypeMatchedAndRoomAvailable================================*/	
		
	@Test
	void findAvailableKingRoom_WhenTypeMatched_KingRoom1Available() {
		Room kingRoom1 = new Room("king");
		Room kingRoom2 = new Room("king");
		Room doubleRoom1 = new Room("double");
		Room doubleRoom2 = new Room("double");
		Room queenRoom1 = new Room("queen");
		Room queenRoom2 = new Room("queen");
		Room[]rooms = {kingRoom1, doubleRoom1, queenRoom1, kingRoom2, doubleRoom2, queenRoom2};
		
		for(int i = 0; i<rooms.length; i++) 
			assertEquals(rooms[0], Room.findAvailableRoom(rooms, "king"));		
	}
	
	@Test
	void findAvailableKingRoom_WhenTypeMatched_KingRoom1Occupied() {
		Room kingRoom1 = new Room("king");
		Room kingRoom2 = new Room("king");
		Room doubleRoom1 = new Room("double");
		Room doubleRoom2 = new Room("double");
		Room queenRoom1 = new Room("queen");
		Room queenRoom2 = new Room("queen");
		Room[]rooms = {kingRoom1, doubleRoom1, queenRoom1, kingRoom2, doubleRoom2, queenRoom2};
		rooms[0].changeAvailability();
		for(int i = 0; i<rooms.length; i++) 
			assertEquals(rooms[3], Room.findAvailableRoom(rooms, "King"));		
	}
	@Test
	void findAvailableDoubleRoom_WhenTypeMatched_DoubleRoom1Available() {
		Room kingRoom1 = new Room("king");
		Room kingRoom2 = new Room("king");
		Room doubleRoom1 = new Room("double");
		Room doubleRoom2 = new Room("double");
		Room queenRoom1 = new Room("queen");
		Room queenRoom2 = new Room("queen");
		Room[]rooms = {kingRoom1, doubleRoom1, queenRoom1, kingRoom2, doubleRoom2, queenRoom2};

		for(int i = 0; i<rooms.length; i++) 
				assertEquals(rooms[1], Room.findAvailableRoom(rooms, "DOUBLE"));		
		
	}		
	
	@Test
	void findAvailableDoubleRoom_WhenTypeMatched_DoubleRoom1Occupied() {
		Room kingRoom1 = new Room("king");
		Room kingRoom2 = new Room("king");
		Room doubleRoom1 = new Room("double");
		Room doubleRoom2 = new Room("double");
		Room queenRoom1 = new Room("queen");
		Room queenRoom2 = new Room("queen");
		Room[]rooms = {kingRoom1, doubleRoom1, queenRoom1, kingRoom2, doubleRoom2, queenRoom2};
		
		rooms[1].changeAvailability();
		for(int i = 0; i<rooms.length; i++) 
				assertEquals(rooms[4], Room.findAvailableRoom(rooms, "double"));	
	}
	
	
	@Test
	void findAvailableQueenRoom_WhenTypeMatched_QueenRoom1Available() {
		Room kingRoom1 = new Room("king");
		Room kingRoom2 = new Room("king");
		Room doubleRoom1 = new Room("double");
		Room doubleRoom2 = new Room("double");
		Room queenRoom1 = new Room("queen");
		Room queenRoom2 = new Room("queen");
		Room[]rooms = {kingRoom1, doubleRoom1, queenRoom1, kingRoom2, doubleRoom2, queenRoom2};
	
		for(int i = 0; i<rooms.length; i++) 
				assertEquals(rooms[2], Room.findAvailableRoom(rooms, "queen"));		
	}
	
	@Test
	void findAvailableQueenRoom_WhenTypeMatched_QueenRoom1Occupied() {
		Room kingRoom1 = new Room("king");
		Room kingRoom2 = new Room("king");
		Room doubleRoom1 = new Room("double");
		Room doubleRoom2 = new Room("double");
		Room queenRoom1 = new Room("queen");
		Room queenRoom2 = new Room("queen");
		Room[]rooms = {kingRoom1, doubleRoom1, queenRoom1, kingRoom2, doubleRoom2, queenRoom2};
		rooms[2].changeAvailability();
		for(int i = 0; i<rooms.length; i++) 
				assertEquals(rooms[5], Room.findAvailableRoom(rooms, "queen"));			
	}
}


	



