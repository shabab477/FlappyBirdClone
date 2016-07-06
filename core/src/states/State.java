package states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Shabab on 7/5/2016.
 */
public abstract class State {
    protected OrthographicCamera camera;
    protected Vector3 mousePoint;
    protected GameStateManager gameStateManager;

    public State(GameStateManager gameStateManager)
    {
        this.gameStateManager = gameStateManager;
        camera = new OrthographicCamera();
        mousePoint = new Vector3();

    }

    protected abstract void handleGameInput();
    protected abstract void update(float delta);
    protected abstract void render(SpriteBatch spriteBatch);
    protected abstract void dispose();
}
