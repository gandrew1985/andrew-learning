package com.andrzej.testing.forum.tdd;

import com.andrzej.testing.forum.ForumComment;
import com.andrzej.testing.forum.ForumPost;
import com.andrzej.testing.forum.ForumUser;
import org.junit.*;

public class ForumTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of test ");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests completed");
    }

    @Before
    public void beforeTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddPost() {
        //Given
        ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
        ForumPost forumPost = new ForumPost("This is my firs post", "John Smith");
        //When
        forumUser.addPost(forumPost);
        int result = forumUser.getPostsQuantity();
        //Then
        Assert.assertEquals(1, result);
    }

    @Test
    public void testAddComment() {
        //Given
        ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
        ForumPost forumPost = new ForumPost("This is my firs post", "John Smith");
        ForumComment forumComment = new ForumComment(forumPost, "This is my first comment",
                "mrSmith");
        //When
        forumUser.addComment(forumComment);
        int result = forumUser.getCommentsQuantity();
        //Then
        Assert.assertEquals(1, result);
    }

    @Test
    public void testGetPost() {
        //Given
        ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
        ForumPost forumPost = new ForumPost("This is my firs post", "John Smith");
        forumUser.addPost(forumPost);
        //When
        ForumPost retrievedPost = forumUser.getPost(0);
        //Then
        Assert.assertEquals(forumPost, retrievedPost);
    }

    @Test
    public void testGetComment() {
        //Given
        ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
        ForumPost forumPost = new ForumPost("This is my firs post", "John Smith");
        ForumComment forumComment = new ForumComment(forumPost, "This is my first comment",
                "mrSmith");
        forumUser.addComment(forumComment);
        //When
        ForumComment retrievedComment = forumUser.getComment(0);
        //Then
        Assert.assertEquals(forumComment, retrievedComment);
    }

    @Test
    public void testRemovePostNotExisting() {
        //Given
        ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
        ForumPost forumPost = new ForumPost("This is my firs post", "John Smith");
        //When
        boolean removedPost = forumUser.removePost(forumPost);
        //Then
        Assert.assertFalse(removedPost);
    }

    @Test
    public void testRemoveCommentNotExisting() {
        //Given
        ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
        ForumPost forumPost = new ForumPost("This is my firs post", "John Smith");
        ForumComment forumComment = new ForumComment(forumPost, "This is my first comment",
                "mrSmith");
        //When
        boolean removedComment = forumUser.removeComment(forumComment);
        //Then
        Assert.assertFalse(removedComment);
    }

    @Test
    public void testRemovePost() {
        //Given
        ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
        ForumPost forumPost = new ForumPost("This is my firs post", "John Smith");
        forumUser.addPost(forumPost);
        //When
        boolean removedPost = forumUser.removePost(forumPost);
        //Then
        Assert.assertTrue(removedPost);
        Assert.assertEquals(0, forumUser.getPostsQuantity());
    }

    @Test
    public void testRemoveComment() {
        //Given
        ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
        ForumPost forumPost = new ForumPost("This is my firs post", "John Smith");
        ForumComment forumComment = new ForumComment(forumPost, "This is my first comment",
                "mrSmith");
        forumUser.addComment(forumComment);
        //When
        boolean removeComment = forumUser.removeComment(forumComment);
        //Then
        Assert.assertTrue(removeComment);
        Assert.assertEquals(0,forumUser.getCommentsQuantity());
    }
}
