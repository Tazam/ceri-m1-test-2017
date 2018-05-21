package fr.univavignon.rodeo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.IGameStateProvider;

public class IGameStateProviderTest {
	
	protected static IGameStateProvider getTestInstance()
	{
		final IGameState gameState = IGameStateTest.getTestInstance();
		IGameStateProvider gameStateProvider = Mockito.mock(IGameStateProvider.class);
		Mockito.when(gameStateProvider.get("n1")).thenReturn(gameState);
		
		
		return gameStateProvider;
	}
	
	protected IGameStateProvider getTestInstance2()
	{
		return getTestInstance();
	}
	
	@Test
	public void testGet()
	{
		final IGameStateProvider gameStateProviderMock = getTestInstance2();
		//assertEquals(IGameState.class,gameStateProvider.get("n1"));
		assertTrue(gameStateProviderMock.get("n1") instanceof IGameState);
	}

}
