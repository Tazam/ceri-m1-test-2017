/**
 * 
 */
package fr.univavignon.rodeo;

import fr.univavignon.rodeo.api.IEnvironmentProvider;
import fr.univavignon.rodeo.imp.EnvironmentProvider;

/**
 * @author Schmidt Ga�tan
 *
 */
public class EnvironmentProviderTest extends IEnvironmentProviderTest {

	public IEnvironmentProvider getTestInstance2()
	{
		IEnvironmentProvider eRet = new EnvironmentProvider("testAnimals.csv");
		return eRet;
	}
}
