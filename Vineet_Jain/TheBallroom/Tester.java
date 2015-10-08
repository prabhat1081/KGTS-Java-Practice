/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** Tester Classs.
 * 
 * <P> Will perform tests for the program and the constituent classes. Contains main function.
 *
 * @author vineet
 */
public class Tester {
    public static void main (String[] args) {
        int step;
        System.out.println("-------------------------------");
        System.out.println("Tester for public class Ball");
        Ball b1 = new Ball(2, 2, 1, 3, 60);
        System.out.println(b1.toString());
        for (step = 0; step < 5; step++) {
            b1.move();
            System.out.println(b1);
        }
        b1.reflectHorizontal();
        System.out.println(b1.toString());
        for (step = 0; step < 3; step++) {
            b1.move();
            System.out.println(b1);
        }
        b1.reflectVertical();
        System.out.println(b1.toString());
        for (step = 0; step < 3; step++) {
            b1.move();
            System.out.println(b1);
        }
        
        Ball b2 = new Ball(0, 0, 1, -3, 180);
        System.out.println(b2.toString());
        for (step = 0; step < 5; step++) {
            b2.move();
            System.out.println(b2);
        }
        
        b2.setxDelta(0);
        System.out.println(b2.toString());
        for (step = 0; step < 3; step++) {
            b2.move();
            System.out.println(b2);
        }
        b2.setyDelta(0);
        System.out.println(b2.toString());
        for (step = 0; step < 3; step++) {
            b2.move();
            System.out.println(b2);
        }
        b2.setX(-10);
        b2.setY(-8);
        b2.setxDelta(-1.5);
        b2.setyDelta(-2);
        System.out.println(b2.toString());
        for (step = 0; step < 3; step++) {
            b2.move();
            System.out.println(b2);
        }
        System.out.println("-------------------------------");
        System.out.printf("\n\n");
        System.out.println("-------------------------------");
        System.out.println("Tester for program");
        Ball ball = new Ball(50, 50, 5, 10, 30);
        Container box = new Container(0, 0, 100, 100);
        for (step = 0; step < 100; ++step) {
            ball.move();
            box.collidesWith(ball);
            System.out.println(ball);// manually check the position of the ball
        }
        System.out.println("-------------------------------");
    }
}
