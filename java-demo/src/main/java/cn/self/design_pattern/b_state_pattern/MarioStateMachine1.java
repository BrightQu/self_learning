package cn.self.design_pattern.b_state_pattern;


/**
 * Mario状态机
 * 实现方式一：分支逻辑法
 *
 * 有限状态机：状态State、事件Event、动作Action，事件（或转移条件）触发状态的转移及动作的执行。
 *
 */
public class MarioStateMachine1 {

    private int score;
    private State currentState;

    public MarioStateMachine1() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    public void obtainMushroom() {
        if (this.currentState.equals(State.SMALL)) {
            this.score += 100;
            this.currentState = State.SUPER;
        }
    }

    public void obtainCape() {
        if (this.currentState.equals(State.SMALL) || this.currentState.equals(State.SUPER)) {
            this.score += 200;
            this.currentState = State.CAPE;
        }
    }

    public void obtainFire() {
        if (this.currentState.equals(State.SMALL) || this.currentState.equals(State.SUPER)) {
            this.score += 300;
            this.currentState = State.FIRE;
        }
    }

    public void meetMonster() {
        if (this.currentState.equals(State.SUPER)) {
            this.score -= 100;
        } else if (this.currentState.equals(State.CAPE)) {
            this.score -= 200;
        } else if (this.currentState.equals(State.FIRE)) {
            this.score -= 300;
        }
        this.currentState = State.SMALL;
    }

    public void getState() {
        System.out.println("currentState: " + this.currentState.getValue());
        System.out.println("score: " + this.score);
    }


    public static void main(String[] args) {
        MarioStateMachine1 mario = new MarioStateMachine1();
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
        currentState: 0
        score: 0
        currentState: 2
        score: 200
        currentState: 0
        score: 0
        currentState: 1
        score: 100
        currentState: 3
        score: 400
     */
}
