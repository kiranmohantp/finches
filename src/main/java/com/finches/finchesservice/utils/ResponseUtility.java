package com.finches.finchesservice.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtility {
    public static ResponseEntity saveResponse(Object body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    public static ResponseEntity getResponse(Object body) {
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    public static ResponseEntity updateResponse(Object body) {
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    public static ResponseEntity deleteResponse(Object body) {
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
    public static ResponseEntity operationCompleted(Object body) {
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
}
