package fr.univavignon.rodeo.imp;

import java.util.ArrayList;
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
		if (species!=null)
		{
			this.species = species;
		}else
		{
			this.species = new ArrayList<ISpecie>();
		}
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
	
	protected Specie getSpecie(String name)
	{
		for (ISpecie sp : this.species)
		{
			if (sp.getName().equals(name))
				return (Specie) sp;
		}
		return null;
	}
	
	protected void addSpecie(Specie sp)
	{
		this.species.add(sp);
	}
	
	protected void autoSetAreas()
	{
		int max =0;
		for (ISpecie sp : this.species)
		{
			if (sp.getArea()>max)
				max = sp.getArea();
		}
		this.areas = max;
	}
	
	public boolean containsSpecie(String name)
	{
		for (ISpecie sp : this.species)
		{
			if (sp.getName().equals(name))
				return true;
		}
		return false;
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
