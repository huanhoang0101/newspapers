package com.newspapers.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> responseSuccessBuilder (
            Boolean success, HttpStatus httpStatus, Object responseObject
    )
    {
        Map<String, Object> response = new HashMap<>();

        response.put("success", success);
        response.put("httpStatus", httpStatus);
        response.put("totalCount", responseObject instanceof List<?> ? ((List<?>) responseObject).size() : 1);
        response.put("data", responseObject);

        return new ResponseEntity<>(response, httpStatus);
    }

    public static ResponseEntity<Object> responseErrorBuilder (
            Boolean success, HttpStatus httpStatus, String message
    )
    {
        Map<String, Object> response = new HashMap<>();

        response.put("success", success);
        response.put("httpStatus", httpStatus);
        response.put("message", message);

        return new ResponseEntity<>(response, httpStatus);
    }
}
