package com.github.houkagoteatime.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.houkagoteatime.entities.enemies.Enemy;
import com.github.houkagoteatime.levels.Level;

public class GameScreen implements Screen{

	private SpriteBatch sb;
	private Level level;
	
	public GameScreen() {
		
	}
	
	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public void render(float dt) {
		level.update(dt);
		sb.begin();
		for(Enemy enemy : level.getEnemies()){
			sb.draw(enemy.getSprite(), enemy.getPosition().x, enemy.getPosition().y);
		}
		
		sb.draw(level.getPlayer().getSprite(), level.getPlayer().getPosition().x, level.getPlayer().getPosition().x);
		sb.end();	
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
