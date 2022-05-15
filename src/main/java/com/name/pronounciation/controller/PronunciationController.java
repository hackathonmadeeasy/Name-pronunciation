package com.name.pronounciation.controller;

import com.name.pronounciation.model.User;
import com.name.pronounciation.service.PronunciationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/pronunciation")
public class PronunciationController {

    private PronunciationService pronunciationService;

    @GetMapping("/health")
    public String health() {
        return "Hey!! I am doing good";
    }

    @PostMapping("/search")
    public List<User> search(@RequestBody User user) {
        return pronunciationService.searchUsers(user);
    }

}
