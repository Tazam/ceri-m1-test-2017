package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;


import fr.univavignon.rodeo.api.IGameState;


public class IGameStateTest {
	
	protected static IGameState getTestInstance()
	{
		IGameState gameState = Mockito.mock(IGameState.class);
		
		Mockito.when(gameState.getProgression()).thenReturn(0);
		Mockito.when(gameState.getSpecieLevel(null)).thenThrow(new java.lang.IllegalArgumentException());
		//Mockito.when(gameState.getSpecieLevel(ISpecieTest.getTestInstance())).thenReturn(SpecieLevel.CHAMPION);
		
		
		return gameState;
	}
	
	protected  IGameState getTestInstance2()
	{
		return getTestInstance();
	}
	
	@Test
	public void testGetProgression()
	{
		final IGameState gameState = getTestInstance2();
		assertEquals(0,gameState.getProgression());
	}
	
	@Test(expected =  java.lang.IllegalArgumentException.class)
	public void testGetSpecieLevelNull()
	{
		final IGameState gameStateMock = getTestInstance2();
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
