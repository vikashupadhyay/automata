package machine;

public class State {
    private final String state;
    private boolean finalState;
    private boolean initialState;

    public State(String state) {
        this.state = state;
    }

    public void setFinalState() {
        finalState = true;
    }

    public boolean isFinalState() {
        return finalState;
    }


    public void setInitialState() {
        initialState = true;
    }

    public boolean isInitialState() {
        return initialState;
    }

}
