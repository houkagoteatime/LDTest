package com.github.houkagoteatime.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.github.houkagoteatime.entities.Player;
import com.github.houkagoteatime.entities.enemies.Enemy;
import com.github.houkagoteatime.levels.Level;
import com.github.houkagoteatime.levels.Level1;

public class GameScreen implements Screen{


    private OrthographicCamera cam;
	private SpriteBatch sb;
	private Level level;
	
	public GameScreen(SpriteBatch batch) {
		sb = batch;
		level = new Level1("assets/map.tmx");
		cam = new OrthographicCamera(500, 500);
	}
	
	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public void render(float dt) {
		
		level.update(dt);
		updateCam(level.getPlayer());
		cam.update();
		level.getTiledMapRenderer().setView(cam);
        level.getTiledMapRenderer().render();
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
	
	/**
	 * @param player center the camera around player
	 */
	public void updateCam(Player player) {
		
		//cam zoom shouldn't be changed much, should make a seperate function to change it
		float effectiveViewportWidth = cam.viewportWidth * cam.zoom;
        float effectiveViewportHeight = cam.viewportHeight * cam.zoom;
        
        //cam.position.x = Gdx.graphics.getWidth() / 2;
        //cam.position.y = Gdx.graphics.getHeight() / 2;
        //Make sure the camera stays within the range of the map, no black space shown on screen
		cam.position.x = MathUtils.clamp(player.getSprite().getHeight()/2, effectiveViewportWidth / 2f, level.mapPixelWidth - effectiveViewportWidth / 2f);
	    cam.position.y = MathUtils.clamp(player.getSprite().getWidth()/2, effectiveViewportHeight / 2f, level.mapPixelHeight - effectiveViewportWidth / 2f);
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
