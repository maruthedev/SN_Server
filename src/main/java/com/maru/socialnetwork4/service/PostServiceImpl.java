package com.maru.socialnetwork4.service;

import com.maru.socialnetwork4.dao.PostDAO;
import com.maru.socialnetwork4.model.Post;
import com.maru.socialnetwork4.model.User;

import java.util.List;

public class PostServiceImpl implements PostService {
    @Override
    public Post upload(Post post) {
        return new PostDAO().upload(post);
    }
}
