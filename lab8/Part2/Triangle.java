import java.lang.Math;

/**
 * Created by Arniel, Frank, Daniel at 10/4/16
 */

public class Triangle extends Shape{
	protected double s1;
	protected double s2;
	protected double s3;

	public Triangle(){
		//empty constructor
	}

	public Triangle(double s1, double s2, double s3){
		if ( !areValidSides(s1, s2, s3) ){
			throw new IllegalArgumentException("Sides are invalid sides for a Triangle!!");
		}

		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}

	public boolean areValidSides(double s1, double s2, double s3){
		//via the Pythagorean Theorem c^2 = a^2 + b^2
		if ( (s1 == Math.sqrt((s2 * s2) + (s3 * s3))) || (s2 == Math.sqrt((s1 * s1) + (s3 * s3))) ||
			 (s3 == Math.sqrt((s2 * s2) + (s1 * s1))) ){
			return true;
		}

		return false;
	}

	public double getArea(){
		double s = (s1 + s2 + s3) / 2;
		double result = Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
		return result;
	}

  	public double getPerimeter(){
  		return s1 + s2 + s3;
  	}
}