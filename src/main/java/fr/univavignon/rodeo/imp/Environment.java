package fr.univavignon.rodeo.imp;

import java.util.List;

import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.ISpecie;

public class Environment implements IEnvironment {
	
	private String name;
	private int areas;
	private List<ISpecie> species;
	
	public Environment(String name, int areas, List<ISpecie> species)
	{
		this.name = name;
		this.areas = areas;
		this.species = species;
	}

	public String getName() {
		return this.name;
	}

	public int getAreas() {
		return this.areas;
	}

	public List<ISpecie> getSpecies() {
		return this.species;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof Environment))
			return false;
		Environment s = (Environment) o;
		
		return (s.name.equals(this.name)&&(s.areas == this.areas));
	}

}
