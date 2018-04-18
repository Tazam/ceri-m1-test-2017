package fr.univavignon.rodeo;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.imp.Animal;

public class AnimalTest extends IAnimalTest{
	
	public IAnimal getTestInstance2()
	{
		Animal a = new Animal("aTest",3,true,true,true);
		return a;
	}

}
