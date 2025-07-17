package com.microservicescommunitycenter.Microservices.community.centers.project.dtos.customErros;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {

    private List<FildMessage> erros = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
        this.erros = erros;
    }

    public List<FildMessage> getErros() {
        return erros;
    }

    public void addError(String fieldName, String message) {
        erros.add(new FildMessage(fieldName, message));
    }
}
