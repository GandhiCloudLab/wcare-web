package com.gan.wcarewebservice.common;

import com.gan.wcarewebservice.model.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ControllerUtil {

    public static ResponseEntity<?> getResponseEntityForCreate(Object createResult) {
        if (createResult  instanceof CustomError) {
            return new ResponseEntity(createResult, HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity(createResult, HttpStatus.CREATED);
        }
    }
}
