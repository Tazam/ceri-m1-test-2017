package fr.univavignon.rodeo.imp;

import java.util.ArrayList;
import java.util.List;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.ISpecie;

public class Specie implements ISpecie {
	
	private String name;
	private int area;
	private List<IAnimal> animals;
	
	public Specie(String name, int area, List<IAnimal> animals)
	{
		this.name = name;
		this.area = area;
		if (animals!=null)
		{
			this.animals = animals;
		}else
		{
			this.animals = new ArrayList<IAnimal>();
		}
	}

	public String getName() {
		return this.name;
	}

	public int getArea() {
		return this.area;
	}

	public List<IAnimal> getAnimals() {
		return this.animals;
	}
	
	protected void addAnimal(Animal a)
	{
		this.animals.add(a);
	}
	
	public boolean containsAnimal(String name)
	{
		for (IAnimal a : this.animals)
		{
			if (a.getName().equals(name))
				return true;
		}
		return false;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof Specie))
			return false;
		Specie s = (Specie) o;
		
		return s.name.equals(this.name);
	}
	

}
