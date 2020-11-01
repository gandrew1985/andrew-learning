package com.andrzej.exception.nullpointer;

public class MessageSender {

    public void sendMessage(User user, String message) throws MessageNotSentException {
        try {
            System.out.println("Sending message: " + message + " to User: " + user.getName());
        } catch (NullPointerException e){
            throw new MessageNotSentException("Object user is null");
        }
    }
}
