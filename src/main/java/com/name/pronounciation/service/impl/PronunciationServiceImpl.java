package com.name.pronounciation.service.impl;

import com.name.pronounciation.model.User;
import com.name.pronounciation.repository.UserRepository;
import com.name.pronounciation.service.PronunciationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PronunciationServiceImpl implements PronunciationService {


    private UserRepository userRepository;

    @Override
    public List<User> searchUsers(User user) {

        return findUsers(user);

    }

    public List<User> findUsers(User user) {
        List<User> userList = new ArrayList<>();
        if (StringUtils.hasLength(user.getId())) {
            com.name.pronounciation.model.db.User userDetails = userRepository.getById(user.getId());
            User searchedDetails = User.builder()
                    .id(userDetails.getId())
                    .lastName(userDetails.getLastName())
                    .firstName(userDetails.getFirstName())
                    .preferredAudio(userDetails.getPreferredAudio())
                    .preferredName(userDetails.getPreferredName())
                    .build();
            userList.add(searchedDetails);
            return userList;
        } else if (StringUtils.hasLength(user.getPreferredName())) {
            List<com.name.pronounciation.model.db.User> userListDb = userRepository.findByPreferredName(user.getPreferredName());
            return transformUserDetails(userListDb);
        } else if (StringUtils.hasLength(user.getFirstName()) && StringUtils.hasLength(user.getLastName())) {
            List<com.name.pronounciation.model.db.User> userListDb = userRepository.findByFirstNameAndLastName(user.getFirstName(),user.getLastName());
            return transformUserDetails(userListDb);
        } else if (StringUtils.hasLength(user.getLastName())) {
            List<com.name.pronounciation.model.db.User> userListDb = userRepository.findByLastName(user.getFirstName());
            return transformUserDetails(userListDb);
        } else if (StringUtils.hasLength(user.getFirstName())) {
            List<com.name.pronounciation.model.db.User> userListDb = userRepository.findByFirstName(user.getFirstName());
            return transformUserDetails(userListDb);
        } else if (StringUtils.hasLength(user.getLastName())) {
            List<com.name.pronounciation.model.db.User> userListDb = userRepository.findByLastName(user.getFirstName());
            return transformUserDetails(userListDb);
        } else if (StringUtils.hasLength(user.getFirstName()) && StringUtils.hasLength(user.getLastName()) && StringUtils.hasLength(user.getPreferredName())) {
            List<com.name.pronounciation.model.db.User> userListDb = userRepository.findByFirstNameAndLastNameAndPreferredName(user.getFirstName(), user.getLastName(), user.getPreferredName());
            return transformUserDetails(userListDb);
        }

        return null;

    }

    public List<User> transformUserDetails(List<com.name.pronounciation.model.db.User> userList) {
        List<User> userDetailsList = new ArrayList<>();
        for (com.name.pronounciation.model.db.User userDetails : userList) {

            User searchedDetails = User.builder()
                    .id(userDetails.getId())
                    .lastName(userDetails.getLastName())
                    .firstName(userDetails.getFirstName())
                    .preferredAudio(userDetails.getPreferredAudio())
                    .preferredName(userDetails.getPreferredName())
                    .build();
            userDetailsList.add(searchedDetails);

        }
        return userDetailsList;
    }
}
