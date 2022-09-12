package com.maru.socialnetwork4.service;

import com.maru.socialnetwork4.model.Post;
import com.maru.socialnetwork4.model.User;
import com.maru.socialnetwork4.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService implements CustomService<Post> {
    @Autowired
    PostRepository postRepository;

    @Override
    public Post create(Post post) {
        return postRepository.upload(post.getDescription(), post.getTitle(), post.getUser().getID(),
                "" + LocalDateTime.now(), 0);
    }

    @Override
    public Post update(Post post) {
        return null;
    }

    @Override
    public Post delete(Post post) {
        return null;
    }

    public List<Post> findPostByTitle(String param){
        return postRepository.findPostByTitle(param);
    }

    public List<Post> getUserPost(User user){
        return postRepository.getUserPost(user.getUsername());
    }

    public List<Post> getAllPost(){
        return postRepository.getAllPost();
    }
}
