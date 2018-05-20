/**
 * 
 */
package fr.univavignon.rodeo.imp;

import fr.univavignon.rodeo.api.IAnimal;

/**
 * @author uapv1301258
 *
 */
public class Animal implements IAnimal {
	
	private String name;
	private int xp;
	private boolean secret;
	private boolean endangered;
	private boolean boss;
	
	public Animal(String name,int xp,boolean secret,boolean endangered,boolean boss)
	{
		this.name = name;
		this.xp = xp;
		this.secret = secret;
		this.endangered = endangered;
		this.boss = boss;
	}

	/* (non-Javadoc)
	 * @see fr.univavignon.rodeo.api.INamedObject#getName()
	 */
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see fr.univavignon.rodeo.api.IAnimal#getXP()
	 */
	public int getXP() {
		return this.xp;
	}

	/* (non-Javadoc)
	 * @see fr.univavignon.rodeo.api.IAnimal#isSecret()
	 */
	public boolean isSecret() {
		return this.secret;
	}

	/* (non-Javadoc)
	 * @see fr.univavignon.rodeo.api.IAnimal#isEndangered()
	 */
	public boolean isEndangered() {
		return this.endangered;
	}

	/* (non-Javadoc)
	 * @see fr.univavignon.rodeo.api.IAnimal#isBoss()
	 */
	public boolean isBoss() {
		return this.boss;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof Animal))
			return false;
		Animal a = (Animal) o;
		
		return a.name.equals(this.name);
	}
	
	public String toString()
	{
		return this.name;
	}

}
