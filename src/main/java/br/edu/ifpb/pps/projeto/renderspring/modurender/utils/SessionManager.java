package br.edu.ifpb.pps.projeto.renderspring.modurender.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SessionManager {

    private final Map<String, Map<String, Object>> sessions = new HashMap<>();

    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, new HashMap<>());
        return sessionId;
    }

    public void addToSession(String sessionId, String key, Object value) {
        if (sessions.containsKey(sessionId)) {
            sessions.get(sessionId).put(key, value);
        }
    }

    public Object getFromSession(String sessionId, String key) {
        return sessions.containsKey(sessionId) ? sessions.get(sessionId).get(key) : null;
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}