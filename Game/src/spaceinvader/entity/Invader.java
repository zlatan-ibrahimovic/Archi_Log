package spaceinvader.entity;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import spaceinvader.rule.MoveStrategyLine;
import gameframework.base.Drawable;
import gameframework.base.Overlappable;
import gameframework.game.GameEntity;
import gameframework.game.GameMovable;
import gameframework.game.GameMovableDriverDefaultImpl;
import gameframework.game.GameUniverse;
import gameframework.game.SpriteManager;
import gameframework.game.SpriteManagerDefaultImpl;

public class Invader extends GameMovable implements Drawable, GameEntity,
Overlappable  {
	
	protected final SpriteManager spriteManager;
	protected Canvas defaultCanvas;
	public static final int RENDERING_SIZE = 17;

	public Invader(Canvas defaultCanvas) {
		this.defaultCanvas = defaultCanvas;
		spriteManager = new SpriteManagerDefaultImpl("images/invader1.gif",
				defaultCanvas, RENDERING_SIZE, 2);
		spriteManager.setTypes("move");
	}
	
	@Override
	public Rectangle getBoundingBox() {
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
		spriteManager.increment();
	}
	
	public void shoot(GameUniverse universe){
		MissileInvader missile = new MissileInvader(defaultCanvas);
		missile.setPosition(this.getPosition().getLocation());
		GameMovableDriverDefaultImpl driv = new GameMovableDriverDefaultImpl();
		driv.setStrategy(new MoveStrategyLine(new Point(0,1)));
		missile.setDriver(driv);
		
		universe.addGameEntity(missile);
		
	}
	
}
