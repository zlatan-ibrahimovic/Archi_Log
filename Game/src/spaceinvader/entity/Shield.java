package spaceinvader.entity;

import gameframework.base.Drawable;
import gameframework.base.DrawableImage;
import gameframework.base.Overlappable;
import gameframework.game.GameEntity;
import gameframework.game.SpriteManager;
import gameframework.game.SpriteManagerDefaultImpl;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Shield implements Drawable, Overlappable, GameEntity {
	protected static DrawableImage image = null;
	protected final SpriteManager spriteManager;
	private int hit;
	int x, y;
	public static final int RENDERING_SIZE = 17;

	public Shield(Canvas defaultCanvas, int xx, int yy) {
		spriteManager = new SpriteManagerDefaultImpl("images/InvaderWall.gif",
				defaultCanvas, RENDERING_SIZE, 1);
		spriteManager.setTypes("0", "1", "2");
		hit =0;
		x = xx;
		y = yy;
	}

	public void draw(Graphics g) {
		String spriteType = "";

		if (hit == 0) {
			spriteType += "0";
		}
		if (hit == 1) {
			spriteType += "1";
		}
		if (hit == 2) {
			spriteType += "2";
		}
		spriteManager.setType(spriteType);
		spriteManager.draw(g, getPosition());
	}

	public void restor(){
		hit =0;
	}
	
	public void hit(){
		hit++;
	}
	
	public boolean isDestroy(){
		if(hit>2){
			return true;
		}
		return false;
	}
	

	public Rectangle getBoundingBox() {
		return (new Rectangle(x, y, RENDERING_SIZE, RENDERING_SIZE));
	}

	@Override
	public Point getPosition() {
		return new Point(x, y);
	}
}
