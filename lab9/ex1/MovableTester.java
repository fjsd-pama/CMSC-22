/**
* Created by Arniel and Frank, 10/11/16
**/

public class MovableTester{
	public static void main(String[] args){
		Movable m1 = new MovablePoint(1, 5, 6, 10);     // upcast
		System.out.println(m1);
		m1.moveLeft();
		System.out.println(m1);
		   
		Movable m2 = new MovableCircle(3, 2, 1, 2, 20); // upcast
		System.out.println(m2);
		m2.moveRight();
		System.out.println(m2);
	}
}