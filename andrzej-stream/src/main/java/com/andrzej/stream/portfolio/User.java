package com.andrzej.stream.portfolio;

import java.util.Objects;

public final class User {

    private final String userName;
    private final String realName;

    public User(String userName, String realName) {
        this.userName = userName;
        this.realName = realName;
    }

    public String getUserName() {
        return userName;
    }

    public String getRealName() {
        return realName;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o==null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return Objects.equals(userName,user.userName);
    }

    @Override
    public int hashCode() {
        int result = (userName != null ? userName.hashCode() : 0);
        return 31 * result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
