package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.imp.Animal;

public class AnimalTest extends IAnimalTest{
	
	public IAnimal getTestInstance2()
	{
		Animal a = new Animal("aTest",3,true,true,true);
		return a;
	}
	
	public ArrayList<Animal> getTestInstance3()
	{
		Animal a = new Animal("aTest",3,true,true,true);
		Animal a2 = new Animal("aTest2",2,false,true,false);
		Animal a3 = new Animal("aTest",3,true,true,true);
		
		ArrayList<Animal> ret = new ArrayList<Animal>();
		ret.add(a);
		ret.add(a2);
		ret.add(a3);
		return ret;
	}
	
	@Test
	public void testContainsAnimals()
	{
		final ArrayList<Animal> l = getTestInstance3();
		assertEquals(true,l.get(0).equals(l.get(0)));
		assertEquals(true,l.get(0).equals(l.get(2)));
		assertEquals(false,l.get(0).equals(l.get(1)));
		
	}


}
