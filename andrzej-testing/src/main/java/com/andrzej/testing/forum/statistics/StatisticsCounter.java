package com.andrzej.testing.forum.statistics;

public class StatisticsCounter {

    private int usersQuantity;
    private int postsQuantity;
    private int commentsQuantity;
    private double averagePostQuantityPerUser;
    private double averageCommentsPerUser;
    private double averageCommentQuantityPerPost;

    public int getUsersQuantity() {
        return usersQuantity;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

    public int getCommentsQuantity() {
        return commentsQuantity;
    }

    public double getAveragePostQuantityPerUser() {
        return averagePostQuantityPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentQuantityPerPost() {
        return averageCommentQuantityPerPost;
    }

    public void calculateStatistics(Statistics statistics) {
        this.usersQuantity = statistics.usersName().size();
        this.postsQuantity = statistics.postsCount();
        this.commentsQuantity = statistics.commentsCount();

        if (usersQuantity > 0 && postsQuantity > 0) {
            this.averagePostQuantityPerUser = postsQuantity / usersQuantity;
        } else {
            this.averagePostQuantityPerUser = 0;
        }
        if (commentsQuantity > 0 && usersQuantity > 0) {
            this.averageCommentsPerUser = commentsQuantity / usersQuantity;
        } else {
            this.averageCommentsPerUser = 0;
        }
        if (postsQuantity > 0 && commentsQuantity > 0) {
            this.averageCommentQuantityPerPost = commentsQuantity / postsQuantity;
        } else {
            this.averageCommentQuantityPerPost = 0;
        }
    }

    public String showStatistics() {
        return "User numbers: " + getUsersQuantity() + "\nPost Quantity: " + getPostsQuantity() +
                "\nComment Quantity: " + getCommentsQuantity() +
                "\nAverage Post per User: " + getAveragePostQuantityPerUser() +
                "\nAverage comments per User: " + getAverageCommentsPerUser() +
                "\nAverage Comments per Post: " + getAverageCommentQuantityPerPost();
    }
}
