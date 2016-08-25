package com.github.houkagoteamtime.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.houkagoteamtime.level.Level;
import com.github.houkagoteatime.entities.enemies.Enemy;

public class GameScreen implements Screen{

	private SpriteBatch sb;
	private Level level;
	
	public GameScreen() {
		
	}
	
	@Override
	public void render(float dt) {
		level.update(dt);
		
		for(Enemy enemy : level.getEnemies()){
			enemy.getSprite().draw(sb);
		}
			
		/*for(Weapon.Projectile projectile : projectiles){
			projectile.draw(sb);
		}*/
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
