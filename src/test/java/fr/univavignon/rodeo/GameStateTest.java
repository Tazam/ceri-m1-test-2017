/**
 * 
 */
package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.SpecieLevel;
import fr.univavignon.rodeo.imp.Animal;
import fr.univavignon.rodeo.imp.GameState;
import fr.univavignon.rodeo.imp.Specie;

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
	
	@Test
	public void doubleCatchTest()
	{
		GameState gs = getTestInstance2();
		gs.catchAnimal(new Animal("a1",0,false,false,true));
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
	
	@Test
	public void specieLevelNoviceTest()
	{
		GameState gs = getTestInstance2();
		List<IAnimal> animals= new ArrayList<IAnimal>();
		animals.add(new Animal("a1",24,true,true,true));
		animals.add(new Animal("a2",100,true,true,true));
		animals.add(new Animal("a3",500,true,true,true));
		Specie sp = new Specie("s1",3,animals);
		gs.catchAnimal(new Animal("a1",24,false,false,true));
		gs.exploreArea();
		assertEquals(SpecieLevel.NOVICE,gs.getSpecieLevel(sp));
		gs.catchAnimal(new Animal("a2",100,true,true,true));
		assertEquals(SpecieLevel.WRANGLER,gs.getSpecieLevel(sp));
		gs.exploreArea();
		gs.catchAnimal(new Animal("a3",500,true,true,true));
		assertEquals(SpecieLevel.MASTER,gs.getSpecieLevel(sp));
		
		
	}

}
