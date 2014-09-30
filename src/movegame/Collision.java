package movegame;

public class Collision {
	private static float i= (float) 8.5;
	  static boolean isCollide(float x, float y, float eX, float eY) {
		if(x+i>eX-i&&x-i<eX+i&&y+i>eY-i&&y-i<eY+i)
		    return true;
		return false;
		  }
		}
