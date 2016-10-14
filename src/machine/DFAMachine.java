package machine;

import java.util.List;

public class DFAMachine {
    private final TransitionFunction transitionFunction;
    private final State initialState;

    public DFAMachine(TransitionFunction transitionFunction, State initialState) {
        this.transitionFunction = transitionFunction;
        this.initialState = initialState;
    }

    public boolean isRecognizes(String pattern) {
        State currentState = initialState;
        for (char transition : pattern.toCharArray()) {
            currentState = transitionFunction.process(currentState, transition);
            if (currentState == null) {
                return false;
            }
        }
        return currentState.isFinalState();
    }
}
