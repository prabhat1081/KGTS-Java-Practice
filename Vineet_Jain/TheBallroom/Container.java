/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** Container Model Object.
 * 
 * <P> Represents the enclosing box for the ball.
 * 
 * <P> Various attributes of the container, and related behavior.
 *
 * @author vineet
 */
public class Container {
    int x1, y1, x2, y2;
    
    /** Constructor for public class Container.
     * 
     * @param x abscissa of the top left corner of the container.
     * @param y ordinate of the top left corner of the container.
     * @param width width of the container.
     * @param height height of the container.
     */
    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        
        //Convert height and width to co-ordinates of bottom right corner
        this.x2 = this.x1 + width - 1;
        this.y2 = this.y1 + height - 1;
    }
    
    /**
     * @return abscissa of the top left corner of the container.
     */
    public int getX1() {
        return this.x1;
    }
    
    /**
     * @return ordinate of the top left corner of the container.
     */
    public int getY1() {
        return this.y1;
    }
    
    /**
     * @return abscissa of the bottom right corner of the container.
     */
    public int getX2() {
        return this.x2;
    }
    
    /**
     * @return ordinate of the bottom right corner of the container.
     */
    public int getY2() {
        return this.y2;
    }
    
    /** Sets the abscissa of the top left corner of the container to the user defined value.
     * 
     * @param x abscissa of the top left corner of the container.
     */
    public void setX1(int x) {
        this.x1 = x;
    }
    
    /** Sets the ordinate of the top left corner of the container to the user defined value.
     * 
     * @param y ordinate of the top left corner of the container.
     */
    public void setY1(int y) {
        this.y1 = y;
    }
    
    /** Sets the abscissa of the bottom right corner of the container to the user defined value.
     * 
     * @param x abscissa of the bottom right corner of the container.
     */
    public void setX2(int x) {
        this.x2 = x;
    }
    
    /** Sets the ordinate of the bottom right corner of the container to the user defined value.
     * 
     * @param y ordinate of the bottom right corner of the container.
     */
    public void setY2(int y) {
        this.y2 = y;
    }
    
    /** String converter for coordinates of the top left and bottom right corners of the container.
     * 
     * @return string containing coordinates of the top left and bottom right corners of the container .
     */
    @Override
    public String toString() {
        return "Container at ("+this.x1+", "+this.y1+") to ("+this.x2+", "+this.y2+")";
    }
    
    /** Apply collisions to the ball. 
     * 
     * <P>Invokes reflectHorizontal() if ball is going outside the vertical boundaries of the container.
     * <P>Invokes reflectVertical() if ball is going outside the horizontal boundaries of the container.
     * 
     * @param ball ball instance which is to be checked for collisions.
     * @return true only if ball is outside bounds of the container.
     */
    public boolean collidesWith(Ball ball) {
        if ((ball.getX() - ball.getRadius() <= this.x1) || (ball.getX() + ball.getRadius() >= this.x2)) {
            ball.reflectHorizontal();
            return true;
        }
        if ((ball.getY() - ball.getRadius() <= this.y1) || (ball.getY() + ball.getRadius() >= this.y2)) {
            ball.reflectVertical();
            return true;
        }
        return false;
    }
}
