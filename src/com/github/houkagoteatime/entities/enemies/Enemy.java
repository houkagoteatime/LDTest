package com.github.houkagoteatime.entities.enemies;

import com.badlogic.gdx.ai.fsm.State;
import com.badlogic.gdx.ai.fsm.StateMachine;
import com.badlogic.gdx.ai.msg.Telegram;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.houkagoteatime.entities.Entity;
import com.github.houkagoteatime.entities.Player;

/**
 *Classes that inherit this should be ones that want to kill the player class
 *remember kids, killing is bad, don't kill others
 */
public class Enemy extends Entity{

	private StateMachine<Enemy, EnemyState> stateMachine;
	private Player player;
	
	/**
	 *States that the enemy should be in
	 */
	public enum EnemyState implements State<Enemy> {
		
		/**
		 *Enemy will attempt to move towards the player until they are out of aggro range
		 */
		AGGRO() {

			/* (non-Javadoc)
			 * @see com.github.houkagoteatime.entities.enemies.Enemy.EnemyState#update(com.github.houkagoteatime.entities.enemies.Enemy)
			 */
			@Override
			public void update(Enemy enemy) {
				if(!enemy.isPlayerNearby()) {
					enemy.getStateMachine().changeState(SLEEP);
				} else {
					enemy.move(enemy.getPlayer().getPosition().x - enemy.getPosition().x, enemy.getPlayer().getPosition().y - enemy.getPosition().y);
				}
			}
			
		},
		
		/**
		 *An enemy that is sleeping will only attack if the player is nearby
		 */
		SLEEP() {

			/* (non-Javadoc)
			 * @see com.github.houkagoteatime.entities.enemies.Enemy.EnemyState#update(com.github.houkagoteatime.entities.enemies.Enemy)
			 */
			@Override
			public void update(Enemy enemy) {
				if(enemy.isPlayerNearby()) {
					enemy.getStateMachine().changeState(AGGRO);
				} 
			}
			
		};
		
		@Override
		public void enter(Enemy arg0) {
			
		}

		@Override
		public void exit(Enemy arg0) {
			
		}

		@Override
		public boolean onMessage(Enemy arg0, Telegram arg1) {
			return false;
		}
		
	}
	/**
	 * @param health health of the enemy
	 * @param damage how much damage it does
	 * @param sprite the enemy sprite
	 * @param player the player playing the game
	 */
	public Enemy(int health, int damage, Sprite sprite, Player player) {
		super(health, damage, sprite);
		this.player = player;
	}
	
	/**Should detect if the player is in aggro range
	 * I have not finished making this because my AP English teacher is a sadist
	 * @return
	 */
	public boolean isPlayerNearby() {
		return false;
	}

	/**
	 * @return the stateMachine
	 */
	public StateMachine<Enemy, EnemyState> getStateMachine() {
		return stateMachine;
	}

	/**
	 * @param stateMachine the stateMachine to set
	 */
	public void setStateMachine(StateMachine<Enemy, EnemyState> stateMachine) {
		this.stateMachine = stateMachine;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	

}
