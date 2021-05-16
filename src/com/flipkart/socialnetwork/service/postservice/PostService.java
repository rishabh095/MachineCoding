package com.flipkart.socialnetwork.service.postservice;

import com.flipkart.socialnetwork.model.Post;
import com.flipkart.socialnetwork.model.Reply;
import com.flipkart.socialnetwork.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostService implements IPostService {
    public static Map<String, Post> postMap = new HashMap<>();

    @Override
    public String createPost(Post post) {
        if (!postMap.containsKey(post.getPostId())) {
            postMap.put(post.getPostId(), post);
            System.out.println("Post " + post.getPostId() + " posted");
            return post.getPostId();
        }
        return "";
    }

    @Override
    public String addReply(String postId, Reply reply) {
        if (postMap.containsKey(reply.getPost().getPostId())) {
            if (postId == reply.getPost().getPostId()) {
                Post post = postMap.get(reply.getPost().getPostId());
                List<Reply> replies = post.getReplies();
                replies.add(reply);
                post.setReplies(replies);
                System.out.println("Reply is done on post" + reply.getPost().getPostId());
                return reply.getId();
            }
        }
        return "";
    }

    @Override
    public void upVotePost(String postId) {
        if (postMap.containsKey(postId)) {
            Post post = postMap.get(postId);
            post.setUpVotes(post.getUpVotes() + 1);
        }
    }

    @Override
    public void downVotePost(String postId) {
        if (postMap.containsKey(postId)) {
            Post post = postMap.get(postId);
            post.setDownVotes((post.getDownVotes() + 1));
        }
    }

    @Override
    public void viewPosts(User user) {
        for (Map.Entry<String, Post> posts : postMap.entrySet()) {
            if (posts.getValue().getUser().getId() != user.getId()) {
                printPost(posts.getValue());
            }
        }
    }

    private void printPost(Post value) {
        System.out.println("id :"+value.getPostId());
        System.out.println(value.getUpVotes()+" upvotes"+value.getDownVotes()+" downVotes");
        System.out.println(value.getUser().getUserName());
        System.out.println(value.getPost());
    }
}
