package cn.self.design_pattern.b_state_pattern;

public class CapeMarioImpl extends AbstractMario {

    private final int SCORE_CHANGE = 200;

    private MarioStateMachine3 mario;

    public CapeMarioImpl(MarioStateMachine3 mario) {
        this.mario = mario;
    }

    @Override
    public State getName() {
        return State.CAPE;
    }

    @Override
    public void meetMonster() {
        this.mario.setScore(this.mario.getScore() - SCORE_CHANGE);
        this.mario.setCurrentState(new SmallMarioImpl(this.mario));
    }
}
