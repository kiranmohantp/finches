package com.finches.finchesservice.models.response;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse {
    private List<String> messages;

    public ValidationErrorResponse(){
        messages = new ArrayList<String>(4);
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
