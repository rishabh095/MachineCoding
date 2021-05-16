package com.flipkart.socialnetwork.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Post {
    private String postId;
    private User user;
    private String post;
    private int upVotes;
    private int downVotes;
    private List<Reply> replies;

    @Override
    public String toString() {
        return new StringJoiner(", ", Post.class.getSimpleName() + "[", "]")
                .add("postId='" + postId + "'")
                .add("user=" + user)
                .add("post='" + post + "'")
                .add("upVotes=" + upVotes)
                .add("downVotes=" + downVotes)
                .add("replies=" + replies)
                .toString();
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public Post(String postId, User user, String post) {
        this.postId = postId;
        this.user = user;
        this.post = post;
        replies=new ArrayList<>();
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }
}
