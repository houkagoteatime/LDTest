package com.github.houkagoteatime.entities.enemies;

import com.badlogic.gdx.ai.fsm.State;
import com.badlogic.gdx.ai.fsm.StateMachine;
import com.badlogic.gdx.ai.msg.Telegram;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.houkagoteatime.entities.Entity;
import com.github.houkagoteatime.entities.Player;

public class Enemy extends Entity{

	private StateMachine<Enemy, EnemyState> stateMachine;
	private Player player;
	
	public enum EnemyState implements State<Enemy> {
		
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
	public Enemy(int health, int damage, Sprite sprite, Player player) {
		super(health, damage, sprite);
		this.player = player;
	}
	
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
