package machine;

import java.util.HashMap;

public class TransitionFunction {
    HashMap<String, HashMap<Character,String >> transitionFunc = new HashMap<>();
    public void setTransition(String previousState, String nextSate, char transition) {
        transitionFunc.putIfAbsent(previousState,new HashMap<>());
        transitionFunc.get(previousState).put(transition,nextSate);
    }

    public String process(String currentState, char transition) {
        return transitionFunc.get(currentState).get(transition);
    }
}
