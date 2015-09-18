import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

Bacteria [] colony;
Food juan;
 public void setup()   
 {     
 	size(500,500);
 	colony = new Bacteria [1000];
 	for(int i = 0; i < colony.length; i++)
 	{
 		colony[i] = new Bacteria(250,250);
 	}
 	juan = new Food(250,250);
 	frameRate(20);
 }   
 public void draw()   
 {    
 	background(255);
 	for(int i = 0; i < colony.length; i++)
 	{
 		colony[i].gridWalk();
 		//colony[i].walk();
 		colony[i].move();
 		colony[i].show();
 	}
 	juan.place();
 	juan.show();
 }  
 class Bacteria    
 {     
 	int bx, by, bred, bblue, bgreen;
 	Bacteria(int x, int y)
 	{
 		bx = x;
 		by = y;
 		bred = (int)(Math.random()*256) - 1;
 		bblue = (int)(Math.random()*256) - 1;
 		bgreen = (int)(Math.random()*256) - 1;
 	}
 	public void gridWalk()
 	{
 		int direction = (int)(Math.random()*4) + 1;
 		if(direction == 1)
 		{
 			bx = bx + 5;
 		}
 		else if(direction == 2)
 		{
 			bx = bx - 5;
 		}
 		else if(direction == 3)
 		{
 			by = by + 5;
 		}
 		else 
 		{
 			by = by - 5;
 		}
 	}
 	public void walk()
 	{
 		bx = bx + (int)(Math.random()*9) - 4;
 		by = by + (int)(Math.random()*9) - 4;
 	}
 	public void move()
 	{
 		if(juan.fx + 15 > bx)
 		{
 			bx = bx + (int)(Math.random()*9) - 3;
 		}
 		else if(juan.fx + 15 < bx)
 		{
 			bx = bx + (int)(Math.random()*9) - 5;
 		}
 		if(juan.fy + 15 > by)
 		{
 			by = by + (int)(Math.random()*9) - 3;
 		}
 		else if(juan.fy + 15 < by)
 		{
 			by = by + (int)(Math.random()*9) - 5;
 		}
 	}
 	public void show()
 	{
 		fill(bred,bblue,bgreen);
 		if(bx < 0)
 		{
 			bx = bx + 500;
 		}
 		if(by < 0)
 		{
 			by = by + 500;
 		}
 		if(bx > 500)
 		{
 			bx = bx - 500;
 		}
 		if(by > 500)
 		{
 			by = by - 500;
 		}
 		ellipse(bx,by,10,10);
 	}
 }  
 class Food
 {
 	int fx, fy;
 	Food(int x,int y)
 	{
 		fx = x - 15;
 		fy = y - 15;
 	}
 	public void place()
 	{
 		if(mousePressed == true)
 		{
 			fx = mouseX - 15;
 			fy = mouseY - 15;
 		}
 	}
 	public void show()
 	{
 		noStroke();
 		fill(255, 185, 115);
 		rect(fx, fy, 30, 30, 10);
 		fill(0, 0, 0,100);
 		ellipse(fx + 11, fy + 20, 12, 12);
 		ellipse(fx + 22, fy + 19, 6, 6);
 		ellipse(fx + 21, fy + 10, 7, 7);
 		ellipse(fx + 12, fy + 6, 6, 6);
 	}
 }  
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
