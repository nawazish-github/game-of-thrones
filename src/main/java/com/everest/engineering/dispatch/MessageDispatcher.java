package com.everest.engineering.dispatch;

import com.everest.engineering.message.AbstractMessage;

import java.util.List;
import java.util.Map;

public interface MessageDispatcher {
    public abstract Map<String, List<String>> dispatch(List<AbstractMessage> abstractMessages);
}
