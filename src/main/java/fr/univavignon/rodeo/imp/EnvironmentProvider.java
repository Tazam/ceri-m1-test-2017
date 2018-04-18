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
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EnvironmentProvider implements IEnvironmentProvider {
	
	private List<String> availableEnvironments;
	private Map<String,Environment> data;
	
	private String pathDataCSV;
	
	public EnvironmentProvider()
	{
		this.availableEnvironments = new ArrayList<String>();
		this.data = new HashMap<String,Environment>();
		this.pathDataCSV = "";
		try {
			loader();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public List<String> getAvailableEnvironments() {
		return this.availableEnvironments;
	}

	public IEnvironment getEnvironment(String name)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void loader() throws IOException
	{
		try (
	            Reader reader = Files.newBufferedReader(Paths.get(pathDataCSV));
	            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
	                    .withHeader("Animal", "Species", "Class", "Unlocked", "XP Given")
	                    .withIgnoreHeaderCase()
	                    .withTrim());
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
	
	private void addAnimal(String animal, String specie, String aClass, String Unlocked, String xp)
	{
		if (this.data == null)
			return;
		if (data.containsValue(Unlocked))
		{
			//if (data.get(Unlocked).getSpecies().contains(o))
		}else
		{
			
		}
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
