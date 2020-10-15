package com.andrzej.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

public class StatisticsCounterTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTest() {
        System.out.println("Preparing for execute tests!!!!");
    }

    @Before
    public void beforeEachTest() {
        testCounter++;
        System.out.println("Executing test #" + testCounter);
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests completed");
    }

    @Test
    public void testWhen100Users() {
        //When
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersName = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            usersName.add("bolek" + i);
        }
        when(statisticsMock.usersName()).thenReturn(usersName);
        when(statisticsMock.commentsCount()).thenReturn(300);
        when(statisticsMock.postsCount()).thenReturn(150);
        StatisticsCounter counter = new StatisticsCounter();
        //When
        counter.calculateStatistics(statisticsMock);
        int userNr = statisticsMock.usersName().size();
        int postNumber = statisticsMock.postsCount();
        int commentsNumber = statisticsMock.commentsCount();
        double avgPostPerUser = counter.getAveragePostQuantityPerUser();
        double avgCommPerPost = counter.getAverageCommentQuantityPerPost();
        double avgCommPerUser = counter.getAverageCommentsPerUser();
        //Then
        Assert.assertEquals(100,userNr);
        Assert.assertEquals(300,commentsNumber);
        Assert.assertEquals(150,postNumber);
        Assert.assertEquals(1,avgPostPerUser,0);
        Assert.assertEquals(2,avgCommPerPost,0);
        Assert.assertEquals(3,avgCommPerUser,0);
    }

    @Test
    public void testWhen0Users() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users = new ArrayList<>();
        when(statisticsMock.usersName()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(150);
        when(statisticsMock.commentsCount()).thenReturn(300);
        StatisticsCounter statisticsCounter = new StatisticsCounter();
        //When
        statisticsCounter.calculateStatistics(statisticsMock);
        int userNr = statisticsMock.usersName().size();
        int postNr = statisticsMock.postsCount();
        int commNr = statisticsMock.commentsCount();
        double avgPostPerUser = statisticsCounter.getAveragePostQuantityPerUser();
        double avgCommPerUser = statisticsCounter.getAverageCommentsPerUser();
        double avgCommPerPost = statisticsCounter.getAverageCommentQuantityPerPost();
        //Then
        assertEquals(0,userNr);
        assertEquals(150,postNr);
        assertEquals(300,commNr);
        assertEquals(0,avgPostPerUser,0);
        assertEquals(0,avgCommPerUser,0);
        assertEquals(2,avgCommPerPost,0);
    }

    @Test
    public void testWhenMoreCommentsThanPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users = new ArrayList<>();
        when(statisticsMock.usersName()).thenReturn(users);
        when(statisticsMock.commentsCount()).thenReturn(760);
        when(statisticsMock.postsCount()).thenReturn(100);
        StatisticsCounter statisticsCounter = new StatisticsCounter();
        //When
        statisticsCounter.calculateStatistics(statisticsMock);
        boolean result = statisticsMock.commentsCount() > statisticsMock.postsCount();
        int userQuantity = statisticsMock.usersName().size();
        int commQuantity = statisticsMock.commentsCount();
        int postQuantity = statisticsMock.postsCount();
        double avgPostPerUser = statisticsCounter.getAveragePostQuantityPerUser();
        double avgCommPerUser = statisticsCounter.getAverageCommentsPerUser();
        double avgCommPerPost = statisticsCounter.getAverageCommentQuantityPerPost();
        //Then
        assertTrue(result);
        assertEquals(0,userQuantity);
        assertEquals(760,commQuantity);
        assertEquals(100,postQuantity);
        assertEquals(0,avgPostPerUser,0);
        assertEquals(7,avgCommPerPost,0);
        assertEquals(0,avgCommPerUser,0);

    }
}
