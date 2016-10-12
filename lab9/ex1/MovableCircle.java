/**
* Created by Arniel and Frank, 10/11/16
**/

public class MovableCircle implements Movable{
	private int radius;
	private MovablePoint center;

	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius){
		center = new MovablePoint(x, y, xSpeed, ySpeed);
		this.radius = radius;
	}

	@Override
	public void moveUp(){
		center.moveUp();
	}

	public void moveDown(){
		center.moveDown();
	}

	public void moveLeft(){
		center.moveLeft();
	}

	public void moveRight(){
		center.moveRight();
	}

	public String toString(){
		return String.format("MovableCircle: { Radius: %d, Center:{Coordinates: x=%d, y=%d} }", radius, center.x, center.y);
	}
}