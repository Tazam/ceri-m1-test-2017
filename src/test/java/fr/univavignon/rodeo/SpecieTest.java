package fr.univavignon.rodeo;

import java.util.ArrayList;
import java.util.List;

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
}
