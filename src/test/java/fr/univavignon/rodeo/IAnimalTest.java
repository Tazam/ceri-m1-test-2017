package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.IAnimal;

public class IAnimalTest {
	
	protected static IAnimal getTestInstance()
	{
		IAnimal animalMock = Mockito.mock(IAnimal.class);
		Mockito.when(animalMock.getXP()).thenReturn(3);
		Mockito.when(animalMock.isBoss()).thenReturn(true);
		Mockito.when(animalMock.isEndangered()).thenReturn(true);
		Mockito.when(animalMock.isSecret()).thenReturn(true);
		
		return animalMock;
	}
	
	protected IAnimal getTestInstance2()
	{
		return getTestInstance();
	}
	
	@Test
	public void testXp()
	{
		final IAnimal animal = getTestInstance2();
		assertEquals(3,animal.getXP());
	}
	
	@Test public void testIsBoss()
	{
		final IAnimal animal = getTestInstance2();
		assertEquals(true,animal.isBoss());
	}
	
	@Test public void testIsEndangered()
	{
		final IAnimal animal = getTestInstance2();
		assertEquals(true,animal.isEndangered());
	}
	
	@Test public void testIsSecret()
	{
		final IAnimal animal = getTestInstance2();
		assertEquals(true,animal.isSecret());
	}
	
	

}
