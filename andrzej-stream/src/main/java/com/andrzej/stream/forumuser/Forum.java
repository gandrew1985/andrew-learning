package com.andrzej.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> theForumUserList = new ArrayList<>();

    public Forum() {
        theForumUserList.add(new ForumUser(1, "Johny", 'M',
                LocalDate.of(1980, 12, 20), 12));
        theForumUserList.add(new ForumUser(2, "Nicki", 'F',
                LocalDate.of(1987, 9, 12), 10));
        theForumUserList.add(new ForumUser(3, "Goldi", 'M',
                LocalDate.of(1999, 1, 29), 29));
        theForumUserList.add(new ForumUser(4, "Mavrick", 'M',
                LocalDate.of(2001, 5, 14), 38));
        theForumUserList.add(new ForumUser(5, "Katja", 'F',
                LocalDate.of(2003, 2, 6), 47));
    }

    public List<ForumUser> getList() {
        return new ArrayList<>(theForumUserList);
    }
}
