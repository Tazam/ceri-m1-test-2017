package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.IGameStateProvider;

public class IGameStateProviderTest {
	
	protected static IGameStateProvider getTestInstance()
	{
		IGameStateProvider gameStateProvider = Mockito.mock(IGameStateProvider.class);
		Mockito.when(gameStateProvider.get("n1")).thenReturn(IGameStateTest.getTestInstance());
		
		
		return gameStateProvider;
	}
	
	@Test
	public void testGet()
	{
		final IGameStateProvider gameStateProvider = getTestInstance();
		assertEquals(IGameState.class,gameStateProvider.get("n1"));
	}

}
