package spaceinvader;

import gameframework.game.GameDefaultImpl;
import gameframework.game.GameLevel;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		GameDefaultImpl g = new GameDefaultImpl();
		ArrayList<GameLevel> levels = new ArrayList<GameLevel>();

		levels.add(new GameLevelOne(g)); 
		levels.add(new GameLevelOne(g)); 
		g.setLevels(levels);
		g.start();
	}
}