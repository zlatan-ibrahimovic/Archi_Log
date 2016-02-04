package gameframework.game;

import gameframework.base.Overlappable;

import java.awt.Point;
import java.awt.Rectangle;

public class InvisibleMoveBlocker implements MoveBlocker, GameEntity, Overlappable {
	public static final int RENDERING_SIZE = 17;
	public Point pos;
	
	public InvisibleMoveBlocker(Point p){
		this.pos = p;
	}
	
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(0,0,RENDERING_SIZE,RENDERING_SIZE);
	}

	@Override
	public Point getPosition() {
		return pos;
	}
	
	

}
