/**
 * 
 */
package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univavignon.rodeo.api.IEnvironmentProvider;
import fr.univavignon.rodeo.imp.EnvironmentProvider;

/**
 * @author Schmidt Gaëtan
 *
 */
public class EnvironmentProviderTest extends IEnvironmentProviderTest {

	public IEnvironmentProvider getTestInstance2()
	{
		IEnvironmentProvider eRet = new EnvironmentProvider("testAnimals.csv");
		return eRet;
	}
	
	public EnvironmentProvider getTestInstance3()
	{
		EnvironmentProvider eRet = new EnvironmentProvider("testAnimals.csv");
		return eRet;
	}
	
	public EnvironmentProvider getTestInstance4()
	{
		EnvironmentProvider eRet = new EnvironmentProvider("noFile.csv");
		return eRet;
	}
	
	public EnvironmentProvider getTestInstance5()
	{
		EnvironmentProvider eRet = new EnvironmentProvider();
		return eRet;
	}
	
	@Test(expected =  java.io.IOException.class)
	public void testEnvironmentProvierConstructeur1()
	{
		EnvironmentProvider epr = getTestInstance4();
		epr.toString();
	}
	
	@Test(expected =  java.io.IOException.class)
	public void testEnvironmentProvierConstructeur2()
	{
		EnvironmentProvider epr = getTestInstance5();
		epr.toString();
	}
	
	@Test
	public void testAddAnimals()
	{
		EnvironmentProvider epr = getTestInstance3();
		epr.addAnimal("Lion", "Lion", "Base", "Jungle 8", "0");
		assertEquals(4,epr.getAvailableEnvironments().size());
	}
}
