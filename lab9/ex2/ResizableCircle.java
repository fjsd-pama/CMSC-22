/**
* Created by Arniel and Frank, 10/11/16
**/

public class ResizableCircle extends Circle implements Resizable{

	public ResizableCircle(double radius){
		super(radius);
	}

	public void resize(int percent){
		radius += (radius * (percent / 100.0));
	}

	public String toString(){
		return String.format("ResizableCircle: { " + super.toString() + " }");
	}
}