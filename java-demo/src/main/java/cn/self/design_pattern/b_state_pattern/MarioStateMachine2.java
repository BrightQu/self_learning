package cn.self.design_pattern.b_state_pattern;


/**
 * Mario状态机
 * 实现方式一：查表法
 *
 *          GOTM        GOTC        GOTF        MEETM
 *  SMALL   SUPER/+100  CAPE/+200   FIRE/+300   /
 *  SUPER   /           CAPE/+200   FIRE/+300   SMALL/-100
 *  CAPE    /           /           /           SMALL/-200
 *  FIRE    /           /           /           SMALL/-300
 */
public class MarioStateMachine2 {

    private int score;
    private State currentState;

    private static final State[][] stateTable = {
            {State.SUPER, State.CAPE, State.FIRE, State.SMALL},
            {State.SUPER, State.CAPE, State.FIRE, State.SMALL},
            {State.CAPE,  State.CAPE, State.CAPE, State.SMALL},
            {State.FIRE,  State.FIRE, State.FIRE, State.SMALL}
    };

    private static final int[][] scoreTable = {
            {+100, +200, +300, +0},
            {+0,   +200, +300, -100},
            {+0,   +0,   +0,   -200},
            {+0,   +0,   +0,   -300}
    };

    public MarioStateMachine2() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    public void obtainMushroom() {
        executeEvent(Event.OBTAIN_MUSHROOM);
    }

    public void obtainCape() {
        executeEvent(Event.OBTAIN_CAPE);
    }

    public void obtainFire() {
        executeEvent(Event.OBTAIN_FIRE);
    }

    public void meetMonster() {
        executeEvent(Event.MEET_MONSTER);
    }

    private void executeEvent(Event event) {
        int stateValue = currentState.getValue();
        int eventValue = event.getValue();
        this.currentState = stateTable[stateValue][eventValue];
        this.score += scoreTable[stateValue][eventValue];
    }

    public void getState() {
        System.out.println("currentState: " + this.currentState.getValue());
        System.out.println("score: " + this.score);
    }


    public static void main(String[] args) {
        MarioStateMachine2 mario = new MarioStateMachine2();
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
