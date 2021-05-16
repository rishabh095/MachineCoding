package com.flipkart.socialnetwork.model;

import java.util.StringJoiner;

public class Reply {
    private String id;
    private String reply;
    private Post post;

    public Reply(String id, String reply, Post post) {
        this.id = id;
        this.reply = reply;
        this.post = post;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Reply.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("reply='" + reply + "'")
                .add("post=" + post)
                .toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
