package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.shabab.game.MyFlappySuperman;

/**
 * Created by Shabab on 7/5/2016.
 */
public class MenuState extends State {

    private Texture background;
    private Texture playButton;


    public MenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
        background = new Texture("bg.png");
        playButton = new Texture("playbtn.png");
        camera.setToOrtho(false, MyFlappySuperman.WIDTH / 2, MyFlappySuperman.HEIGHT / 2);

    }

    @Override
    protected void handleGameInput() {
        if(Gdx.input.justTouched())
        {
            gameStateManager.setState(new PlayState(gameStateManager));
            this.dispose();
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
        spriteBatch.draw(background, 0, 0);
        spriteBatch.draw(playButton, (camera.position.x) - (playButton.getWidth() / 2), camera.position.y);
        spriteBatch.end();
    }

    @Override
    protected void dispose() {
        playButton.dispose();
        background.dispose();
    }
}
