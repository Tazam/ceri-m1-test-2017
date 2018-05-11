package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;


import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.ISpecie;

public class IEnvironmentTest {
	
	protected static IEnvironment getTestInstance()
	{
		List<ISpecie> species= new ArrayList<ISpecie>();
		species.add(ISpecieTest.getTestInstance());
		species.add(ISpecieTest.getTestInstance());
		species.add(ISpecieTest.getTestInstance());
		
		IEnvironment environmentMock = Mockito.mock(IEnvironment.class);
		
		Mockito.when(environmentMock.getAreas()).thenReturn(3);
		Mockito.when(environmentMock.getSpecies()).thenReturn(species);
		
		return environmentMock;
	}
	
	protected IEnvironment getTestInstance2()
	{
		return getTestInstance();
	}
	
	@Test public void testGetArea()
	{
		final IEnvironment environment = getTestInstance2();
		assertEquals(3,environment.getAreas());
	}
	
	@Test public void testGetSpecies()
	{
		final IEnvironment environment = getTestInstance2();
		assertEquals(3,environment.getSpecies().size());
	}

}
