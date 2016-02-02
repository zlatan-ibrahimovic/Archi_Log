package spaceinvader.rule;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import gameframework.base.Movable;
import gameframework.base.SpeedVector;
import gameframework.game.GameMovableDriverDefaultImpl;
import gameframework.game.GameUniverse;
import spaceinvader.entity.*;



public class InvaderMovableDriver extends GameMovableDriverDefaultImpl {

	protected int minX ;
	protected int maxX ;
	protected int sizeDownMove ;
	protected int timeDown;
	protected List<Invader> invaders;
	protected GameUniverse gameUniverse;
	
	public InvaderMovableDriver(int minX, int maxX, int sizeDownMove, GameUniverse gameUniverse) {
		this.minX = minX;
		this.maxX = maxX;
		this.sizeDownMove = sizeDownMove;
		this.timeDown= 0;
		invaders = new ArrayList<Invader>();
		this.gameUniverse = gameUniverse;
	}

	@Override
	public SpeedVector getSpeedVector(Movable m) {
		
		SpeedVector sv = m.getSpeedVector();
		
		Invader invaderMaxX = invaderMaxX();
		Invader invaderMinX = invaderMinX();
		
		/*if(Math.random()>0.99){
			((Invader) m).shoot(gameUniverse);
		}*/
		if(m.equals(invaders.get(0))){
			if(invaderMinX.getPosition().getX()<minX && invaderMinX.getSpeedVector().getDirection().getX() == -1){
				timeDown = 0;
				this.setStrategy(new MoveStrategyLine(new Point(0,1)));
				return super.getSpeedVector(m);
			}
			
			if(invaderMaxX.getPosition().getX()>maxX && invaderMaxX.getSpeedVector().getDirection().getX() == 1){
				timeDown =0;
				this.setStrategy(new MoveStrategyLine(new Point(0,1)));
				return super.getSpeedVector(m);
			}
			
			if(timeDown == 2 && sv.getDirection().getY() == 1){
				if(invaderMaxX.getPosition().getX()>maxX){
					this.setStrategy(new MoveStrategyLine(new Point(-1,0)));
				}else{
					this.setStrategy(new MoveStrategyLine(new Point(1,0)));
				}
				return super.getSpeedVector(m);
			}
			timeDown++;
		}
		
		return super.getSpeedVector(m);
		
	}
	
	public void add(Invader i){
		invaders.add(i);
	}
	
	public void remove(Invader i){
		invaders.remove(i);
	}
	
	public List<Invader> getInvaders(){
		return invaders;
	}
	
	private Invader invaderMinX(){
		if(invaders.isEmpty()){
			return null;
		}
		double minX = invaders.get(0).getPosition().getX();
		Invader invader = invaders.get(0);
		for(Invader i: invaders){
			if(minX> i.getPosition().getX()){
				minX = i.getPosition().getX();
				invader = i;
			}
		}
		return invader;
	}
	
	private Invader invaderMaxX(){
		if(invaders.isEmpty()){
			return null;
		}
		double maxX = invaders.get(0).getPosition().getX();
		Invader invader = invaders.get(0);
		for(Invader i: invaders){
			if(maxX< i.getPosition().getX()){
				maxX = i.getPosition().getX();
				invader = i;
			}
		}
		return invader;
	}
	
}
