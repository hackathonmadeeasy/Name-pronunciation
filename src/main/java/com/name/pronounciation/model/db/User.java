package com.name.pronounciation.model.db;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_preferences")
@Setter
@Getter
@Builder
@AllArgsConstructor
public class User {
    User(){}
    @Id
    private String id;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "preferred_name")
    private String preferredName;

    @Column(name= "preferred_audio")
    private byte[] preferredAudio;
    @Column(name= "standard")
    private boolean standard;
}
