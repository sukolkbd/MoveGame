package movegame;

import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import movegame.Player;



public class MoveGame extends BasicGame {
	private boolean isStarted;
	private boolean isGameOver;
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	private Player player;
	private Enemy[] enemies;
	private int numberofenemy=0;
	Random randomX = new Random();
	Random randomY = new Random();
	private int t=0;
	private int sec=0;
	private int min=0;
	public MoveGame(String title) {
		super(title);
	}

	public static void main(String[] args) {
		try {
			  MoveGame game = new MoveGame("Move Game");
		      AppGameContainer container = new AppGameContainer(game);
		      container.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
		      container.setMinimumLogicUpdateInterval(1000/60);
		      container.start();
		    } catch (SlickException e) {
		      e.printStackTrace();
		    }

	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		player.draw();
		g.drawString("Time : "+String.format("%02d", min)+":"+String.format("%02d", sec), 0, 580);
		for(Enemy enemy : enemies)
		enemy.render();
		if(isStarted==false){
			g.drawString("YourTime "+String.format("%02d", min)+":"+String.format("%02d", sec), 390, 290);
		}
	}
	private void initEnemies() throws SlickException{
		enemies = new Enemy[30];
		for(numberofenemy =0;numberofenemy<30;numberofenemy+=2){
			enemies[numberofenemy]=new Enemy((randomX.nextInt(2)-randomX.nextInt(1))*780,randomY.nextInt(580));
			enemies[numberofenemy+1]=new Enemy(randomX.nextInt(780),(randomY.nextInt(2)-randomY.nextInt(1))*580);
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		isStarted=false;
		isGameOver=false;
		player = new Player(GAME_WIDTH/2-10,GAME_HEIGHT/2-10);
		t=0;
		min=0;
		sec=0;
		initEnemies();
	}
	void updatePlayerMovement(Input input, int delta)
	{
		if (input.isKeyDown(Input.KEY_LEFT)) { 
		      player.moveLeft();
		    	
		    }
		    if (input.isKeyDown(Input.KEY_RIGHT)) {
		    	player.moveRight();
		   
		    }
		    if (input.isKeyDown(Input.KEY_DOWN)) {
		    	player.moveDown();
			}
		    if (input.isKeyDown(Input.KEY_UP)) {
		    	player.moveUp();
			}
	}
	public void Key(Input input,GameContainer container){
		if (input.isKeyPressed(Input.KEY_SPACE)) {
			  isStarted=true;
			  }
		if(input.isKeyPressed(Input.KEY_ENTER)){
			isGameOver=true;
		}
	}
	

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		Key(input,container);
		if(isStarted == true){
			time();
		updatePlayerMovement(input, delta);
		moveenemy();
		for(Enemy enemy : enemies){
		    if(player.isCollide(enemy)){
		    	isStarted=false;
		    }
		}	
		}
		if(isGameOver==true)
	    	container.reinit();
		}
	public void moveenemy(){
		for(int i=0;i<numberofenemy;i+=3){
			enemies[i].moveTo(player.x,player.y,randomX.nextInt(4));
			enemies[i+1].randommove(1);
			enemies[i+2].randommove(2);
			}
	}
	public void time(){
		t++;
		if(t==60){
			sec++;
			t=0;
		if(sec==60){
			min++;
			sec=0;
		}}
			
	}
	 

}
