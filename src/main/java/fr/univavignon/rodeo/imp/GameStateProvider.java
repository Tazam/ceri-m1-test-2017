/**
 * 
 */
package fr.univavignon.rodeo.imp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.IGameStateProvider;

/**
 * @author Schmidt Gaëtan
 *
 */
public class GameStateProvider implements IGameStateProvider {
	
	private IGameState game;
	
	public GameStateProvider(String name, String dataPath)
	{
		this.game = new GameState(name,dataPath);
	}
	
	public GameStateProvider()
	{
		this.game = null;
	}

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
		
		if (name.equals(this.game.getName()))
			{
				return this.game;
			}
		return null;
	}

}
