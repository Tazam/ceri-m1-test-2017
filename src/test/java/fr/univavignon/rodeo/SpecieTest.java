package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.imp.Animal;
import fr.univavignon.rodeo.imp.Specie;

public class SpecieTest extends ISpecieTest{
	public ISpecie getTestInstance2()
	{
		List<IAnimal> animals= new ArrayList<IAnimal>();
		animals.add(new Animal("aTest1",3,true,true,true));
		animals.add(new Animal("aTest2",3,true,true,true));
		animals.add(new Animal("aTest3",3,true,true,true));
		
		return new Specie("t",3,animals);
	}
	
	protected ArrayList<Specie> getTestInstance3()
	{
		List<IAnimal> animals= new ArrayList<IAnimal>();
		animals.add(new Animal("aTest1",3,true,true,true));
		animals.add(new Animal("aTest2",3,true,true,true));
		animals.add(new Animal("aTest3",3,true,true,true));
		
		ArrayList<Specie> l = new ArrayList<Specie>();
		l.add(new Specie("sp1",3,animals));
		l.add(new Specie("sp1",3,animals));
		l.add(new Specie("sp2",3,animals));
		
		return l;
	}
	
	@Test
	public void testEquals()
	{
		ArrayList<Specie> asp = getTestInstance3();
		assertEquals(true,asp.get(0).equals(asp.get(0)));
		assertEquals(true,asp.get(0).equals(asp.get(1)));
		assertEquals(false,asp.get(0).equals(asp.get(2)));
	}
	
	@Test
	public void testContainsAnimal()
	{
		ArrayList<Specie> asp = getTestInstance3();
		assertEquals(true,asp.get(0).containsAnimal("aTest1"));
		assertEquals(false,asp.get(0).containsAnimal("p"));
	}
}
