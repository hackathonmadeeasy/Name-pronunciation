package com.name.pronounciation.repository;

import com.name.pronounciation.model.db.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    String FULL_SEARCH_QUERY = "SELECT id,first_name,last_name,preferred_name,preferred_audio,standard from user_preferences where first_name=:firstName and last_name =:lastName%  and preferred_name=:preferredName%";
    String FIRST_NAME_SEARCH_QUERY = "SELECT id,first_name,last_name,preferred_name,preferred_audio,standard from user_preferences where first_name=:firstName";
    String LAST_NAME_SEARCH_QUERY = "SELECT id,first_name,last_name,preferred_name,preferred_audio,standard from user_preferences where last_name=:lastName ";
    String PREFERRED_NAME_SEARCH_QUERY = "SELECT id,first_name,last_name,preferred_name,preferred_audio,standard from user_preferences where preferred_name=:preferredName ";
    String FIRST_AND_LAST_NAME_QUERY = "SELECT id,first_name,last_name,preferred_name,preferred_audio,standard from user_preferences where first_name=:firstName and last_name=:lastName ";

    @Query(value = FULL_SEARCH_QUERY, nativeQuery = true)
    List<User> findByFirstNameAndLastNameAndPreferredName(String firstName, String lastName, String preferredName);

    @Query(value = FIRST_NAME_SEARCH_QUERY, nativeQuery = true)
    List<User> findByFirstName(String firstName);


    @Query(value = LAST_NAME_SEARCH_QUERY, nativeQuery = true)
    List<User> findByLastName(String lastName);

    @Query(value = PREFERRED_NAME_SEARCH_QUERY, nativeQuery = true)
    List<User> findByPreferredName(String preferredName);

    @Query(value = FIRST_AND_LAST_NAME_QUERY, nativeQuery = true)
    List<User> findByFirstNameAndLastName(String firstName, String lastName);

}
