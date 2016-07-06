package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.shabab.game.MyFlappySuperman;

import java.util.ArrayList;

import sprites.Bird;
import sprites.Ground;
import sprites.Score;
import sprites.Tube;

/**
 * Created by Shabab on 7/5/2016.
 */
public class PlayState extends State {

    private Bird sMan;
    private Texture bg;
    private ArrayList<Tube> list;
    private Ground ground;
    private BitmapFont font;
    private Score score;

    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        sMan = new Bird(50, 300);

        font = new BitmapFont();
        score = new Score(1.0f);

        camera.setToOrtho(false, MyFlappySuperman.WIDTH / 2, MyFlappySuperman.HEIGHT / 2);
        bg = new Texture("bg.png");
        list = new ArrayList<Tube>();
        ground = new Ground(camera.position.x - (camera.viewportWidth / 2));

        for(int c = 1; c <= 4; c++)
        {
            list.add(new Tube(c * (Tube.TUBE_SPACE + Tube.TUBE_WIDTH)));
        }
    }

    @Override
    protected void handleGameInput() {
        if(Gdx.input.justTouched())
        {
            sMan.jump();
        }
    }

    @Override
    protected void update(float delta) {
        handleGameInput();
        sMan.update(delta);
        camera.position.x = sMan.getPosition().x + 80;
        camera.update();

        groundUpdate();
        score.update(delta);
        checkCollisionGround();
        boolean flag = false;

        for(int c = 0; c < 4; c++)
        {
            Tube tempTube = list.get(c);
            if(tempTube.getPosTop().x + Tube.TUBE_WIDTH <= camera.position.x - (camera.viewportWidth / 2))
            {
                tempTube.update(tempTube.getPosTop().x + ((Tube.TUBE_SPACE + Tube.TUBE_WIDTH) * 4));

            }

            if(tempTube.hasCollide(sMan.getBirdRect()))
            {
                flag = true;
                break;
            }
        }

        if(flag)
        {
            dispose();
            gameStateManager.setState(new GameOverState(gameStateManager));
        }


    }

    private void checkCollisionGround()
    {
        if(sMan.getPosition().y <= ground.getGroundTexture().getHeight() + Ground.GROUND_OFFSET)
        {
            dispose();
            gameStateManager.setState(new GameOverState(gameStateManager));
        }
    }

    private void groundUpdate()
    {
        if(ground.getGrPos1().x + ground.getGroundTexture().getWidth() <= (camera.position.x - (camera.viewportWidth / 2)))
        {
            ground.updateGround1();
        }

        if(ground.getGrPos2().x + ground.getGroundTexture().getWidth() <= (camera.position.x - (camera.viewportWidth / 2)))
        {
            ground.updateGround2();
        }
    }


    @Override
    protected void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(bg, camera.position.x - (camera.viewportWidth / 2), 0);
        font.draw(spriteBatch, score.toString(), camera.position.x - (camera.viewportWidth / 2), camera.position.y + (camera.viewportHeight / 2));
        spriteBatch.draw(sMan.getBird(), sMan.getPosition().x, sMan.getPosition().y);
        drawTube(spriteBatch);
        spriteBatch.draw(ground.getGroundTexture(), ground.getGrPos1().x, ground.getGrPos1().y);
        spriteBatch.draw(ground.getGroundTexture(), ground.getGrPos2().x, ground.getGrPos2().y);
        spriteBatch.end();

    }

    private void drawTube(SpriteBatch batch)
    {
        for(int c = 0; c < 4; c++)
        {
            Tube temp = list.get(c);
            batch.draw(temp.getTopTube(), temp.getPosTop().x, temp.getPosTop().y);
            batch.draw(temp.getBottomTube(), temp.getPosBot().x, temp.getPosBot().y);
        }
    }


    @Override
    protected void dispose() {
        bg.dispose();
        sMan.dispose();
        for(Tube t : list)
        {
            t.dispose();
        }
    }
}
