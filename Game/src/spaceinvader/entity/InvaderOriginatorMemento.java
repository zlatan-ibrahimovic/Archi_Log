package spaceinvader.entity;

import java.util.Iterator;

import gameframework.game.GameEntity;
import gameframework.game.GameUniverse;

public class InvaderOriginatorMemento {
	private GameUniverse state;
	   
	   public void set(GameUniverse state) { 
	       this.state = state; 
	   }

	   public synchronized InvaderMemento saveToMemento() { 
	       System.out.println("Originator: Saving to Memento.");
	       return new InvaderMemento(state); 
	   }
	   public synchronized void restoreFromMemento(InvaderMemento m) {
		   /*Iterator<GameEntity> it = state.gameEntities();
		   while(it.hasNext()){
			   GameEntity entity = it.next();
			   if(entity instanceof Invader){
				   state.removeGameEntity(it.next());
			   }
		   }*/
		   Iterator<GameEntity> it2 = m.getSavedState().iterator();
	       while( it2.hasNext()){
	    	   GameEntity entity2 = it2.next();
	    	   if(entity2 instanceof Invader){
	    		   state.addGameEntity(entity2);
	    	   }
	       }
	       System.out.println("Originator: State after restoring from Memento: "+state);
	   }
}
