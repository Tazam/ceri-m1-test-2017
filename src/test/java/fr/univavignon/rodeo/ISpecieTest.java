package fr.univavignon.rodeo;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.ISpecie;

public class ISpecieTest {
	
	protected static ISpecie getTestInstance()
	{
		List<IAnimal> animals= new ArrayList<IAnimal>();
		animals.add(IAnimalTest.getTestInstance());
		animals.add(IAnimalTest.getTestInstance());
		animals.add(IAnimalTest.getTestInstance());
		
		ISpecie specieMock = Mockito.mock(ISpecie.class);
		
		Mockito.when(specieMock.getArea()).thenReturn(3);
		Mockito.when(specieMock.getAnimals()).thenReturn(animals);
		
		return specieMock;
	}
	
	@Test
	public void testGetArea()
	{
		final ISpecie specie = getTestInstance();
		assertEquals(3,specie.getArea());
	}
	
	@Test
	public void testGetAnimals()
	{
		final ISpecie specie = getTestInstance();
		assertEquals(3,specie.getAnimals().size());
	}
	
}
