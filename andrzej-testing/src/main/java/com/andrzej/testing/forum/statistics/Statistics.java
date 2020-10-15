package com.andrzej.testing.forum.statistics;

import java.util.List;

public interface Statistics {
    List<String> usersName();
    int postsCount();
    int commentsCount();
}
