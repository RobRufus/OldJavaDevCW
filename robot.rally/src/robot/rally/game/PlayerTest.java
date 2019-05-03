package robot.rally.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import robot.rally.model.Flag;

public class PlayerTest {

	Player player;
	
	@Before
	public void setUp() throws Exception 
	{
		player = new Player(1, 1, 1, "Greg");
	}

	@Test
	public void testCheckFlag() 
	{
		Flag flag = new Flag(1, 1, 1);
		player.checkFlag(flag.getFlagID());
		assertEquals(2,player.flagTracker);
	}

	@Test
	public void testSetPlayerName() 
	{
		
		player.setPlayerName("Dave");
		assertEquals("Dave", player.playerName);
	}

}
