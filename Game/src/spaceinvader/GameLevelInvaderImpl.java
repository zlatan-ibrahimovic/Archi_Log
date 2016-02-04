package spaceinvader;

import java.util.ArrayList;
import java.util.Iterator;

import gameframework.game.Game;
import gameframework.game.GameEntity;
import gameframework.game.GameLevelDefaultImpl;
import gameframework.game.GameUniverse;
import spaceinvader.entity.Invader;

public abstract class GameLevelInvaderImpl extends GameLevelDefaultImpl {

	

	public GameLevelInvaderImpl(Game g) {
		super(g);
		// TODO Auto-generated constructor stub
	}

	public GameUniverse getUniverse(){
		return universe;
	}

	public void setUniverse(GameUniverse universe) {
		this.universe = universe;
		
	}

	public synchronized void setUniverse(ArrayList<GameEntity> itUniverse) {
		Iterator<GameEntity> it = universe.gameEntities();
		   while(it.hasNext()){
			   GameEntity entity = it.next();
			   if(entity instanceof Invader){
			   universe.removeGameEntity(entity);
			   }
		   }
		   
		   Iterator<GameEntity> it2 = itUniverse.iterator();
	       while( it2.hasNext()){
	    	   GameEntity entity2 = it2.next();
	    	   if(entity2 instanceof Invader){
	    	   universe.addGameEntity(entity2);
	    	   }
	       }
	}
}
