package SnakeGame;

import java.util.List;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {
     
	 List<Point> snakePoints;
	 int xDir, yDir;  // the snake two direction move x or y axis
	 boolean isMoving, elongate;
	 final int startSize = 20, startX = 150, startY = 150;
	 
	 public Snake(){
		 snakePoints = new ArrayList<Point>();
		 xDir = 0;
		 yDir = 0;
		 isMoving = false;
		 elongate = false;
		 snakePoints.add(new Point(startX, startY));
		 for(int i = 1; i < startSize; i++){
			 snakePoints.add(new Point(startX - i * 4, startY));
		 }
	 }
	 
	 public void draw(Graphics g){
		 g.setColor(Color.white);
		 for(Point p: snakePoints){
			 g.fillRect(p.getX(), p.getY(), 4, 4);
		 }
	 }
	 
	 public void move(){
		 if(isMoving){
			 Point temp = snakePoints.get(0);
			 Point last = snakePoints.get(snakePoints.size() - 1);
			 Point newStart = new Point(temp.getX() + xDir * 4, temp.getY() + yDir * 4);
			 for(int i = snakePoints.size() - 1; i >= 1; i--){
				 snakePoints.set(i, snakePoints.get(i - 1));
			 } 
			 snakePoints.set(0, newStart);
			 if(elongate){
				 snakePoints.add(last);
				 elongate = false;
			 }
		 }  
	 }
	 public boolean snakeCollision() {
		 int x = this.getX();
		 int y = this.getY();
		 for(int i = 1; i < snakePoints.size(); i ++){
			 if (snakePoints.get(i).getX() == x && snakePoints.get(i).getY() == y)
				 return true;
		 } return false;
		 }

	
	 public boolean isMoving(){
		 return isMoving;
	 }
	 public void setIsMoving(boolean b){
		 isMoving = b;
	 }
	 
	 public int getXDir(){
		 return xDir;
	 }
	 public int getYDir(){
		 return yDir;
	 }
	 
	 public void setXDir(int x){
		 xDir = x;
	 }
	 public void setYDir(int y){
		 yDir = y;
	 }
	 
	 //x position of head of snake
	 public int getX(){
		 return snakePoints.get(0).getX();
	 }
	 public int getY(){
		 return snakePoints.get(0).getY();
		 
	 }
	 
	 public void setElongate(boolean b){
		 elongate = b;
	 }


}
