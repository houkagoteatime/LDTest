package com.github.houkagoteatime.levels;

import java.util.ArrayList;
import java.util.Iterator;

import com.github.houkagoteatime.entities.Player;
import com.github.houkagoteatime.entities.enemies.Enemy;

public abstract class Level {
	
	private Player player;
	private ArrayList<Enemy> enemies;
	//private ArrayList<Projectiles> projectiles;
	
	public Level(String path) {
		loadLevel(path);
	}
	
	/**
	 * levels should override this for different enemy spawns
	 */
	public abstract void spawnEnemies();

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
