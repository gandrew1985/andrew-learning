package com.andrzej.stream.forumuser;

import java.time.LocalDate;
import java.util.Objects;

public final class ForumUser {

    private final int idNumber;
    private final String nickName;
    private final char sex;
    private final LocalDate birthDay;
    private final int postNr;

    public ForumUser(final int idNumber, final String nickName, final char sex,
                     final LocalDate birthDay, final int postNr) {
        this.idNumber = idNumber;
        this.nickName = nickName;
        this.sex = sex;
        this.birthDay = birthDay;
        this.postNr = postNr;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getNickName() {
        return nickName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public int getPostNr() {
        return postNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumUser forumUser = (ForumUser) o;

        if(postNr != forumUser.postNr) return false;
        if(idNumber != forumUser.idNumber) return false;
        if(sex != forumUser.sex) return false;
        if(!Objects.equals(nickName, forumUser.nickName)) return false;
        return Objects.equals(birthDay,forumUser.birthDay);
    }

    @Override
    public int hashCode() {
        int result = postNr;
        result = 31 * result + idNumber;
        result = 31 * result + (int) sex;
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (birthDay != null ? birthDay.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "idNumber=" + idNumber +
                ", nickName='" + nickName + '\'' +
                ", sex=" + sex +
                ", birthDay=" + birthDay +
                ", postNr=" + postNr +
                '}';
    }
}
