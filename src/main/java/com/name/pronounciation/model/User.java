package com.name.pronounciation.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User {

    private String id;

    private String firstName;

    private String lastName;

    private String preferredName;

    private String voiceRecordUrl;
}
