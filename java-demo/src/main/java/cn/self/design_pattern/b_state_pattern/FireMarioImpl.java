package cn.self.design_pattern.b_state_pattern;

public class FireMarioImpl extends AbstractMario {

    private final int SCORE_CHANGE = 300;

    private MarioStateMachine3 mario;

    public FireMarioImpl(MarioStateMachine3 mario) {
        this.mario = mario;
    }

    @Override
    public State getName() {
        return State.FIRE;
    }

    @Override
    public void meetMonster() {
        this.mario.setScore(this.mario.getScore() - SCORE_CHANGE);
        this.mario.setCurrentState(new SmallMarioImpl(this.mario));
    }
}
