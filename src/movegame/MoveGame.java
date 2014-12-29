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
	
	private int NumberofEnemy=0;
	
	Random random = new Random();
	
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
		enemies = new Enemy[60];
		for(NumberofEnemy=0;NumberofEnemy<60;NumberofEnemy+=4){
			enemies[NumberofEnemy]=new Enemy(800,random.nextInt(600));
			enemies[NumberofEnemy+1]=new Enemy(random.nextInt(800),600);
			enemies[NumberofEnemy+2]=new Enemy(-20,random.nextInt(600));
			enemies[NumberofEnemy+3]=new Enemy(random.nextInt(800),-20);
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		isStarted=false;
		isGameOver=false;
		
		player = new Player(GAME_WIDTH/2-10,GAME_HEIGHT/2-10);
		
		t=0; min=0; sec=0;
		
		initEnemies();
	}
	void updatePlayerMovement(Input input, int delta){
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
		for(int i=0;i<NumberofEnemy;i+=6){
			enemies[i+2].randommove(2);
			if(t>=600)
				enemies[i+1].randommove(1);
			if(t>=1200)
				enemies[i+3].randommove(3);
			if(t>=2400)
				enemies[i+4].randommove(2);
			if(t>=4800)
				enemies[i+5].randommove(2);
			if(t>=7200)
				enemies[i].moveTo(player.x,player.y,3);
		}
	}
	public void time(){
		t++;
		if(t%50==0){
			sec++;
			if(sec==60){
				min++;
				sec=0;
				}
			}	
		}
	}
