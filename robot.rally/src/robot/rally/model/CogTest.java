package robot.rally.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CogTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testActivate()
	{
		Cog cog = new Cog(1,1,Rotation.CLOCKWISE);
		Robot robot = new Robot(1, 1);	
		Board board = new Board(1, 1);
		cog.activate(board, 1, 1, robot);
		assertEquals(Direction.EAST, robot.checkHeading());
	}



}
