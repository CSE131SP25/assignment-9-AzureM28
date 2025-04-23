package assignment9;

import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	
	private Snake snake;
	private Food food;
	private Power power;
	private int score; 
	private double pause;
	private int speed;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		snake = new Snake(); 
		food = new Food();
		power = new Power();
		score = 0;
		pause= 50;
		speed = 1;
	}
	
	private void drawBackground() {
		
		StdDraw.setPenColor(new Color(100, 120, 25)); 
		StdDraw.filledRectangle(0.5, 0.5, 1.0, 1.0); 
	}
	
	public void play() {
		while (snake.isInbounds()) { 
		int dir = getKeypress(); 
		snake.changeDirection(dir); 
		snake.move(); 
		if (snake.eatFood(food)) { 
		score += 1; 
		food = new Food(); 
		}
		if (snake.eatPower(power)) { 
			pause = pause/1.25;
			speed += 1;
			power = new Power(); 
			}
		updateDrawing(); 
		}
		}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear(); 
		drawBackground(); 
		snake.draw();
		food.draw(); 
		power.draw();
		StdDraw.setPenColor(Color.BLACK); 
		StdDraw.text(0.1, 0.9, "Score: " + score); 
		StdDraw.text(0.85, 0.9, "Speed: " + speed); 
		StdDraw.show(); 
		StdDraw.pause((int) pause); 
		
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
