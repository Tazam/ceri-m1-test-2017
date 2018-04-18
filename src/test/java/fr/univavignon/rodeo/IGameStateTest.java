package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;


import fr.univavignon.rodeo.api.IGameState;


public class IGameStateTest {
	
	protected static IGameState getTestInstance()
	{
		IGameState gameState = Mockito.mock(IGameState.class);
		
		Mockito.when(gameState.getProgression()).thenReturn(3);
		Mockito.when(gameState.getSpecieLevel(null)).thenThrow(new java.lang.IllegalArgumentException());
		//Mockito.when(gameState.getSpecieLevel(ISpecieTest.getTestInstance())).thenReturn(SpecieLevel.CHAMPION);
		
		
		return gameState;
	}
	
	@Test
	public void testGetProgression()
	{
		final IGameState gameState = getTestInstance();
		assertEquals(3,gameState.getProgression());
	}
	
	@Test(expected =  java.lang.IllegalArgumentException.class)
	public void testGetSpecieLevelNull()
	{
		final IGameState gameStateMock = getTestInstance();
		gameStateMock.getSpecieLevel(null);
	}
	
	/*
	@Test
	public void testGetSpecieLevel()
	{
		final IGameState gameState = getTestInstance(); 
		ISpecie specie = ISpecieTest.getTestInstance();
		assertEquals(SpecieLevel.CHAMPION,gameState.getSpecieLevel(specie));
	}//*/
}
