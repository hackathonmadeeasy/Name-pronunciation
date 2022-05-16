package com.name.pronounciation.controller;

import com.name.pronounciation.model.User;
import com.name.pronounciation.service.PronunciationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/pronunciation")
public class PronunciationController {

    private PronunciationService pronunciationService;


    @PostMapping("/search")
    public List<User> search(@RequestBody User user) {
        return pronunciationService.searchUsers(user);
    }

}
