package com.flipkart.socialnetwork.service.postservice;

import com.flipkart.socialnetwork.model.Post;
import com.flipkart.socialnetwork.model.Reply;
import com.flipkart.socialnetwork.model.User;

public interface IPostService {
    String createPost(Post post);
    String addReply(String postId,Reply reply);
    void upVotePost(String postId);
    void downVotePost(String postId);
    void viewPosts(User user);
}
