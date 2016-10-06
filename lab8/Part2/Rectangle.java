import java.lang.String;
/**
 * Created by Arniel, Frank, Daniel at 10/4/16
 */

public class Rectangle extends Shape{
 protected double width = 1.0;
 protected double length = 1.0;

 public Rectangle(){
   this.width = 1.0;
   this.length = 1.0;
 }
 public Rectangle(double width, double length){
  setWidth(width);
  setLength(length);
 }
 public Rectangle(double width, double length, String color, boolean filled){
  super(color, filled);
  setWidth(width);
  setLength(length);
 }
 public double getWidth(){
  return width;
 }
 public void setWidth(double width){
   if ( width <= 0 ){
     throw new IllegalArgumentException("Width must be greater than zero!!");
   }
   this.width = width;
 }
 public double getLength(){
  return length;
 }
 public void setLength(double length){
  if ( length <= 0 ){
     throw new IllegalArgumentException("Length must be greater than zero!!");
   }
   this.length = length;
 }
 public double getArea(){
   return width * length;
 }
 public double getPerimeter(){
   return 2 * (length + width);
 }
 public String toString(){
   return String.format("A Rectangle with width=" + width + " and length=" + length + " ,which is a subclass of " + super.toString());
 }
}