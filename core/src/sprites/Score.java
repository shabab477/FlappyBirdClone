package sprites;

/**
 * Created by Shabab on 7/7/2016.
 */
public class Score {
    private int score;
    private float currentTime;
    private float maxTime;

    public Score(float maxTime)
    {
        score = 0;
        currentTime = 0;
        this.maxTime = maxTime;
    }

    @Override
    public String toString() {
        return String.format("%05d", score);
    }

    private void increaseScore()
    {
        score++;
    }

    public void update(float dt)
    {
        currentTime += dt;
        if(currentTime >= maxTime)
        {
            currentTime = 0;
            increaseScore();
        }
    }
}
