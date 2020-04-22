package edu.sspu.bike.model;

/**
 * @auther 杨亚龙
 * @date 2019/11/4 15:59
 */
public class User {
    private String stuId;
    private String name;
    private String password;
    private int role;

    public User() {
    }


    public User(String stuId, String name) {
        this.stuId = stuId;
        this.name = name;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "stuId='" + stuId + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
