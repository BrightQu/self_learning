package cn.self.design_pattern.b_state_pattern;

public class SuperMarioImpl extends AbstractMario {

    private MarioStateMachine3 mario;

    public SuperMarioImpl(MarioStateMachine3 mario) {
        this.mario = mario;
    }

    @Override
    public State getName() {
        return State.SUPER;
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

    @Override
    public void meetMonster() {
        this.mario.setScore(this.mario.getScore() - 100);
        this.mario.setCurrentState(new SmallMarioImpl(this.mario));
    }
}
