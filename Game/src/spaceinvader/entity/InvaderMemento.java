package spaceinvader.entity;

import java.util.ArrayList;
import java.util.Iterator;

import gameframework.game.GameEntity;
import gameframework.game.GameUniverse;

public class InvaderMemento{
	private ArrayList<GameEntity> state= new ArrayList<>();
	
	   public InvaderMemento(GameUniverse stateToSave) { 
		   Iterator<GameEntity> it = stateToSave.gameEntities();
	       while( it.hasNext()){
	    	   state.add(it.next());
	       }
		     
	   }
	   public synchronized ArrayList<GameEntity> getSavedState() { return state; }
}
