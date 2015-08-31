/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chatrasen
 */
public class ballroom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ball ball = new Ball(50, 50, 5, 10, 30);
        Container box = new Container(0, 0, 100, 100);
        for(int step=0; step<100; step++)
        {            
            ball.move();
            String s = ball.toString();
            System.out.println(s);
            boolean hasCollided = box.collidesWith(ball);
            if(hasCollided == true)
                System.out.println("The ball collided with the box");                
        }
    }
    
}
