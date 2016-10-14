package machine;

import java.util.HashMap;

public class TransitionFunction {
    HashMap<State, HashMap<Character,State >> transitionFunc = new HashMap<>();
    public void setTransition(State previousState, State nextSate, char transition) {
        transitionFunc.putIfAbsent(previousState,new HashMap<>());
        transitionFunc.get(previousState).put(transition,nextSate);
    }

    public State process(State currentState, char transition) {
        return transitionFunc.get(currentState).get(transition);
    }
}
