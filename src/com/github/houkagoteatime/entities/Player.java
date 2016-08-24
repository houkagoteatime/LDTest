package com.github.houkagoteatime.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 *
 */
public class Player extends Entity{

	public Player(int health, int damage, Sprite sprite) {
		super(health, damage, sprite);
	}

	/* (non-Javadoc)
	 * @see com.github.houkagoteatime.entities.Entity#update(float)
	 */
	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		
	}

	

}
