package com.shabab.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import states.GameStateManager;
import states.MenuState;

public class MyFlappySuperman extends ApplicationAdapter {

	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "Flappy Bird Clone";
	private Music music;

	SpriteBatch batch;
	GameStateManager gameStateManager;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gameStateManager = new GameStateManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gameStateManager.push(new MenuState(gameStateManager));
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameStateManager.update(Gdx.graphics.getDeltaTime());
		gameStateManager.render(batch);
	}

	@Override
	public void dispose() {
		super.dispose();
		music.dispose();
	}
}
