package br.edu.ifpb.pps.projeto.renderspring.modurender.utils;

import java.time.LocalDateTime;

public class Logger {

    public void info(String message) {
        log("INFO", message);
    }

    public void error(String message) {
        log("ERROR", message);
    }

    public void debug(String message) {
        log("DEBUG", message);
    }

    private void log(String level, String message) {
        String timestamp = LocalDateTime.now().toString();
        System.out.println("[" + timestamp + "] [" + level + "] " + message);
    }
}