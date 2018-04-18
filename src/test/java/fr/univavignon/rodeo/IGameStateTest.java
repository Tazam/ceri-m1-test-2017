package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.api.SpecieLevel;

public class IGameStateTest {
	
	protected static IGameState getTestInstance()
	{
		IGameState gameState = Mockito.mock(IGameState.class);
		
		Mockito.when(gameState.getProgression()).thenReturn(3);
		//Mockito.when(gameState.getSpecieLevel(ISpecieTest.getTestInstance())).thenReturn(SpecieLevel.CHAMPION);
		
		return gameState;
	}
	
	@Test
	public void testGetProgression()
	{
		final IGameState gameState = getTestInstance();
		assertEquals(3,gameState.getProgression());
	}
	/*
	@Test
	public void testGetSpecieLevel()
	{
		final IGameState gameState = getTestInstance(); 
		ISpecie specie = ISpecieTest.getTestInstance();
		assertEquals(SpecieLevel.CHAMPION,gameState.getSpecieLevel(specie));
	}*/
}
