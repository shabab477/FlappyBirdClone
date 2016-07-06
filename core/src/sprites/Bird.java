package sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Shabab on 7/5/2016.
 */
public class Bird {
    private final int MOVE_BY_X = 140;
    private final int GRAVITY = -15;
    private Animation animation;
    private Vector3 velocity;
    private Vector3 position;
    private Rectangle birdRect;

    private Sound flapSound;

    public Bird(int x, int y)
    {
        animation = new Animation(new TextureRegion(new Texture("birdanimation.png")), 3, 0.5f);
        velocity = new Vector3(0, 0, 0);
        position = new Vector3(x, y, 0);
        birdRect = new Rectangle(position.x, position.y, animation.getTexture().getRegionWidth()
            , animation.getTexture().getRegionHeight());
        flapSound = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));

    }

    public void update(float dt) {

        if(position.y >= 0)
        {
            velocity.add(0, GRAVITY, 0);
        }

        velocity.scl(dt);
        position.add(dt * MOVE_BY_X, velocity.y, 0);
        //System.out.println(velocity.y);
        if(position.y < 0)
        {
            position.y = 0;
        }
        velocity.scl(1 / dt);
        animation.update(dt);

        birdRect.set(position.x, position.y, animation.getTexture().getRegionWidth(), animation.getTexture().getRegionHeight());

    }

    public Rectangle getBirdRect() {
        return birdRect;
    }

    public TextureRegion getBird() {
        return animation.getTexture();
    }

    public Vector3 getPosition() {
        return position;
    }

    public void jump()
    {
        velocity.y = 250;
        flapSound.play(0.5f);
    }

    public void dispose()
    {
        animation.dispose();
    }


}
