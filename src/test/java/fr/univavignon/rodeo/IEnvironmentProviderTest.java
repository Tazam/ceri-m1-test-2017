package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.IEnvironmentProvider;

public class IEnvironmentProviderTest {
	
	protected static IEnvironmentProvider getTestInstance()
	{
		List<String> environmentsNames = new ArrayList<String>();
		environmentsNames.add("e1");
		environmentsNames.add("e2");
		environmentsNames.add("e3");
		
		final IEnvironment environment = IEnvironmentTest.getTestInstance();
		
		IEnvironmentProvider environmentProviderMock = Mockito.mock(IEnvironmentProvider.class);
		
		Mockito.when(environmentProviderMock.getAvailableEnvironments()).thenReturn(environmentsNames);
		//Mockito.when(environmentProviderMock.getEnvironment("e1")).thenReturn((IEnvironment) IEnvironmentTest.getTestInstance().getSpecies().get(0));
		Mockito.when(environmentProviderMock.getEnvironment(null)).thenThrow(new java.lang.IllegalArgumentException());
		Mockito.when(environmentProviderMock.getEnvironment("e4")).thenReturn(null);
		
		Mockito.when(environmentProviderMock.getEnvironment("e1")).thenReturn(environment);
		
		return environmentProviderMock;
	}
	
	@Test public void testGetAvailableEnvironments()
	{
		final IEnvironmentProvider environmentProviderMock = getTestInstance();
		assertEquals(3,environmentProviderMock.getAvailableEnvironments().size());
		assertEquals("e1",environmentProviderMock.getAvailableEnvironments().get(0));
	}
	
	@Test public void testGetEnvironment()
	{
		final IEnvironmentProvider environmentProviderMock = getTestInstance();
		assertTrue(environmentProviderMock.getEnvironment("e1") instanceof IEnvironment);
		assertEquals(null,environmentProviderMock.getEnvironment("e4"));
		/*try
		{
			environmentProviderMock.getEnvironment(null);
		}catch(Exception e)
		{
			assertEquals(java.lang.IllegalArgumentException.class,e.getClass());
		}*/
	}
	
	@Test(expected =  java.lang.IllegalArgumentException.class)
	public void testGetEnvironmentEx()
	{
		final IEnvironmentProvider environmentProviderMock = getTestInstance();
		environmentProviderMock.getEnvironment(null);
	}

}
