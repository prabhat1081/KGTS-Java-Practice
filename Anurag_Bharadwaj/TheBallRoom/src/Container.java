/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chatrasen
 */
public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    
    public Container(int x1, int y1, int width, int height)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1 + width - 1;
        this.y2 = y1 + height - 1;
    }
    public void setTopLeftX(int x1)
    {
        this.x1 = x1;
    }
    public int getTopLeftX()
    {
        return x1;
    }
     public void setTopLeftY(int y1)
    {
        this.y1 = y1;
    }
    public int getTopLeftY()
    {
        return y1;
    }
     public void setTopRightX(int width)
    {
        x2 = x1+width-1;
    }
    public int getTopRightX()
    {
        return x2;
    }
     public void setTopRightY(int height)
    {
       y2 = y1+height-1;
    }
    public int getTopRightY()
    {
        return y2;
    }
    @Override
    public String toString()
    {
        String s;
        s = "Container at (" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ")";
        return s;
    }
    public boolean collidesWith(Ball ball)
    {
        boolean hasEnteredIf = false;
        if(ball.getX() - ball.getRadius() <= this.x1 || ball.getX() + ball.getRadius() >= this.x2)
        {
            ball.reflectHorizontal();
            hasEnteredIf = true;
        }
        if(ball.getY() - ball.getRadius() <= this.y1 || ball.getY() + ball.getRadius() >= this.y2)
        {
            ball.reflectVertical();
            hasEnteredIf = true;
        }
        return hasEnteredIf;
    }
}
