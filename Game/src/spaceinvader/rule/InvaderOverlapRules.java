package spaceinvader.rule;

import gameframework.base.ObservableValue;
import gameframework.base.Overlap;
import gameframework.game.GameUniverse;
import gameframework.game.OverlapRulesApplierDefaultImpl;
import spaceinvader.entity.Invader;
import spaceinvader.entity.MissileInvader;
import spaceinvader.entity.MissileTank;
import spaceinvader.entity.Tank;
import spaceinvader.entity.Shield;

import java.util.Vector;


public class InvaderOverlapRules extends OverlapRulesApplierDefaultImpl{
	
	protected GameUniverse universe;
	protected Vector<Invader> vInvader = new Vector<Invader>();
	protected Vector<MissileTank> vMissileTank = new Vector<MissileTank>();
	

	private final ObservableValue<Integer> score;
	private final ObservableValue<Integer> life;
	private final ObservableValue<Boolean> endOfGame;
	
	public InvaderOverlapRules( ObservableValue<Integer> life, 
								ObservableValue<Integer> score,
								ObservableValue<Boolean> endOfGame) {
		this.life = life;
		life.setValue(3);
		this.score = score;
		this.endOfGame = endOfGame;
	}
	
	
	@Override
	public void setUniverse(GameUniverse universe) {
		this.universe = universe;
	}

	public void addInvader(Invader i) {
		vInvader.addElement(i);
	}
	
	public void overlapRule(Invader i, MissileTank m) {
		InvaderMovableDriver driv = (InvaderMovableDriver) i.getDriver();
		driv.remove(i);
		if(driv.getInvaders().isEmpty()){
			endOfGame.setValue(true); 
		}
		score.setValue(score.getValue()+10);
		universe.removeGameEntity(i);
		universe.removeGameEntity(m);
		vInvader.remove(i);
	}
	
	public void overlapRule(Shield w, MissileTank m) {
		w.hit();
		if(w.isDestroy()){
			universe.removeGameEntity(w);
		}
		universe.removeGameEntity(m);
	}
	
	public void overlapRule(Shield w, MissileInvader m) {
		w.hit();
		if(w.isDestroy()){
			universe.removeGameEntity(w);
		}
		universe.removeGameEntity(m);
	}
	
	public void overlapRule(Tank k, MissileInvader m) {
		life.setValue(life.getValue()-1);
		universe.removeGameEntity(m);
	}
	
	@Override
	public void applyOverlapRules(Vector<Overlap> overlaps){
		if(invadersWin()){
			life.setValue(0);
		};
		super.applyOverlapRules(overlaps);
	}
	
	private boolean invadersWin(){
		for(Invader i :vInvader){
			if(i.getPosition().getY()>24 *17){
				return true;
			}
		}
		return false;
	}
	
	public GameUniverse getUniverse(){
		return universe;
	}
}
