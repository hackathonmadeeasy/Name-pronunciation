package com.name.pronounciation.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
@Builder
public class User {

    private String id;

    private String firstName;

    private String lastName;

    private String preferredName;

    private byte[] preferredAudio;

    private boolean standard;

}
