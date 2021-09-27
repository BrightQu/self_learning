package cn.self.oop.advanced.dynamic_proxy;

public class UserImpl implements IUser {

    private int age;
    private String name;

    public UserImpl(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String printUser() {
        String userInfo = new StringBuilder()
                .append("User printUser: [age=")
                .append(age)
                .append(", name=")
                .append(name)
                .append("]")
                .toString();
        return userInfo;
    }
}
