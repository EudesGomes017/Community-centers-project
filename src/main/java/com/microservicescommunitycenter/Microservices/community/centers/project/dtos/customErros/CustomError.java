package com.microservicescommunitycenter.Microservices.community.centers.project.dtos.customErros;

import java.time.Instant;
import java.util.Map;

public class CustomError {

    private Instant timestamp;
    private int status;
    private String message;
    private String path;
    private Map<String, String> fieldErrors; // ← adicionado para validação

    public CustomError(Instant timestamp, int status, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    // Sobrecarga com fieldErrors
    public CustomError(Instant timestamp, int status, String message, String path, Map<String, String> fieldErrors) {
        this(timestamp, status, message, path);
        this.fieldErrors = fieldErrors;
    }

    // Getters e setters
    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(Map<String, String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
