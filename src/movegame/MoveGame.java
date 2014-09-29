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
	public MoveGame(String title) {
		super(title);
	}

	public static void main(String[] args) {
		try {
			  MoveGame game = new MoveGame("Super Move Game");
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
		for(Enemy enemy : enemies)
		enemy.render();
	}
	private void initEnemies() throws SlickException{
		enemies = new Enemy[20];
		
		for(numberofenemy =0;numberofenemy<20;numberofenemy+=2){
			enemies[numberofenemy]=new Enemy((randomX.nextInt(2)-randomX.nextInt(1))*780,randomY.nextInt(580));
			enemies[numberofenemy+1]=new Enemy(randomX.nextInt(780),(randomY.nextInt(2)-randomY.nextInt(1))*580);
			
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		isStarted=false;
		player = new Player(GAME_WIDTH/2-10,GAME_HEIGHT/2-10);
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
	public void Keystart(Input input){
		if (input.isKeyDown(Input.KEY_SPACE)) {
			  isStarted=true;}
	}
	

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		Keystart(input);
		if(isStarted == true){
		updatePlayerMovement(input, delta);
		//enemy=new Enemy(randomX.nextInt(780),(randomY.nextInt(2)-randomY.nextInt(1))*540);
		for(int i=0;i<numberofenemy;i+=2){
		enemies[i].moveTo(player.x,player.y,randomX.nextInt(4));
		enemies[i+1].randommove(randomX.nextInt(3), randomY.nextInt(3));
		//enemies[1].moveTo(player.x-20,player.y-20);
		//enemies[2].moveTo(player.x-20,player.y-20);
		}
		for(Enemy enemy : enemies){
			//enemy.update();
		    if(player.isCollide(enemy)){
		    	isStarted=false;
		    	container.reinit();
		    }
		}	
		}
		}

}
