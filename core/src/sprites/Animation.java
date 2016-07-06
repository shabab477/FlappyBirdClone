package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

/**
 * Created by Shabab on 7/5/2016.
 */
public class Animation {

    private ArrayList<TextureRegion> list;
    private int frame;
    private float currentFrameTime;
    private float maxFrameTime;
    private int frameCount;
    private int frameWidth;

    public Animation(TextureRegion region, int frameCount, float maxFrameTime)
    {
        frameWidth = region.getRegionWidth() / frameCount;
        this.frameCount = frameCount;
        this.maxFrameTime = maxFrameTime;
        System.out.println(frameWidth);
        list = new ArrayList<TextureRegion>();
        frame = 0;

        for(int c = 0; c < frameCount; c++)
        {
            list.add(new TextureRegion(region, (c * frameWidth), 0, frameWidth, region.getRegionHeight()));
        }
    }

    public void update(float dt)
    {
        currentFrameTime += dt;
        if(currentFrameTime >= maxFrameTime)
        {
            frame = (frame + 1) % frameCount;
            currentFrameTime = 0;
        }
    }

    public TextureRegion getTexture()
    {
        return list.get(frame);
    }

    public void dispose()
    {
        for(TextureRegion tx : list)
        {
            tx.getTexture().dispose();
        }
    }


}
