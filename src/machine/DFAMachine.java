package machine;

public class DFAMachine {
    private final States states;
    private final TransitionFunction transitionFunction;
    private final String initialState;

    public DFAMachine(States states, TransitionFunction transitionFunction, String initialState) {
        this.states = states;
        this.transitionFunction = transitionFunction;
        this.initialState = initialState;
    }

    public boolean isRecognizes(String pattern) {
        String currentState = initialState;
        for (char transition : pattern.toCharArray()) {
                currentState= transitionFunction.process(currentState, transition);
                if(currentState == null) {
                    return false;
                }
        }
        return states.isFinalState(currentState);
    }
}
