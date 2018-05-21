/**
 * 
 */
package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import fr.univavignon.rodeo.imp.Animal;
import fr.univavignon.rodeo.imp.GameState;
import fr.univavignon.rodeo.imp.GameStateProvider;

/**
 * @author Schmidt Gaëtan
 *
 */
public class GameStateProviderTest extends IGameStateProviderTest{
	
	public GameStateProvider getTestInstance2()
	{
		GameStateProvider ret = new GameStateProvider();
		return ret;
	}
	
	
	@Test
	public void constructeurTest()
	{
		GameStateProvider gsp = getTestInstance2();
		assertTrue(gsp instanceof GameStateProvider);
	}
	
	@Test
	public void saveTest()
	{
		GameStateProvider gsp = getTestInstance2();
		GameState gameState = new GameState("n1","testAnimals.csv");
		gameState.catchAnimal(new Animal("a1",0,false,false,true));
		gsp.save(gameState);
		File file = new File("n1.save");
		assertTrue(file.exists());
	}
	
	@Test
	public void getTest()
	{
		GameState gameState = new GameState("n1","testAnimals.csv");
		GameStateProvider gsp = getTestInstance2();
		gsp.save(gameState);
		assertEquals("n1",gsp.get("n1").getName());
	}
	
	@Test(expected =  java.lang.IllegalArgumentException.class)
	public void errorNullGetTest()
	{
		GameStateProvider gsp = getTestInstance2();
		gsp.get(null);
	}

}
