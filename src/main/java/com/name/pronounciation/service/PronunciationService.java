package com.name.pronounciation.service;

import com.name.pronounciation.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PronunciationService {

    public List<User> searchUsers(User user);
}
