/**
 * 
 */
package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univavignon.rodeo.imp.Animal;
import fr.univavignon.rodeo.imp.GameState;

/**
 * @author Schmidt Gaëtan
 *
 */
public class GameStateTest extends IGameStateTest {
	
	public GameState getTestInstance2()
	{
		GameState ret = new GameState("test","testAnimals.csv");
		
		return ret;
	}
	
	@Test(expected =  java.lang.IllegalArgumentException.class)
	public void catchErrorNullTest()
	{
		GameState gs = getTestInstance2();
		gs.catchAnimal(null);
	}
	
	@Test(expected = java.lang.IllegalStateException.class)
	public void catchErrorTest()
	{
		GameState gs = getTestInstance2();
		gs.catchAnimal(new Animal("a2",0,false,false,true));
	}
	
	@Test
	public void catchTest()
	{
		GameState gs = getTestInstance2();
		gs.catchAnimal(new Animal("a1",0,false,false,true));
		assertEquals(33,gs.getProgression());
	}
	
	@Test(expected = java.lang.IllegalStateException.class)
	public void exploreAreaErrorTest()
	{
		GameState gs = getTestInstance2();
		gs.exploreArea();
	}
	
	@Test
	public void exploreAreaTest()
	{
		GameState gs = getTestInstance2();
		gs.catchAnimal(new Animal("a1",0,false,false,true));
		gs.exploreArea();
		gs.catchAnimal(new Animal("a2",0,false,false,true));
		assertEquals(66,gs.getProgression());
	}

}
