
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aniket
 */
  class MyPoint{
        int x;
        int y;
        
      Scanner in = new Scanner(System.in);

    MyPoint() {
        this.x = 0;
        this.y = 0;
    }
    MyPoint(int x,int y){
        this.x=x;
        this.y=y;
    }
      
       public int getX() {
  return this.x;
       }
        public int getY() {
  return this.y;
        }
        public void setXY(int x,int y){
       this.x = x;
       this.y = y;
        }
        
        @Override
        public String toString(){
      String str;
      str="( "+x+", "+y+" )";
      return str;
  }
       public double distance(int x1,int y1){
            return Math.sqrt((this.x-x1)*(this.x-x1)+(this.y-y1)*(this.y-y1));
        }
        public double distance(MyPoint another){
            return Math.sqrt((this.x-another.x)*(this.x-another.x)+(this.y-another.y)*(this.y-another.y));

        }
  }
public class  TestMyPoint {
  public static void main(String[] args){
      MyPoint p1=new MyPoint(3,5);
      System.out.println("X = "+p1.x+" and y = "+p1.y);
      
  }
}
