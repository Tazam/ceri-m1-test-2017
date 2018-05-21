/**
 * 
 */
package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import fr.univavignon.rodeo.imp.GameState;
import fr.univavignon.rodeo.imp.GameStateProvider;

/**
 * @author Schmidt Gaëtan
 *
 */
public class GameStateProviderTest extends IGameStateProviderTest{
	
	public GameStateProvider getTestInstance2()
	{
		GameStateProvider ret = new GameStateProvider("n1","testAnimals.csv");
		return ret;
	}
	
	
	@Test
	public void constructeurTest()
	{
		GameStateProvider gsp = getTestInstance2();
		assertTrue(gsp instanceof GameStateProvider);
	}
	
	@Test
	public void getTest()
	{
		GameStateProvider gsp = getTestInstance2();
		assertEquals("n1",gsp.get("n1").getName());
	}
	
	@Test
	public void saveTest()
	{
		GameStateProvider gsp = getTestInstance2();
		GameState gameState = new GameState("n1","testAnimals.csv");
		gsp.save(gameState);
		File file = new File("n1.save");
		assertTrue(file.exists());
		
	}

}
