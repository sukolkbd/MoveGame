package movegame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {
	private Image image;
	private int x;
	private int y;
	
	public Player(int x, int y) throws SlickException {
		image = new Image("res/player.png");
		this.x = x;
	    this.y = y;
}
	public void draw() {
		image.draw(x, y);
		
	}
	public void moveLeft() {
		x -= 2;
	      image.setRotation(270);
	      if (x+40 == 0)
	    	  x = 800;
		
	}

	public void moveRight() {
		x += 2;
	      image.setRotation(90);
	      if (x+40 == 800)
	    	  x = 0;
		
	}

	public void moveDown() {
		y += 2;
	      image.setRotation(180);
	      if (y+40 == 600)
	    	  y = 0;
		
	}

	public void moveUp() {
		y -= 2;
	      image.setRotation(0);
	      if (y+40 == 0)
	    	  y = 600;
		
		
	}

}
