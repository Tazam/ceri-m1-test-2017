package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.IEnvironmentProvider;

public class IEnvironementProviderTest {
	
	protected static IEnvironmentProvider getTestInstance()
	{
		List<String> environmentsNames = new ArrayList<String>();
		environmentsNames.add("e1");
		environmentsNames.add("e2");
		environmentsNames.add("e3");
		
		IEnvironmentProvider environmentProviderMock = Mockito.mock(IEnvironmentProvider.class);
		
		Mockito.when(environmentProviderMock.getAvailableEnvironments()).thenReturn(environmentsNames);
		Mockito.when(environmentProviderMock.getEnvironment("e1")).thenReturn((IEnvironment) IEnvironementTest.getTestInstance().getSpecies().get(0));
		Mockito.when(environmentProviderMock.getEnvironment("e4")).thenReturn(null);
		Mockito.when(environmentProviderMock.getEnvironment(null)).thenThrow(new java.lang.IllegalArgumentException());
		
		return environmentProviderMock;
	}
	
	@Test void testGetAvailableEnvironments()
	{
		final IEnvironmentProvider environmentProviderMock = getTestInstance();
		assertEquals(3,environmentProviderMock.getAvailableEnvironments().size());
		assertEquals("e1",environmentProviderMock.getAvailableEnvironments().get(0));
	}
	
	@Test void testGetEnvironment()
	{
		final IEnvironmentProvider environmentProviderMock = getTestInstance();
		assertEquals(IEnvironment.class,environmentProviderMock.getEnvironment("e1").getClass());
		assertEquals(null,environmentProviderMock.getEnvironment("e4"));
		try
		{
			environmentProviderMock.getEnvironment(null);
		}catch(Exception e)
		{
			assertEquals(java.lang.IllegalArgumentException.class,e.getClass());
		}
	}

}
