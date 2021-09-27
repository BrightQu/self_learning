package cn.self.design_pattern.b_state_pattern;

public abstract class AbstractMario implements Mario {

    @Override
    public void obtainMushroom() {
        throw new UnsupportedOperationException("接口未实现");
    }

    @Override
    public void obtainCape() {
        throw new UnsupportedOperationException("接口未实现");
    }

    @Override
    public void obtainFire() {
        throw new UnsupportedOperationException("接口未实现");
    }

    @Override
    public void meetMonster() {
        throw new UnsupportedOperationException("接口未实现");
    }
}
