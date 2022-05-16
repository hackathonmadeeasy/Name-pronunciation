package com.name.pronounciation.controller;

import com.name.pronounciation.model.User;
import com.name.pronounciation.service.PronunciationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/pronunciation")
public class PronunciationController {

    private static final Map<String, String> USER_LIST = Map.ofEntries(
            Map.entry("'parameswara'", "password123#"),
            Map.entry("debajit", "password123#"),
            Map.entry("john", "password123#"),
            Map.entry("syed", "password123#"));

    private PronunciationService pronunciationService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody Map<String, String> user) {
        if (USER_LIST.containsKey(user.get("userName"))) {
            if (USER_LIST.get(user.get("userName")).equalsIgnoreCase(user.get("password"))) {
                return ResponseEntity.ok(
                        pronunciationService.searchUsers(getUserName(user)).get(0)
                );
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    private User getUserName(Map<String, String> user) {
        return User.builder().firstName(user.get("userName").toLowerCase()).build();
    }

}
