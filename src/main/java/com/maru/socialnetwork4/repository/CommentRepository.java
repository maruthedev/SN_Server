package com.maru.socialnetwork4.repository;

import com.maru.socialnetwork4.model.Comment;
import com.maru.socialnetwork4.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<Comment, Integer>, JpaSpecificationExecutor<Comment> {
    @Modifying
    @Query(value = "INSERT INTO comment(description, points, post_id, user_id) " +
            "values (:des, :p, :pid, :uid)", nativeQuery = true)
    Comment write(@Param("des") String des,
                  @Param("p") int points,
                  @Param("pid") int postId,
                  @Param("uid") int userId);
}
