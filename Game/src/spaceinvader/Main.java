package spaceinvader;

import gameframework.game.GameLevel;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		GameInvaderImpl g = new GameInvaderImpl();
		ArrayList<GameLevel> levels = new ArrayList<GameLevel>();

		levels.add(new GameLevelOne(g)); 
		levels.add(new GameLevelOne(g)); 
		g.setLevels(levels);
		g.start();
	}
}
