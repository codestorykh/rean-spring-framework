package com.rean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") //singleton default value
public class Message {

    private String messageBot;

    public Message(){}

    public String getMessageBot() {
        return messageBot;
    }

    public void setMessageBot(String messageBot) {
        this.messageBot = messageBot;
    }
}
