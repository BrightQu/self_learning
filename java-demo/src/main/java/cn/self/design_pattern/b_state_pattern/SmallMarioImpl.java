package cn.self.design_pattern.b_state_pattern;

public class SmallMarioImpl extends AbstractMario {

    private MarioStateMachine3 mario;

    public SmallMarioImpl(MarioStateMachine3 mario) {
        this.mario = mario;
    }

    @Override
    public State getName() {
        return State.SMALL;
    }

    @Override
    public void obtainMushroom() {
        this.mario.setScore(this.mario.getScore() + 100);
        this.mario.setCurrentState(new SuperMarioImpl(this.mario));
    }

    @Override
    public void obtainCape() {
        this.mario.setScore(this.mario.getScore() + 200);
        this.mario.setCurrentState(new CapeMarioImpl(this.mario));
    }

    @Override
    public void obtainFire() {
        this.mario.setScore(this.mario.getScore() + 300);
        this.mario.setCurrentState(new FireMarioImpl(this.mario));
    }
}
