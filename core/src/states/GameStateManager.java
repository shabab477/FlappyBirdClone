package states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by Shabab on 7/5/2016.
 */
public class GameStateManager {

    private Stack<State> stackStates;

    public GameStateManager() {
        stackStates = new Stack<State>();
    }

    public void push(State state)
    {
        stackStates.push(state);
    }

    public void pop()
    {
        stackStates.pop();
    }

    public void setState(State state)
    {
        pop();
        push(state);
    }

    public void update(float dt)
    {
        stackStates.peek().update(dt);
    }

    public void render(SpriteBatch batch)
    {
        stackStates.peek().render(batch);
    }


}
