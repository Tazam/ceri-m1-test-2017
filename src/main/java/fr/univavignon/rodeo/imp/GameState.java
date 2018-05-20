/**
 * 
 */
package fr.univavignon.rodeo.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.IEnvironmentProvider;
import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.api.SpecieLevel;

/**
 * @author Schmidt Gaëtan
 *
 */
public class GameState implements IGameState {
	
	private String name;
	private int xp;
	private Map<IAnimal,Integer> cage;
	private IEnvironmentProvider world;
	private int areaCurrent;
	
	public GameState(String name, String dataPath)
	{
		this.xp = 0;
		this.name = name;
		this.world = new EnvironmentProvider(dataPath);
		this.cage = new HashMap<IAnimal,Integer>();
		this.areaCurrent = 1;
	}

	/* (non-Javadoc)
	 * @see fr.univavignon.rodeo.api.INamedObject#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see fr.univavignon.rodeo.api.IGameState#exploreArea()
	 */
	@Override
	public void exploreArea() throws IllegalStateException {

		for (String s : this.world.getAvailableEnvironments()) 
		{
			for (ISpecie specie : this.world.getEnvironment(s).getSpecies())
			{
				if (specie.getArea()==this.areaCurrent)
				{
					for (IAnimal a : specie.getAnimals())
					{
						if (this.cage.size()==0)
							{
							
								throw new IllegalStateException();
							}
					}
				}
			}
		}
		this.areaCurrent+=1;
	}

	/* (non-Javadoc)
	 * @see fr.univavignon.rodeo.api.IGameState#catchAnimal(fr.univavignon.rodeo.api.IAnimal)
	 */
	@Override
	public void catchAnimal(IAnimal animal) throws IllegalArgumentException, IllegalStateException {
		if (animal == null)
			throw new IllegalArgumentException();
		
		if (this.cage.containsKey(animal))
		{
			Integer nb = this.cage.get(animal);
			this.cage.put(animal, nb+1);
			return;
		}
		
		for (String s : this.world.getAvailableEnvironments()) 
		{
			for (ISpecie specie : this.world.getEnvironment(s).getSpecies())
			{
				if (specie.getArea()==this.areaCurrent&&specie.getAnimals().contains(animal))
				{
					this.cage.put(animal, 1);
					return;
				}
			}
		}
		throw new IllegalStateException();
	}

	/* (non-Javadoc)
	 * @see fr.univavignon.rodeo.api.IGameState#getSpecieLevel(fr.univavignon.rodeo.api.ISpecie)
	 */
	@Override
	public SpecieLevel getSpecieLevel(ISpecie specie) throws IllegalArgumentException {
		if (specie==null)
			throw new IllegalArgumentException();
		int ret = 0;
		for (IAnimal a : specie.getAnimals())
		{
			if (this.cage.containsKey(a))
				ret+=a.getXP();
		}
		return SpecieLevel.CHAMPION;
	}

	/* (non-Javadoc)
	 * @see fr.univavignon.rodeo.api.IGameState#getProgression()
	 */
	@Override
	public int getProgression() {
		int total = 0;
		for (String s : this.world.getAvailableEnvironments()) 
		{
			for (ISpecie specie : this.world.getEnvironment(s).getSpecies())
			{
				total+=specie.getAnimals().size();
			}
		}
		return (this.cage.size()*100)/total;
	}

}
