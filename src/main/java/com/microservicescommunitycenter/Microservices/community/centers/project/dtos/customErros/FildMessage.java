package com.microservicescommunitycenter.Microservices.community.centers.project.dtos.customErros;

public class FildMessage {

    private String fieldName;

    private String message;

    public FildMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
