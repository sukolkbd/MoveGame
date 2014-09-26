package movegame;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Enemy {
	private Image image;
	protected int x;
	protected int y;
	private int z;
	private Random random =new Random();

	public Enemy(int x, int y) throws SlickException {
		image = new Image("res/enemy.png");
		this.x = x;
	    this.y = y;
	    
}
	public void draw() {
		image.draw(x, y);
		
	}
	public void moveTo(int x,int y){
		if(x>=this.x){
			this.x+=1;
			if(y>this.y){
				this.y+=1;
			}else  this.y-=1;}
		else if(x<this.x){
			this.x-=1;
			if(y>this.y){
				this.y+=1;
			}else this.y-=1;
			}
		}	
				
				
				
				
				
				/*image.setRotation(random.nextInt(6)*60);
		int i=0;
		z=(int) Math.pow(-1, random.nextInt(2));
		if(i <10){
			x+=z;
			i++;}
		z=(int) Math.pow(-1, random.nextInt(2));
		if(i >10){
			y+=z;
			i--;}
		//z=random.nextInt()-random.nextInt();
		//x+=z;
		//y+=z;*/
	
	public void Setposition(int x,int y) {
		this.x=x;
		this.y=y;
		
	}
}

