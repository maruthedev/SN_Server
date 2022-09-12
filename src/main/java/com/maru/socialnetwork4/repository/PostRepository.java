package com.maru.socialnetwork4.repository;

import com.maru.socialnetwork4.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer>, JpaSpecificationExecutor<Post> {
    @Modifying
    @Query(value = "INSERT INTO post(description, title, user_id, date, points) " +
            "values (:des, :title, :uid, :date, :p) ", nativeQuery = true)
    Post upload(@Param("des") String des,
                @Param("title") String title,
                @Param("uid") int uid,
                @Param("date") String date,
                @Param("p") int p);

    @Query(value = "SELECT p FROM Post p WHERE p.title LIKE %:param%")
    List<Post> findPostByTitle(@Param("param") String param);

    @Query(value = "SELECT p FROM Post p " +
            "INNER JOIN User u ON p.user.username = :un")
    List<Post> getUserPost(@Param("un") String username);

    @Query(value = "SELECT p FROM Post p")
    List<Post> getAllPost();
}
