/**
 * 
 */
package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.imp.Environment;
import fr.univavignon.rodeo.imp.Specie;

/**
 * @author Schmidt Gaëtan
 *
 */
public class EnvironmentTest extends IEnvironmentTest{
	
	public IEnvironment getTestInstance2()
	{
		List<ISpecie> spList = new ArrayList<ISpecie>();
		spList.add(new Specie("sp1",1,null));
		spList.add(new Specie("sp2",2,null));
		spList.add(new Specie("sp3",3,null));
		Environment e = new Environment("e1",3,spList);
		return e;
	}
	
	public ArrayList<Environment> getTestInstance3()
	{
		List<ISpecie> spList = new ArrayList<ISpecie>();
		spList.add(new Specie("sp1",1,null));
		spList.add(new Specie("sp2",2,null));
		spList.add(new Specie("sp3",3,null));
		ArrayList<Environment> l = new ArrayList<Environment>();
		l.add(new Environment("e1",3,spList));
		l.add(new Environment("e1",3,spList));
		l.add(new Environment("e2",3,spList));
		
		return l;
		
	}
	
	@Test
	public void testEquals()
	{
		ArrayList<Environment> asp = getTestInstance3();
		assertEquals(true,asp.get(0).equals(asp.get(0)));
		assertEquals(true,asp.get(0).equals(asp.get(1)));
		assertEquals(false,asp.get(0).equals(asp.get(2)));
		assertEquals(false,asp.get(0).equals("r"));
	}
	
	@Test
	public void testContainsSpecie()
	{
		ArrayList<Environment> asp = getTestInstance3();
		assertEquals(true,asp.get(0).containsSpecie("sp1"));
		assertEquals(false,asp.get(0).containsSpecie("p"));
	}

}
