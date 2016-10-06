import java.lang.String;
/**
 * Created by Arniel, Frank, Daniel at 10/4/16
 */

public class Square extends Rectangle{
  public Square(){
    this(1.0);
  }
  public Square(double side){
    super(side, side);
  }
  public Square(double side, String color, boolean filled){
    super(side, side, color, filled); //calls Rectangle constructor
  }

  public double getSide(){
    return length; //pwede ra sad ang width pilion
  }
  public void setSide(double side){
    setWidth(side); //calls setWidth() within file
    setLength(side); //calls setLength() within file
  }

  @Override
  public void setWidth(double side){
    super.setWidth(side);
  }
  
  public void setLength(double side){
    super.setLength(side);
  }

  public double getArea(){
    return length * length;
  }

  public double getPerimeter(){
    return 4 * length;
  }

  public String toString(){
    return String.format("A Square with side=" + length + ", which is a subclass of" + super.toString());
  }
}