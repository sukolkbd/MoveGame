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
		//moveTo(player.x-20,player.y-20);
	}
	public void moveTo(int x,int y,int z){
		Changevelocity(x, y,z);
		if(x>=this.x){
			this.x+=vx;
			if(y>this.y){
				this.y+=vy;
			}else  this.y-=vy;}
		else if(x<this.x){
			this.x-=vx;
			if(y>this.y){
				this.y+=vy;
			}else this.y-=vy;
			}
		}			
				
	
	public void Changevelocity(int x,int y,int z) {
		if(Math.abs(this.x-x)>=Math.abs(this.y-y)){
			vx=2+z;
			vy=1+z;}
		else if(Math.abs(this.x-x)<Math.abs(this.y-y)){
			vx=1+z;
			vy=2+z;
		}
	}
}

