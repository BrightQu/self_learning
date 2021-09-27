package cn.self.design_pattern.b_state_pattern;

public enum Event {
    OBTAIN_MUSHROOM(0),
    OBTAIN_CAPE(1),
    OBTAIN_FIRE(2),
    MEET_MONSTER(3);

    private int value;

    Event (int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
