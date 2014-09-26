package movegame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {
	private Image image;
	int x;
	int y;
	
	public Player(int x, int y) throws SlickException {
		image = new Image("res/player.png");
		this.x = x;
	    this.y = y;
}
	public void draw() {
		image.draw(x, y);
		
	}
	public void moveLeft() {
	      if (x > 0)
	    	  x -= 5;
	      image.setRotation(270);
		
	}

	public void moveRight() {
	      if (x< 780)
	    	  x += 5;
	      image.setRotation(90);
		
	}

	public void moveDown() {
	      if (y < 580)
	    	  y += 5;
	      image.setRotation(180);
		
	}

	public void moveUp() {
	      if (y > 0)
	    	  y -= 5;
	      image.setRotation(0);
		
		
	}

}
