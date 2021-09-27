package cn.self.design_pattern.b_state_pattern;

public class MarioStateMachine3 {

    private int score;
    private Mario currentState;

    public MarioStateMachine3() {
        this.score = 0;
        this.currentState = new SmallMarioImpl(this);
    }

    public void obtainMushroom() {
        this.currentState.obtainMushroom();
    }

    public void obtainCape() {
        this.currentState.obtainCape();
    }

    public void obtainFire() {
        this.currentState.obtainFire();
    }

    public void meetMonster() {
        this.currentState.meetMonster();
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setCurrentState(Mario currentState) {
        this.currentState = currentState;
    }

    public Mario getCurrentState() {
        return currentState;
    }

    public void getState() {
        System.out.println("currentState: " + this.currentState.getName());
        System.out.println("score: " + this.score);
    }


    public static void main(String[] args) {
        MarioStateMachine3 mario = new MarioStateMachine3();
        mario.getState();
        mario.obtainCape();
        mario.getState();
        mario.meetMonster();
        mario.getState();
        mario.obtainMushroom();
        mario.getState();
        mario.obtainFire();
        mario.getState();
    }

    /* result
        currentState: SMALL
        score: 0
        currentState: CAPE
        score: 200
        currentState: SMALL
        score: 0
        currentState: SUPER
        score: 100
        currentState: FIRE
        score: 400
     */
}
