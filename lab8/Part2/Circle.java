import java.lang.Math;
import java.lang.String;

/**
 * Created by Arniel, Frank, Daniel at 10/4/16
 */

public class Circle extends Shape{
 protected double radius = 1.0;

 public Circle(){
   //this.radius = 1.0;
   //dili na ba ni butangan ug color? ug filled?
 }
 public Circle(double radius){
  this.radius = radius;
  //kani sad, di na ba ni butangan ug color? ug filled?
 }
 public Circle(double radius, String color, boolean filled){
  super(color, filled);
  setRadius(radius);
 }
 public double getRadius(){
  return radius;
 }
 public void setRadius(double radius){
   if ( radius < 0 ){
     throw new IllegalArgumentException("Radius must be greater than zero!!");
   }

   this.radius = radius;
 }
 public double getArea(){
  return Math.PI * Math.pow(radius, 2);
 }
 public double getPerimeter(){
  return 2 * (Math.PI ) * radius;
 }
 @Override
 public String toString(){
  return String.format("A Circle of with radius=" + radius + ",which is a subclass of " + super.toString());
 }

}