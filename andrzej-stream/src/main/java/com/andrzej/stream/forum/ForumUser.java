package com.andrzej.stream.forum;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public final class ForumUser {

    private final String userName;
    private final String realName;
    private final String location;
    private final Set<ForumUser> friends = new HashSet<>();

    public ForumUser(final String userName, final String realName, final String location) {
        this.userName = userName;
        this.realName = realName;
        this.location = location;
    }

    public boolean removeFriend(ForumUser user) {
        return friends.remove(user);
    }

    public void addFriend(ForumUser user) {
        friends.add(user);
    }

    public Set<String> getLocationOfFriends() {
        return friends.stream()
                .map(friend -> friend.getLocation())
                .collect(Collectors.toSet());
    }

    public Set<String> getLocationsOfFriendsOfFriends() {
        return friends.stream()
                .flatMap(friends -> getFriends().stream())
                .filter(forumUser -> forumUser != this)
                .map(friends -> friends.getLocation())
                .collect(Collectors.toSet());
    }

    public String getUserName() {
        return userName;
    }

    public String getRealName() {
        return realName;
    }

    public String getLocation() {
        return location;
    }

    public Set<ForumUser> getFriends() {
        return friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumUser f = (ForumUser) o;

        return Objects.equals(userName, f.userName);
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result;
        return result;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
