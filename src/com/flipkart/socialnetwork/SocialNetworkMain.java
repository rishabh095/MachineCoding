package com.flipkart.socialnetwork;

import com.flipkart.socialnetwork.exception.UserNameExistException;
import com.flipkart.socialnetwork.model.Post;
import com.flipkart.socialnetwork.model.Reply;
import com.flipkart.socialnetwork.model.User;
import com.flipkart.socialnetwork.service.login.LoginService;
import com.flipkart.socialnetwork.service.postservice.PostService;
import com.flipkart.socialnetwork.service.userservice.UserService;

import java.util.Set;

public class SocialNetworkMain {
    public static void main(String[] args) throws UserNameExistException {

        // UserService test
        UserService userService = new UserService();
        LoginService loginService =new LoginService();
        User user1 = userService.signup(new User("user-01", "rishabh", "temp", 'M'));

//        User user4 = userService.signup(new User("user-04", "ashish", "temp323", 'M'));
       // System.out.println("User Login");
        loginService.login(user1);

        PostService postService = new PostService();
        String user1post1 = postService.createPost(new Post("post-01", user1, "My First Post"));
        User user2 = userService.signup(new User("user-02", "shivam", "temp1233", 'M'));
        loginService.login(user2);

        postService.upVotePost(user1post1);
        postService.upVotePost(user1post1);
        String user2post1 = postService.createPost(new Post("post-02", user2, "My First Post"));
        System.out.println("last login");
        loginService.login(user2);
        postService.addReply(user1post1,new Reply("reply-01","my first Reply",postService.postMap.get(user1post1)));

        loginService.login(user2);
        System.out.println("________-____________");
        userService.followOtherUsers(user1, user2);
        String user2post2 = postService.createPost(new Post("post-03", user2, "Random Post"));

        loginService.showUsersFeed(user1);


        // UserNameExistException test
        //User user5 = userService.signup(new User("user-04", "ashish", "temp323", 'M'));
        //System.out.println(userService.userMap);

       /* userService.followOtherUsers(user1, user3);
        userService.followOtherUsers(user1, user4);
        userService.followOtherUsers(user3, user4);
        userService.followOtherUsers(user4, user1);*/

        //Set<User> followers = userService.userMap.get(user1).getFollowers();
        //System.out.println(followers);



        // Post Service test

        /*PostService postService = new PostService();
        String user1post1 = postService.createPost(new Post("post-01", user1, "My First Post"));
        String user1post2 = postService.createPost(new Post("post-02", user1, "My SEcond Post"));
        String user2post1 = postService.createPost(new Post("post-03", user2, "My SEcond Post"));
        String user3post1 = postService.createPost(new Post("post-04", user3, "My Post"));

        System.out.println(postService.postMap);

        postService.addReply(user1post1,new Reply("reply-01","my first Reply",postService.postMap.get(user1post1)));
        //System.out.println(postService.postMap);
        postService.upVotePost(user1post1);
        postService.downVotePost(user1post2);
        postService.viewPosts(user1);


        System.out.println("-----------------------");

        loginService.login(user1);

        System.out.println("---------UsersFeed------------");
        loginService.showUsersFeed(user1);
        */

    }
}
