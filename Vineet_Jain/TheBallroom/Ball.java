/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** Ball Model Object.
 * 
 * <P> Represents the ball which will move around inside the container.
 * 
 * <P> Various attributes of the ball, and related behavior.
 *
 * @author vineet
 */
public class Ball {
    private double x, y, radius, xDelta, yDelta;

    /** Constructor for public class Ball.
     * 
     * @param x abscissa of the ball's center.
     * @param y ordinate of the ball's center.
     * @param radius radius of the ball. Cannot be negative or zero.
     * @param speed speed of the ball defined in pixels per step.
     * @param direction direction of the ball's movement. Specified in degrees from -180 to +180.
     */
    public Ball(double x, double y, double radius, int speed, int direction) {
        if(radius <= 0) {
            throw new IllegalArgumentException("Invalid radius!");
        }
        this.x = x;
        this.y = y;
        this.radius = radius;
        
        //Convert speed and direction to the instance variables xDelta and yDelta
        this.xDelta = speed * Math.cos(Math.toRadians(direction));
        this.yDelta = -speed * Math.sin(Math.toRadians(direction)); //y-axis of Java coordinate system is inverted
    }
    
    /** 
     * @return abscissa of the ball's center.
     */
    public double getX() {
        return x;
    }

    /**
     * @return ordinate of the ball's center.
     */
    public double getY() {
        return y;
    }

    /**
     * @return radius of the ball.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @return speed of the ball in x-direction (in pixels per step).
     */
    public double getxDelta() {
        return xDelta;
    }

    /**
     * @return speed of the ball in y-direction (in pixels per step).
     */
    public double getyDelta() {
        return yDelta;
    }
    
    /** Sets the abscissa of the ball's center to the user defined value.
     * 
     * @param x abscissa of the ball's center.
     */
    public void setX(double x) {
        this.x = x;
    }

    /** Sets the ordinate of the ball's center to the user defined value.
     * 
     * @param y ordinate of the ball's center.
     */
    public void setY(double y) {
        this.y = y;
    }

    /** Sets the radius of the ball to the user defined value.
     * 
     * @param radius radius of the ball.
     */
    public void setRadius(double radius) {
        if(radius <= 0) {
            throw new IllegalArgumentException("Invalid radius!");
        }
        this.radius = radius;
    }

    /** Sets the velocity of the ball in x-direction (in pixels per step) to the user defined value.
     * 
     * @param xDelta velocity of the ball in x-direction (in pixels per step).
     */
    public void setxDelta(double xDelta) {
        this.xDelta = xDelta;
    }

    /** Sets the velocity of the ball in y-direction (in pixels per step) to the user defined value.
     * 
     * @param yDelta velocity of the ball in y-direction (in pixels per step).
     */
    public void setyDelta(double yDelta) {
        this.yDelta = yDelta;
    }
    
    /** Moves the ball one step.
     * 
     * <P>Changes the position of the ball's center after one step.
     */
    public void move() {
        x += xDelta;
        y += yDelta;
    }
    
    /** Reflects ball horizontally (ball hits vertical wall).
     * 
     * <P>Velocity in x-direction reversed, velocity in y-direction unchanged.
     */
    public void reflectHorizontal() {
        xDelta = -xDelta;
    }
    
    /** Reflects ball vertically (ball hits horizontal wall).
     * 
     * <P>Velocity in y-direction reversed, velocity in x-direction unchanged
     */
    public void reflectVertical() {
        yDelta = -yDelta;
    }
    
    /** String converter for ball position and velocity.
     * 
     * @return string containing position and velocity of the ball.
     */
    @Override
    public String toString() {
        return "Ball at ("+this.x+", "+this.y+") of velocity ("+this.xDelta+", "+this.yDelta+")";
    }
}
