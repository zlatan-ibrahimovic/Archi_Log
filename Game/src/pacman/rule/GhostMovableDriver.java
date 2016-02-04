package pacman.rule;

import gameframework.base.Movable;
import gameframework.base.SpeedVector;
import gameframework.game.GameMovableDriverDefaultImpl;

public class GhostMovableDriver extends GameMovableDriverDefaultImpl {
	
	static int MIN_X = 2;
	static int MAX_X = 400;

	// A modified random strategy that makes ghosts mostly follow the alleys in
	// one direction.
	// Random speed vectors are (1,0) (0,1) (-1,0) (0,-1), but sometimes speed
	// vectors are reinitialized to (0,0) by GameMovableDriver.
	@Override
	public SpeedVector getSpeedVector(Movable m) {
		SpeedVector currentSpeedVector, possibleSpeedVector;

		currentSpeedVector = m.getSpeedVector();
		possibleSpeedVector = super.getSpeedVector(m);
		
		int nbTries = 10;
		while (true) {
			nbTries--;
			if ((possibleSpeedVector.getDirection().getX() == currentSpeedVector
					.getDirection().getX())
					&& (possibleSpeedVector.getDirection().getY() != -currentSpeedVector
							.getDirection().getY()))
				break;

			if ((possibleSpeedVector.getDirection().getX() != -currentSpeedVector
					.getDirection().getX())
					&& (possibleSpeedVector.getDirection().getY() == currentSpeedVector
							.getDirection().getY()))
				break;

			if ((possibleSpeedVector.getDirection().getX() != currentSpeedVector
					.getDirection().getX())
					&& (possibleSpeedVector.getDirection().getY() != currentSpeedVector
							.getDirection().getY()))
				break;

			possibleSpeedVector = super.getSpeedVector(m);
			if (nbTries < 1)
				break;
		}
		return (possibleSpeedVector);
	}

}