package spaceinvader.rule;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import spaceinvader.entity.Tank;
import gameframework.base.MoveStrategy;
import gameframework.base.SpeedVector;
import gameframework.base.SpeedVectorDefaultImpl;
import gameframework.game.GameUniverse;

public class TankMoveStrategy extends KeyAdapter implements MoveStrategy {
	protected SpeedVector speedVector = new SpeedVectorDefaultImpl(new Point(0,0));
	protected GameUniverse universe;
	protected Tank tank;
	
	public TankMoveStrategy(Tank tank, GameUniverse universe) {
		this.universe = universe;
		this.tank = tank;
	}

	public SpeedVector getSpeedVector() {
		return speedVector;
	}

	@Override
	public void keyPressed(KeyEvent event) {
		int keycode = event.getKeyCode();
		switch (keycode) {
		case KeyEvent.VK_RIGHT:
			speedVector.setDirection(new Point(1, 0));
			break;
		case KeyEvent.VK_LEFT:
			speedVector.setDirection(new Point(-1, 0));
			break;
		
		case KeyEvent.VK_SPACE :
				tank.shoot(universe);
			break;
		}
			
	}
	
	@Override
	public void keyReleased(KeyEvent event) {
		int keycode = event.getKeyCode();
		switch (keycode) {
			case KeyEvent.VK_RIGHT:
				speedVector.setDirection(new Point(0, 0));
				break;
			case KeyEvent.VK_LEFT:
				speedVector.setDirection(new Point(0, 0));
				break;		
		}
	}
	@Override
	public void keyTyped(KeyEvent event){
		
	}
}
