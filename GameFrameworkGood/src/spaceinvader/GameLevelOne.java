package spaceinvader;

import gameframework.base.MoveStrategyStraightLine;
import gameframework.base.SpeedVectorDefaultImpl;
import gameframework.game.CanvasDefaultImpl;
import gameframework.game.Game;
import gameframework.game.GameLevelDefaultImpl;
import gameframework.game.GameMovableDriverDefaultImpl;
import gameframework.game.GameUniverseDefaultImpl;
import gameframework.game.GameUniverseViewPortDefaultImpl;
import gameframework.game.InvisibleMoveBlocker;
import gameframework.game.MoveBlocker;
import gameframework.game.MoveBlockerChecker;
import gameframework.game.MoveBlockerCheckerDefaultImpl;
import gameframework.game.OverlapProcessor;
import gameframework.game.OverlapProcessorDefaultImpl;

import java.awt.Canvas;
import java.awt.Point;

import spaceinvader.entity.Invader;
import spaceinvader.entity.Tank;
import spaceinvader.entity.Shield;
import spaceinvader.rule.InvaderMovableDriver;
import spaceinvader.rule.InvaderOverlapRules;
import spaceinvader.rule.TankMoveStrategy;

public class GameLevelOne extends GameLevelDefaultImpl {
	
	Canvas canvas;
	public static final int SPRITE_SIZE = 17;
	public static final int NUMBER_OF_INVADERS = 1;
	
	public static final int MAX_X_INVADER = 22* SPRITE_SIZE;
	public static final int MIN_X_INVADER = 2* SPRITE_SIZE;
	public static final int INVADER_DOWNMOVE = 2* SPRITE_SIZE;
	
	@Override
	protected void init() {
		OverlapProcessor overlapProcessor = new OverlapProcessorDefaultImpl();

		MoveBlockerChecker moveBlockerChecker = new MoveBlockerCheckerDefaultImpl();
		
		InvaderOverlapRules overlapRules = new InvaderOverlapRules(life[0], score[0], endOfGame);
		overlapProcessor.setOverlapRules(overlapRules);

		universe = new GameUniverseDefaultImpl(moveBlockerChecker, overlapProcessor);
		overlapRules.setUniverse(universe);

		
		gameBoard = new GameUniverseViewPortDefaultImpl(canvas, universe);
		((GameUniverseViewPortDefaultImpl) gameBoard).setBackground("images/background.gif");
		
		((CanvasDefaultImpl) canvas).setDrawingGameBoard(gameBoard);
		
		
		//Tank
		Tank tank = new Tank(canvas);
		GameMovableDriverDefaultImpl tankDriver = new GameMovableDriverDefaultImpl();
		TankMoveStrategy keyStr= new TankMoveStrategy(tank,universe);
		tankDriver.setStrategy(keyStr);
		tankDriver.setmoveBlockerChecker(moveBlockerChecker);
		canvas.addKeyListener(keyStr);
		tank.setDriver(tankDriver);
		tank.setPosition(new Point(14 * SPRITE_SIZE, 25 * SPRITE_SIZE));
		universe.addGameEntity(tank);
		
		
		//Wall
		Shield w = new Shield(canvas, SPRITE_SIZE*17, SPRITE_SIZE*22);
		universe.addGameEntity(w);
		w = new Shield(canvas, SPRITE_SIZE*18+8, SPRITE_SIZE*22);
		universe.addGameEntity(w);
		
		//
		
		for(int i = 0; i <23;i++){
			InvisibleMoveBlocker mB = new InvisibleMoveBlocker(new Point(0,i*SPRITE_SIZE));
			universe.addGameEntity(mB);
			moveBlockerChecker.addMoveBlocker(mB);
			
			InvisibleMoveBlocker mB2 =new InvisibleMoveBlocker(new Point((MAX_X_INVADER+1)*SPRITE_SIZE,i*SPRITE_SIZE));
			universe.addGameEntity(mB2);
			moveBlockerChecker.addMoveBlocker(mB2);
		}

		
		Invader myInvader;
		InvaderMovableDriver invaderDriv = new InvaderMovableDriver(MIN_X_INVADER,MAX_X_INVADER,INVADER_DOWNMOVE,universe);
		invaderDriv.setmoveBlockerChecker(moveBlockerChecker);
		for(int nL =0; nL<5; nL++){
			for(int i=0;i<12;i++){
				
				int xNewInvader =(4+i) * (SPRITE_SIZE+4);
				int yNewInvader = (4+nL) * SPRITE_SIZE;
				
				myInvader = new Invader(canvas);
				myInvader.setSpeedVector(new SpeedVectorDefaultImpl(new Point(1,0)));
				myInvader.setPosition(new Point(xNewInvader,yNewInvader));
		
				invaderDriv.setStrategy(new MoveStrategyStraightLine(myInvader.getPosition(),new Point(MAX_X_INVADER,yNewInvader)));
				
				invaderDriv.add(myInvader);
				myInvader.setDriver(invaderDriv);
				
				universe.addGameEntity(myInvader);
				overlapRules.addInvader(myInvader);
			}
		}
		
	}

	public GameLevelOne(Game g) {
		super(g);
		canvas = g.getCanvas();
	}

}
