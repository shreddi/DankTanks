package Projectiles;
import Rendering.*;
import Tanks.*;

public class HomingProjectile extends Projectile{
	protected PlayerTank target;
	public HomingProjectile(double x, double y, double velocity, double angle, PlayerTank t) {
		super(x,y,velocity,angle,7,StdDraw.MAGENTA);
		target = t;
	}
	public void move() {
		//tracks down the target using distances and coordinates
		setXcoord(getXcoord() + getXvelocity());
		setYcoord(getYcoord() + getYvelocity());
		if(getXDistanceFrom(target)>0) {
			setXvelocity(getXvelocity()-.5);
		}
		if(getXDistanceFrom(target)<0) {
			setXvelocity(getXvelocity()+.5);
		}
		if(getYDistanceFrom(target)>0) {
			setYvelocity(getYvelocity()-.5);
		}
		if(getYDistanceFrom(target)<0) {
			setYvelocity(getYvelocity()+.5);
		}
	}

}
