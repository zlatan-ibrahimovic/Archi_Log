package spaceinvader.rule;

import java.awt.Point;

import gameframework.base.MoveStrategy;
import gameframework.base.SpeedVector;
import gameframework.base.SpeedVectorDefaultImpl;

public class MoveStrategyLine implements MoveStrategy{
	
	SpeedVector currentMove;
	
	public MoveStrategyLine(Point initSpeedVector) {
		currentMove = new SpeedVectorDefaultImpl(initSpeedVector);
	}
	
	@Override
	public SpeedVector getSpeedVector() {
		return currentMove;
	}

}
