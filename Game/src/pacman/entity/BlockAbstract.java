package pacman.entity;

import gameframework.base.Drawable;
import gameframework.base.DrawableImage;
import gameframework.game.GameEntity;
import gameframework.game.MoveBlocker;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public abstract  class BlockAbstract implements Drawable, MoveBlocker, GameEntity {
	protected static DrawableImage image = null;
	private int x, y;
	private int life;
	public static final int RENDERING_SIZE = 16;

	public BlockAbstract(Canvas defaultCanvas, String patchGIF, int xx, int yy) {
		image = new DrawableImage(patchGIF, defaultCanvas);
		x = xx;
		y = yy;
		life = 3;
	}

	public void draw(Graphics g) {
		g.drawImage(image.getImage(), x, y, RENDERING_SIZE, RENDERING_SIZE,
				null);
	}

	public Point getPos() {
		return (new Point(x, y));
	}
	
	public int getLife() {
		return life;
	}
	public void setLife(int l){
		life = l;
	}

	public Rectangle getBoundingBox() {
		return (new Rectangle(x, y, RENDERING_SIZE, RENDERING_SIZE));
	}
}
