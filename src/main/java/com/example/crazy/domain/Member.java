package com.example.crazy.domain;

public class Member {
    private String userName;

    private String password;

    private String name;

    private Integer sex;

    private Long telephone;

    private String capacity;

    private String hometown;

    private String nickname;

    private String apprise;

    private String speciality;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getApprise() {
        return apprise;
    }

    public void setApprise(String apprise) {
        this.apprise = apprise;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", telephone=").append(telephone);
        sb.append(", capacity=").append(capacity);
        sb.append(", hometown=").append(hometown);
        sb.append(", nickname=").append(nickname);
        sb.append(", apprise=").append(apprise);
        sb.append(", speciality=").append(speciality);
        sb.append("]");
        return sb.toString();
    }
}