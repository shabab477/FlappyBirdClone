package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.shabab.game.MyFlappySuperman;

/**
 * Created by Shabab on 7/7/2016.
 */
public class GameOverState extends State {

    Texture bg;
    Texture gameOver;


    public GameOverState(GameStateManager gameStateManager) {
        super(gameStateManager);
        camera.setToOrtho(false, MyFlappySuperman.WIDTH / 2, MyFlappySuperman.HEIGHT / 2);

        bg = new Texture("bg.png");
        gameOver = new Texture("gameover.png");
    }

    @Override
    protected void handleGameInput() {
        if(Gdx.input.justTouched())
        {
            dispose();
            gameStateManager.setState(new PlayState(gameStateManager));
        }
    }

    @Override
    protected void update(float delta) {
        handleGameInput();
    }

    @Override
    protected void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(bg, camera.position.x - (camera.viewportWidth / 2), 0);
        spriteBatch.draw(gameOver, camera.position.x - (gameOver.getWidth() / 2), camera.position.y);
        spriteBatch.end();
    }

    @Override
    protected void dispose() {
        bg.dispose();
        gameOver.dispose();
    }
}
