package spaceinvader.entity;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Rectangle;

import gameframework.base.Drawable;
import gameframework.base.Overlappable;
import gameframework.game.GameEntity;
import gameframework.game.GameMovable;
import gameframework.game.SpriteManager;
import gameframework.game.SpriteManagerDefaultImpl;

public class MissileTank extends GameMovable implements Drawable, GameEntity,
Overlappable{
	
	protected final SpriteManager spriteManager;
	public static final int RENDERING_SIZE = 17;
	
	public MissileTank(Canvas defaultCanvas) {
		spriteManager = new SpriteManagerDefaultImpl("images/missileTank.gif",
				defaultCanvas, RENDERING_SIZE, 1);
		spriteManager.setTypes("move");
		
	}
	
	@Override
	public Rectangle getBoundingBox() {
		//return (new Rectangle(17, 17, 17, 17));
		return (new Rectangle(0, 0, RENDERING_SIZE, RENDERING_SIZE));
	}

	@Override
	public void draw(Graphics g) {
		String spriteType = "move";
		spriteManager.setType(spriteType);
		spriteManager.draw(g, getPosition());
		
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub
		
	}
	
	public void destroy(){
		
	}

}
