package movegame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Enemy{
	private Image image;
	
	protected int x;
	protected int y;
	
	private int vx;
	private int vy;

	public Enemy(int x, int y) throws SlickException {
		image = new Image("res/enemy.png");
		this.x = x;
	    this.y = y;
}
	public void render(){
		image.draw(x,y);
	}
	public void update(){
		
	}
	public void randommove(int x){
		if(this.y<=0)
			vy=x;
		if(this.x<=0)
			vx=x;
		if(this.y>=580)
			vy=-3;
		if(this.x>=780)
			vx=-3;
		
		this.y+=vy+1;
		this.x+=vx+1;
		
	}
	public void moveTo(int x,int y,int z){
		Changevelocity(x, y,z);
		if(x>=this.x){
			this.x+=vx;
			if(y>this.y){
				this.y+=vy;
				}
			else  this.y-=vy;
			}
		else if(x<this.x){
			this.x-=vx;
			if(y>this.y){
				this.y+=vy;
				}
			else this.y-=vy;
			}
		}			
				
	
	public void Changevelocity(int x,int y,int z) {
		if(Math.abs(this.x-x)>=Math.abs(this.y-y)){
			vx=1+z;
			vy=z;
			}
		else if(Math.abs(this.x-x)<Math.abs(this.y-y)){
			vx=z;
			vy=1+z;
			}
		}
	public float getX() { return this.x; }
	public float getY() { return this.y; }
}

