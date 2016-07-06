package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


import java.util.Random;

/**
 * Created by Roger-1 on 7/5/2016.
 */
public class Tube {
    public static final int TUBE_SPACE = 150;
    public static final int TUBE_WIDTH = 52;
    private Texture topTube;
    private Texture bottomTube;
    private static final int FLUCTUATION = 130;
    private static final int TUBE_GAP = 100;
    private static final int LOWEST_OPENING = 150;
    private Random random;
    private Vector2 posTop;
    private Vector2 posBot;
    private Rectangle topRect;
    private Rectangle botRect;


    public Tube(int x) {

        topTube = new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");
        random = new Random();
        posTop = new Vector2(x, random.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBot = new Vector2(x, posTop.y - TUBE_GAP - bottomTube.getHeight());
        //System.out.println(posTop.y);
        topRect = new Rectangle(x, posTop.y, topTube.getWidth(), topTube.getHeight());
        botRect = new Rectangle(x, posBot.y, bottomTube.getWidth(), bottomTube.getHeight());

    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Vector2 getPosTop() {
        return posTop;
    }

    public Vector2 getPosBot() {
        return posBot;
    }

    public void update(float x)
    {
        posTop.set(x, random.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBot.set(x, posTop.y - TUBE_GAP - bottomTube.getHeight());

        topRect.set(x, posTop.y, topTube.getWidth(), topTube.getHeight());
        botRect.set(x, posBot.y, bottomTube.getWidth(), bottomTube.getHeight());
    }

    public void dispose()
    {
        topTube.dispose();
        bottomTube.dispose();
    }

    public boolean hasCollide(Rectangle player)
    {
        return player.overlaps(topRect) || player.overlaps(botRect);
    }

}
