package fr.univavignon.rodeo.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.IEnvironmentProvider;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EnvironmentProvider implements IEnvironmentProvider {
	
	private List<String> availableEnvironments;
	private Map<String,Environment> data;
	
	private String pathDataCSV;
	public boolean fail;
	
	public EnvironmentProvider(String str)
	{
		this.availableEnvironments = new ArrayList<String>();
		this.data = new HashMap<String,Environment>();
		this.pathDataCSV = str;
		this.fail = false;
		try {
			loader();
		} catch (IOException e) {
			this.availableEnvironments = null;
			this.data = null;
			this.pathDataCSV = null;
			this.fail = true;
			e.printStackTrace();
		}
	}
	

	public List<String> getAvailableEnvironments() {
		return this.availableEnvironments;
	}

	public IEnvironment getEnvironment(String name){
		
		if (name == null)
			throw new IllegalArgumentException();
		
		return this.data.get(name);
	}
	
	private void loader() throws IOException
	{
		try (
	            Reader reader = Files.newBufferedReader(Paths.get(pathDataCSV));
	            CSVParser csvParser = new CSVParser(reader, CSVFormat.EXCEL.withHeader());
	        ) {
	            for (CSVRecord csvRecord : csvParser) {
	                // Accessing values by the names assigned to each column
	                String animal = csvRecord.get("Animal");
	                String specie = csvRecord.get("Species");
	                String aClass = csvRecord.get("Class");
	                String Unlocked = csvRecord.get("Unlocked");
	                String xp = csvRecord.get("XP Given");
	                
	                addAnimal(animal, specie, aClass, Unlocked, xp);
	            }
	        }
	}
	
	public void addAnimal(String animal, String specie, String aClass, String Unlocked, String xp)
	{

		
		// si l'environement n'éxiste pas on le crée.
		if (!data.containsKey(cleanUnlocked("NAME",Unlocked)))
			{
				this.data.put(cleanUnlocked("NAME",Unlocked), new Environment(cleanUnlocked("NAME",Unlocked),0,null));
				this.availableEnvironments.add(cleanUnlocked("NAME",Unlocked));
			}

		// si l'environement ne contient pas encore l'espece de l'animal courant, on l'ajoute.
		if (!this.data.get(cleanUnlocked("NAME",Unlocked)).containsSpecie(specie))
			{
				this.data.get(cleanUnlocked("NAME",Unlocked)).addSpecie(new Specie(specie,Integer.parseInt(cleanUnlocked("INT",Unlocked)),null));
				if (Integer.parseInt(cleanUnlocked("INT",Unlocked))>this.data.get(cleanUnlocked("NAME",Unlocked)).getAreas())
						this.data.get(cleanUnlocked("NAME",Unlocked)).autoSetAreas();
			}
		
		// si l'espece ne contient pas l'animal courant on l'ajoute
		if ((this.data.get(cleanUnlocked("NAME",Unlocked)).getSpecie(specie)!=null)&&(!this.data.get(cleanUnlocked("NAME",Unlocked)).getSpecie(specie).containsAnimal(animal)))
		{
			this.data.get(cleanUnlocked("NAME",Unlocked)).getSpecie(specie).addAnimal(new Animal(animal,Integer.parseInt(xp),"Secret".equals(aClass),"Endangered".equals(aClass),"Boss".equals(aClass)));
			//this.data.get(cleanUnlocked("NAME",Unlocked)).getSpecie(specie).addAnimal(new Animal(animal,Integer.parseInt(xp),aClass.equals("Secret"),aClass.equals("Endangered"),aClass.equals("Boss")));
		}
		
	}
	
	/**
	 * 
	 * @param option : if 'NAME' return name of area, if 'INT' return area number
	 * @param raw : String : "NameArea areaNumber"
	 * @return String name or number of area giving on raw
	 * @author Schmidt Gaëtan
	 */
	private String cleanUnlocked(String option, String raw)
	{
		if ("NAME".equals(option))
			return raw.subSequence(0, raw.length()-2).toString();

		return raw.subSequence(raw.length()-1, raw.length()).toString(); 

		
	}
	
	
	/*
	private int xpByType(String tier, String area, String name)
	{
		if (tier == null || area == null)
			return 0;
		switch(tier)
		{
		case "1":
			return 0;
		case "2":
			return 1;
		case "3":
			switch (area)
			{
			case "SAVANNAH":
			case "JUNGLE":
			case "SPACE ZOO":
				return 3;
			case "MOUNTAINS":
			case "OUTBACK":
			case "TUNDRA":
				return 4;
			default:
				return 3;
			}
		case "4":
			switch (area)
			{
			case "MOUNTAINS":
			case "OUTBACK":
			case "TUNDRA":
				return 12;
			case "SAVANNAH":
				return 14;
			case "JUNGLE":
				return 10;
			case "SPACE ZOO":
				return 8;
			default:
				return 8;
			}
		case "5":
			switch(area)
			{
			case "JUNGLE":
			case "MOUNTAINS":
			case "OUTBACK":
				return 25;
			case "SAVANNAH":
			case "TUNDRA":
			case "BOSS":
			case "ENDANGERED":
				return 30;
			case "SPACE ZOO":
				return 30;
			default:
				return 25; 
			}
		case "EVENT":
			return xpEvent(name);
		case "SECRET":
			return xpSecret(name);
			
		}
		return 0;
	}
	
	private int xpSecret(String name)
	{
		return 0;
	}
	
	private int xpEvent(String name)
	{
		return 0;
	}*/

}
