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
	
	@Test
	public void testAddAnimals()
	{
		EnvironmentProvider epr = getTestInstance3();
		epr.addAnimal("Lion", "Lion", "Base", "Jungle 8", "0");
		assertEquals(4,epr.getAvailableEnvironments().size());
	}
}
