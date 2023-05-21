package com.challenge.util;

import java.util.List;

import org.springframework.http.ResponseEntity;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ChallengeUtil {

    public static <T> ResponseEntity<List<T>> handleResponseList(List<T> response) {
        if (response.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(response);
        }
    }
	
}
