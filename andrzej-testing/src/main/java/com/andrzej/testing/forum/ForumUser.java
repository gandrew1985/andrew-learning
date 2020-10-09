package com.andrzej.testing.forum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ForumUser {

    private String name;
    private String realName;
    private List<ForumPost> posts = new ArrayList<>();
    private List<ForumComment> comments = new LinkedList<>();

    public ForumUser(String name, String realName) {
        this.name = name;
        this.realName = realName;
    }

    public void addPost(ForumPost forumPost) {
        posts.add(forumPost);
    }

    public void addComment(ForumComment forumComment) {
        comments.add(forumComment);
    }

    public int getPostsQuantity() {
        return posts.size();
    }

    public int getCommentsQuantity() {
        return comments.size();
    }

    public ForumPost getPost(int postNumber) {
        ForumPost thePost = null;
        if(postNumber >= 0 || postNumber < posts.size()) {
            thePost = posts.get(postNumber);
        }
        return thePost;
    }

    public ForumComment getComment(int commentNumber) {
        ForumComment theComment = null;
        if(commentNumber >= 0 || commentNumber < comments.size()) {
            theComment = comments.get(commentNumber);
        }
        return theComment;
    }

    public boolean removePost(ForumPost thePost) {
        boolean result = false;
        if(posts.contains(thePost)) {
            posts.remove(thePost);
            result = true;
        }
        return result;
    }

    public boolean removeComment(ForumComment theComment) {
        boolean removed = false;
        if(comments.contains(theComment)) {
            comments.remove(theComment);
            removed = true;
        }
        return removed;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }
}
