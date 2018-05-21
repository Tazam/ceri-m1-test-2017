/**
 * 
 */
package fr.univavignon.rodeo.imp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.IGameStateProvider;

/**
 * @author Schmidt Gaëtan
 *
 */
public class GameStateProvider implements IGameStateProvider {
	

	/* (non-Javadoc)
	 * @see fr.univavignon.rodeo.api.IGameStateProvider#save(fr.univavignon.rodeo.api.IGameState)
	 */
	@Override
	public void save(IGameState gameState) {
		FileWriter fw;
		try {
			fw = new FileWriter(gameState.getName()+".save");
			BufferedWriter buffer = new BufferedWriter(fw);
			buffer.write(gameState.toString());
			buffer.flush();
			buffer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	/* (non-Javadoc)
	 * @see fr.univavignon.rodeo.api.IGameStateProvider#get(java.lang.String)
	 */
	@Override
	public IGameState get(String name) throws IllegalArgumentException {
		if (name==null)
			throw new IllegalArgumentException();
		
		if(Files.exists(Paths.get(name+".save"))) { 
			File file = new File(name+".save");
			Map<String,Integer> cage = new HashMap<String,Integer>();
			String name2="";
			int areaCurrent=0;
			String initPath="";
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder;
			try {
				builder = factory.newDocumentBuilder();
				Document doc = builder.parse(file);
				NodeList entities = doc.getElementsByTagName("gameSave");
				for(int i = 0; i < entities.getLength(); i ++)
				{
					if (entities.item(i).getNodeType() == Node.ELEMENT_NODE)
					{
						Element entity = (Element) entities.item(i);
			    		NodeList infos = entity.getElementsByTagName("basicInfo");
			    		for(int j = 0; j < infos.getLength(); j ++)
			    		{
			    			if(infos.item(j).getNodeType() == Node.ELEMENT_NODE)
			    			{
			    				Element info = (Element) infos.item(j);
			    				name2 = info.getElementsByTagName("name").item(0).getTextContent();
			    				initPath = info.getElementsByTagName("path").item(0).getTextContent();
			    				areaCurrent = Integer.parseInt(info.getElementsByTagName("areaCurrent").item(0).getTextContent());
			    			}
			    		}
			    		
			    		NodeList animals = entity.getElementsByTagName("animal");
			    		for(int j = 0; j < animals.getLength(); j ++)
			    		{
			    			if(animals.item(j).getNodeType() == Node.ELEMENT_NODE)
			    			{
			    				Element animal = (Element) animals.item(j);
			    				cage.put(animal.getElementsByTagName("name").item(0).getTextContent(), Integer.parseInt(animal.getElementsByTagName("int").item(0).getTextContent()));
			    			}
			    		}
					}
				}
				if (!"".equals(name)&&!"".equals(initPath)&&areaCurrent!=0)
				{
					return new GameState(name2,cage,areaCurrent,initPath);
				}
				
			} catch (ParserConfigurationException e) {
				
				e.printStackTrace();
				return new GameState("patate","ListAnimals.csv");
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
			
		}
		
		return new GameState("patate","ListAnimals.csv");
	}

}
