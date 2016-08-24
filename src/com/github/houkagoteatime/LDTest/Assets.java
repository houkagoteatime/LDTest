package com.github.houkagoteatime.LDTest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable, AssetErrorListener{

	private static Assets instance = null;
	private AssetManager manager;
	public static final String TAG = Assets.class.getName();
	
	private Assets() {
		manager = new AssetManager();
		manager.setErrorListener(this);
		manager.load("lib/harambe.jpg", Texture.class);
	}

	/**
	 * @return the instance
	 */
	public static Assets getInstance() {
		if(instance == null)
			instance = new Assets();
		return instance;
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.assets.AssetErrorListener#error(com.badlogic.gdx.assets.AssetDescriptor, java.lang.Throwable)
	 */
	@Override
	public void error(AssetDescriptor descriptor, Throwable throwable) {
		Gdx.app.error(TAG, "Error could not load" + descriptor.fileName, (Exception)throwable);
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.utils.Disposable#dispose()
	 */
	@Override
	public void dispose() {
		manager.dispose();
	}

	/**
	 * @return the manager
	 */
	public AssetManager getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(AssetManager manager) {
		this.manager = manager;
	}
	
	/**
	 * updates the asset manager
	 */
	public boolean update() {
		return manager.update();
	}

}
