package com.maru.socialnetwork4.repository;

import com.maru.socialnetwork4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    @Query(value = "SELECT u FROM User u WHERE u.username = :un AND u.password = :pw")
    User checkUser(@Param("un") String username,@Param("pw") String password);

    @Query(value = "SELECT COUNT(u) FROM User u WHERE u.username = :un")
    int countUserByUsername(@Param("un") String username);

    @Modifying
    @Query(value = "INSERT INTO user (dob, fullname, note, password, username) " +
            "value (:dob, :fn, :note, :pw, :un)", nativeQuery = true)
    User add(@Param("dob") String dob,
             @Param("fn") String fullname,
             @Param("note") String note,
             @Param("pw") String password,
             @Param("un") String username);

    @Modifying
    @Query(value = "UPDATE user u SET u.dob = :dob, " +
            "u.fullname = :fn," +
            "u.note = :note," +
            "u.password = :pw WHERE u.username = :un", nativeQuery = true)
    User modify(@Param("dob") String dob,
                @Param("fn") String fullname,
                @Param("note") String note,
                @Param("pw") String password,
                @Param("un") String username);
}
