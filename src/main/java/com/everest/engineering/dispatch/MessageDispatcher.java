package com.everest.engineering.dispatch;

import com.everest.engineering.message.Message;

import java.util.List;
import java.util.Map;

public interface MessageDispatcher {
    public abstract Map<String, List<String>> dispatch(List<Message> messages);
}
