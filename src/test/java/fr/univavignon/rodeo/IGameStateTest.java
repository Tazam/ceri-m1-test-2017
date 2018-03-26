package fr.univavignon.rodeo;

import org.mockito.Mockito;

import fr.univavignon.rodeo.api.IGameState;

public class IGameStateTest {
	
	protected static IGameState getTestInstance()
	{
		IGameState gameState = Mockito.mock(IGameState.class);
		
		Mockito.when(gameState.getProgression()).thenReturn(3);
		
		
		return gameState;
	}
}
