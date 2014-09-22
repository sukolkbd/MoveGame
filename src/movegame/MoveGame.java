package movegame;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import movegame.Player;



public class MoveGame extends BasicGame {
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	private Player player;
	public MoveGame(String title) {
		super(title);
	}

	public static void main(String[] args) {
		try {
			  MoveGame game = new MoveGame("Super Move Game");
		      AppGameContainer container = new AppGameContainer(game);
		      container.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
		      container.setMinimumLogicUpdateInterval(1000 / 60);
		      container.start();
		    } catch (SlickException e) {
		      e.printStackTrace();
		    }

	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		player.draw();
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		player = new Player(GAME_WIDTH/2-10,GAME_HEIGHT/2-10);
		
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

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		updatePlayerMovement(input, delta);
		
	}

}
