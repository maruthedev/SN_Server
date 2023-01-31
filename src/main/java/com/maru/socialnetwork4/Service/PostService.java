package com.maru.socialnetwork4.Service;

import com.maru.socialnetwork4.Dao.PostDAO;
import com.maru.socialnetwork4.Model.Post;
import com.maru.socialnetwork4.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements CustomService<Post> {
    private final static PostDAO postDAO = new PostDAO();

    @Override
    public Post create(Post post) {
        return postDAO.create(post);
    }

    @Override
    public Post update(Post post) {
        return null;
    }

    @Override
    public Post delete(Post post) {
        return null;
    }

    public List<Post> findPostByTitleOrUsername(String param){
        return postDAO.findPost(param);
    }

    public List<Post> getUserPost(User user){
        return postDAO.getUserPosts(user);
    }

    public List<Post> getAllPost(){
        return postDAO.getAllPosts();
    }

    public Post react(Post post){
        return postDAO.react(post);
    }
}
