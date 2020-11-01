package com.andrzej.exception.nullpointer;

public class NullPointerRunner {

    public static void main (String[] args) throws MessageNotSentException {

        User user = null;
        MessageSender messageSender = new MessageSender();
        messageSender.sendMessage(user,"Hello");
    }

}
