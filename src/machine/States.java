package machine;

import java.util.ArrayList;
import java.util.List;

public class States {

    private String initialState;
    private List<String> states=new ArrayList<String>();
    private List<String> finalStates =new ArrayList<String>();

    public void setFinalState(String finalState) {
        if(states.contains(finalState))
            finalStates.add(finalState);
    }

    public void setInitialState(String initialState) {
        this.initialState = initialState;
    }

    public String getInitialState() {
        return initialState;
    }

    public boolean isInitialState(String state) {
        return states.contains(state) && state.equals(initialState);
    }

    public boolean isFinalState(String state) {
        return finalStates.contains(state);
    }

    public int size() {
        return states.size();
    }

    public void add(String state) {
        states.add(state);
    }
}
