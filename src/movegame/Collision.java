package movegame;

public class Collision {
	  static boolean isCollide(float x, float y, float eX, float eY) {
		  float i= (float) 8.5;
		  if(x+i>eX-i&&x-i<eX+i&&y+i>eY-i&&y-i<eY+i)
		    return true;
		return false;
		  }
		}
