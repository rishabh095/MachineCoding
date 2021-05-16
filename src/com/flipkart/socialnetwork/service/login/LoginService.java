package com.flipkart.socialnetwork.service.login;

import com.flipkart.socialnetwork.model.Post;
import com.flipkart.socialnetwork.model.User;
import com.flipkart.socialnetwork.service.postservice.PostService;
import com.flipkart.socialnetwork.service.userservice.UserService;

import java.util.Map;
import java.util.Set;

public class LoginService implements ILoginService {

    public static Map<String, Post> postMap = PostService.postMap;

    @Override
    public void login(User user) {
        Map<String, User> userMap = UserService.userMap;
        if (userMap.containsKey(user.getId())) {
            System.out.println(user.getUserName() + " login done.");
            PostService postService = new PostService();
            postService.viewPosts(user);
        }
    }

    @Override
    public void showUsersFeed(User user) {
        if (UserService.userMap.containsKey(user.getId())) {
            String postId = "";
            Set<User> followers = UserService.userMap.get(user.getId()).getFollowers();
            for (Map.Entry<String, Post> posts : postMap.entrySet()) {
                postId = posts.getValue().getUser().getId();
                if (followers.contains(posts.getValue().getUser()) && postId != user.getId()) {
                    printPost(posts.getValue());
                }
                System.out.println();
            }
        }
        for (Map.Entry<String, Post> posts : postMap.entrySet()) {
            if (posts.getValue().getUser().getId() == user.getId()) {
                printPost(posts.getValue());
            }
            System.out.println();
        }
    }

    private void printPost(Post value) {
        System.out.println("id :" + value.getPostId());
        System.out.println(value.getUpVotes() + " upvotes" + value.getDownVotes() + " downVotes");
        System.out.println(value.getUser().getUserName());
        System.out.println(value.getPost());
    }
}
