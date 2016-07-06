package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;


/**
 * Created by Shabab on 7/5/2016.
 */
public class Ground{

    public static final int GROUND_OFFSET = -40;
    private Texture groundTexture;
    private Vector2 grPos1;
    private Vector2 grPos2;

    public Ground(float x)
    {
        groundTexture = new Texture("ground.png");
        grPos1 = new Vector2(x, GROUND_OFFSET);
        grPos2 = new Vector2(x + groundTexture.getWidth(), GROUND_OFFSET);

    }

    public void dispose()
    {
        groundTexture.dispose();
    }

    public void updateGround1()
    {
        grPos1.x += groundTexture.getWidth() * 2;

    }

    public void updateGround2()
    {
        grPos2.x += groundTexture.getWidth() * 2;
    }


    public Texture getGroundTexture() {
        return groundTexture;
    }

    public Vector2 getGrPos1() {
        return grPos1;
    }

    public Vector2 getGrPos2() {
        return grPos2;
    }
}
