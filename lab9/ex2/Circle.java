import java.lang.Math;
/**
* Created by Arniel and Frank, 10/11/16
**/

public class Circle implements GeometricObject{
	protected double radius = 1.0;

	public Circle(double radius){
		this.radius = radius;
	}

	public double getPerimeter(){
		return 2 * Math.PI * radius;
	}

	public double getArea(){
		return Math.PI * radius * radius;
	}

	public String toString(){
		return String.format("Circle: {radius=%.2f, perimeter=%f, area=%f}", radius, getPerimeter(), getArea());
	}
}