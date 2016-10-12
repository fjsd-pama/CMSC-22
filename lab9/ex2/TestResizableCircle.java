/**
* Created by Arniel and Frank, 10/11/16
**/

public class TestResizableCircle{
	public static void main(String[] args){
		ResizableCircle circle1 = new ResizableCircle(10);
		circle1.resize(100);
		System.out.println(circle1);

		ResizableCircle circle2 = new ResizableCircle(10);
		circle2.resize(50);
		System.out.println(circle2);
	}
}