package PingPong;

import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle implements Paddle{
    double y, yVel;  // it is velocity paddle move speed
    boolean upAccel, downAccel;
    final double gravity = 0.94;
    int player, x;
    Ball b1;
    
    public  AIPaddle(int player, Ball b){
    	upAccel = false; downAccel = false;
    	b1 = b;
    	y = 210; yVel = 0;
    	if(player == 1)
    		x = 20;
    	else
    		x = 660;
    }
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, (int)y, 20, 80);
	}

	
	public void move() {
		y = b1.getY() - 40; // 40 is half of 80 which is right paddle length~
		
		if(yVel >= 5)
			yVel = 5;
		else if (yVel <= -5)
			yVel = -5;
		
		y += yVel;
		
		if (y < 0)     y = 0;
		if (y > 420) y = 420;
	}
	
	public int getY() {
		return (int)y;
	}

}
