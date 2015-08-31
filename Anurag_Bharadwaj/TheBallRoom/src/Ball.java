/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chatrasen
 */
public class Ball {
    private double x;
    private double y;
    private double radius;
    private double xDelta;
    private double yDelta;
    
    /**
     *
     * @param x
     * @param y
     * @param radius
     * @param speed - speed of ball in pixels per step
     * @param direction - in degrees in the range (-180, 180)
     */
    public Ball(double x, double y, double radius, double speed, double direction)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
        xDelta = speed*Math.cos(Math.PI*direction/180);
        yDelta = -speed*Math.sin(Math.PI*direction/180);
    }
    public void setX(double x)
    {
        this.x = x;
    }
    public double getX()
    {
        return x;
    }
    public void setY(double Y)
    {
        this.y = y;
    }
    public double getY()
    {
        return y;
    }
    public void setRadius(double radius)
    {
        this.radius = radius;
    }
    public double getRadius()
    {
        return radius;
    }
    public void setXDelta(double speed, double direction)
    {
        xDelta = speed*Math.cos(Math.PI*direction/180);
    }
    public double getXDelta()
    {
        return xDelta;
    }
    public void setYDelta(double speed, double direction)
    {
        yDelta = -speed*Math.sin(Math.PI*direction/180);
    }
    public double getYDelta()
    {
        return yDelta;
    }
    public void move()
    {
        x += xDelta;
        y += yDelta;
    }
    public void reflectHorizontal()
    {
        xDelta = -xDelta;
    }
    public void reflectVertical()
    {
        yDelta = -yDelta;
    }
    @Override
    public String toString()
    {
        String s;
        s = "Ball at (" + x + ", " + y + ") of velocity (" + xDelta + ", " + yDelta + ")";
        return s;
    }
}
