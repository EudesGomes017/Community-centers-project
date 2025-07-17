package com.microservicescommunitycenter.Microservices.community.centers.project.services.exceotionsServices;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
