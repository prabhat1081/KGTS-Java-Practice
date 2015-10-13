/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aniket
 */

class Ball{
private int x,y,radius,xDelta,yDelta;
/**
 *constructor to initialise instance variables
 * @param x (required) it is the x co-ordinate of the ball,
 * @param y (required) it is the y co-ordinate of the ball
 * @param radius (required) radius of the ball
 * @param speed (required) speed of the ball
 * @param direction angle which the velocity of the ball makes with positive x axis. integer value lying in [-180,180].
 * @author Aniket
 */
Ball(int x,int y,int radius,int speed, int direction){
this.x = x;
this.y = y;
this.radius = radius;
xDelta = (int)(speed*Math.cos((double)direction*(Math.PI)/180));  // xDelta is being type casted to int
yDelta = (-1)*(int)(speed*Math.sin((double)direction*(Math.PI)/180));    // yDelta is being type casted to int and negative y axis in java
} 

/**
 * getter for x
 * @return x integer representing x co-ordinate of the ball 
 */
public int getX(){
    return x;
}
public void setX(int x){
    this.x=x;
}
/**
 * getter for y
 * @return y integer representing y co-ordinate of the ball 
 */
public int getY(){
    return y;
}
public void setY(int y){
    this.y=y;
}
/**
 * getter for radius of the ball
 * @return radius integer representing radius of the ball 
 */
public int getRadius(){
    return radius;
}
public void setRadius(int radius){
    this.radius=x;
}
/**
 * getter for xDelta
 * @return xDelta integer
 */
public int getXdelta(){
    return xDelta;
}
public void setXdelta(int xDelta){
    this.xDelta=xDelta;
}
/**
 * getter for yDelta
 * @return yDelta integer 
 */
public int getYdelta(){
    return yDelta;
}
public void setYdelta(int yDelta){
    this.yDelta=yDelta;
}

void move(){
x+=xDelta;          // updating x after 1 move
y+=yDelta;          // updating y after 1 move
}

void reflectHorizontal(){
    this.xDelta *= (-1);        // reflecting horizontally changes sign of xDelta but does nothing to yDelta
}
void reflectVertical(){
    this.yDelta *=-1;           // reflecting vertically changes sign of yDelta but does nothing to xDelta
}

@Override
 public String toString(){       
     String temp="Ball at( " + x + " , " + y + " )of velocity(" + xDelta + " , " + yDelta + " )​";
    System.out.println("​Ball at( " + x + " , " + y + " )of velocity(" + xDelta + " , " + yDelta + " )​");
return temp;
 }
}
public class BallTestDrive {
    public static void main(String[] args ){
        Ball[] MyBall=new Ball[10];
        int i;
        for(i=0;i<10;i++){
            MyBall[i] = new Ball(2*i , 3*i-1 , i , 10*i+5 , 10*i); // speed*cos(theta)/sin(theta) will be type casted to int
            System.out.println(" index : " + i + " : x = " + MyBall[i].getX() + " and y = " + MyBall[i].getY() + ", radius = " + MyBall[i].getRadius() + " , deltaX = " + MyBall[i].getXdelta() + " , deltaY = " + MyBall[i].getYdelta());
            
            MyBall[i].move();
            System.out.println("After move : index : " + i + " : x = " + MyBall[i].getX() + " and y = " + MyBall[i].getY() + ", radius = " + MyBall[i].getRadius() + " , deltaX = " + MyBall[i].getXdelta() + " , deltaY = " + MyBall[i].getYdelta());
            
            MyBall[i].reflectHorizontal();
            MyBall[i].reflectVertical();
            System.out.println("After reflection : index : " + i + " : x = " + MyBall[i].getX() + " and y = " + MyBall[i].getY() + ", radius = " + MyBall[i].getRadius() + " , deltaX = " + MyBall[i].getXdelta() + " , deltaY = " + MyBall[i].getYdelta());
            
            MyBall[i].toString();
            System.out.println();
        }
    }
}
