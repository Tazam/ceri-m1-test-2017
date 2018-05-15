package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.imp.Animal;

public class AnimalTest extends IAnimalTest{
	
	public IAnimal getTestInstance2()
	{
		Animal a = new Animal("aTest",3,true,true,true);
		return a;
	}
	
	public Animal getTestInstance3()
	{
		Animal a = new Animal("aTest",3,true,true,true);
		return a;
	}
	
	@Test
	public void testContainsAnimals()
	{
		final Animal a1 = getTestInstance3();
		final Animal a2 = getTestInstance3();
		assertEquals(true,a1.equals(a2));
	}


}
