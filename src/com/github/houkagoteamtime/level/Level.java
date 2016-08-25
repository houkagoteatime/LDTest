package com.github.houkagoteamtime.level;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.houkagoteatime.entities.Player;
import com.github.houkagoteatime.entities.enemies.Enemy;

public class Level {
	
	private Player player;
	private ArrayList<Enemy> enemies;
	//private ArrayList<Projectiles> projectiles;
	
	public Level(String path) {
		loadLevel(path);
	}

	public void update(float dt) {
		
		player.update(dt);
		
		for(Iterator<Enemy> iterator = enemies.iterator(); iterator.hasNext();){
			Enemy enemy = iterator.next();
			if(!enemy.isDead()){
				enemy.update(dt);
			} else {
				iterator.remove();
			}
		}
		
	    /*for (Iterator<Projectile> iterator = projectiles.iterator(); iterator.hasNext();) {
			Weapon.Projectile projectile = iterator.next();
			if(projectile.isAlive())
				projectile.update(dt);
			else {
				iterator.remove();
			}
	    }*/
	}
	
	public void render(SpriteBatch sb) {
		
		for(Enemy enemy : enemies){
			enemy.getSprite().draw(sb);
		}
		
		/*for(Weapon.Projectile projectile : projectiles){
			projectile.draw(sb);
		}*/
	}
	
	public void loadLevel(String path) {
		
	}
	
	public void dispose() {
		
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	
	/*public ArrayList<Projectiles> getProjectiles() {
		return projectiles;
	}*/
}
