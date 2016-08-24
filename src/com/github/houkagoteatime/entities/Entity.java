package com.github.houkagoteatime.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {
	protected Sprite sprite;
	private int health;
	private int damage;
	private int speed;
	private float xPosition,yPosition, xMovement, yMovement;
	
	
	private boolean dead = false;
	
	public Entity(int health, int damage, Sprite sprite) {
		this.sprite = sprite;
		this.health = health;
		this.damage = damage;
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
	}
	
	public void move(float moveX, float moveY) {
		xMovement = moveX;
		yMovement = moveY;
	}

	public void update(float deltaTime) {
		if(health == 0)
			dead = true;
		int directionX = (int)Math.abs(xMovement);
		int directionY = (int)Math.abs(yMovement);
		yPosition += directionX * speed * deltaTime;
		xPosition += directionY * speed * deltaTime;
	}
	
	/**
	 * @return the sprite
	 */
	public Sprite getSprite() {
		return sprite;
	}

	/**
	 * @param sprite the sprite to set
	 */
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	/**
	 * @param damage damage done to health
	 */
	public void damage(int damage) {
		health-=damage;
	}
	
	public Vector2 getPosition() {
		return new Vector2(xPosition, yPosition);
	}

}
