package com.github.houkagoteatime.LDTest;
import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.houkagoteatime.screens.GameScreen;

/**
 *The entry point of the game
 */
public class LDTest extends Game{
	private SpriteBatch batch;
	private BitmapFont font;
	
	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "test";
		config.width =  500;
		config.height = 850;
		new LwjglApplication(new LDTest(), config);
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationListener#create()
	 */
	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		//this is the only screen we have. In reality, we woud be setting the main menu screen first
		this.setScreen(new GameScreen(batch));
	}
	
	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Game#dispose()
	 */
	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Game#render()
	 */
	@Override
	public void render() {
		super.render();
	}

	/**
	 * @return the batch
	 */
	public SpriteBatch getBatch() {
		return batch;
	}

	/**
	 * @return the font
	 */
	public BitmapFont getFont() {
		return font;
	}

}
