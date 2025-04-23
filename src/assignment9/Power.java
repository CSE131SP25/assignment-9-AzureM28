package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Power {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Power() {
		x = FOOD_SIZE + (1 - 2 * FOOD_SIZE) * Math.random();
		y = FOOD_SIZE + (1 - 2 * FOOD_SIZE) * Math.random();
	}
	
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		double pulseSize = FOOD_SIZE + Math.sin(System.currentTimeMillis() % 1000 / 1000.0 *Math.PI) * 0.005;

		StdDraw.setPenColor(Color.BLUE);
		StdDraw.filledCircle(x, y, FOOD_SIZE); 
	}
	public double getX() {
		return this.x; 
		}
	public double getY() {
		return this.y; 
		}

}
