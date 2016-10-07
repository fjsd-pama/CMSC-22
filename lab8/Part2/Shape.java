 import java.lang.String;

 /**
 * Created by Arniel, Frank, Daniel at 10/4/16
 */

 public abstract class Shape{
  protected String color = "red";
  protected boolean filled = true;

  public abstract double getArea();
  public abstract double getPerimeter();
  
  public Shape(){
    this("green", true);
  }
  public Shape(String color, boolean filled){
   this.color  = color;
   this.filled = filled;
  }
  public String getColor(){
   return color;
  }
  public void setColor(String color){
   this.color = color;
  }
  public boolean isFilled(){
   return filled;
  }
  public void setFilled(boolean filled){
   this.filled = filled;
  }

  public String toString(){
   return String.format("A Shape with a color of" + color + "and" + (filled? " is filled": " is not filled"));
  }
}
