package com.github.houkagoteamtime.screen;

import com.badlogic.gdx.Screen;
import com.github.houkagoteamtime.level.Level;

public class GameScreen implements Screen{

	private Level level;
	
	public GameScreen() {
		
	}
	
	@Override
	public void render(float dt) {
		level.update(dt);
		
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

}
