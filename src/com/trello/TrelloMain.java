package com.trello;

import com.trello.model.board.Board;
import com.trello.model.card.Card;
import com.trello.model.subtask.SubTasksList;
import com.trello.model.user.User;
import com.trello.service.boardservice.BoardService;
import com.trello.service.cardservice.CardService;
import com.trello.service.subtasksservice.SubTasksListService;
import com.trello.service.userservice.UserService;

import java.util.ArrayList;
import java.util.List;

public class TrelloMain {
    public static void main(String[] args) {
        int idCount = 1;

        UserService userService = new UserService();
        //--------------------------User service start---------------------------------------------------------

        userService.showAllUsers();
        String userId1 = userService.createUser(new User(String.valueOf(idCount++), "Rishabh", "rishabh@gmail.com"));
        System.out.println("User Created " + userId1);
        String userId2 = userService.createUser(new User(String.valueOf(idCount++), "Shivam", "rishabh@gmail.com"));
        System.out.println("User Created " + userId2);
        String userId3 = userService.createUser(new User(String.valueOf(idCount++), "Anubhav", "rishabh@gmail.com"));
        System.out.println("User Created " + userId3);
        String userId4 = userService.createUser(new User(String.valueOf(idCount++), "Ashish", "rishabh@gmail.com"));
        System.out.println("User Created " + userId4);

        userService.showUser("asdasds");
        userService.showAllUsers();

        //--------------------------User service end---------------------------------------------------------
        //--------------------------card service end---------------------------------------------------------
        CardService cardService = new CardService();
        String card1 = cardService.createCard(new Card(String.valueOf(idCount++), "rishabh card", "", ""));
        System.out.println("Card Created " + card1);
        String card2 = cardService.createCard(new Card(String.valueOf(idCount++), "riscard", "", ""));
        System.out.println("Card Created " + card2);
        String card3 = cardService.createCard(new Card(String.valueOf(idCount++), "new card for me", "special card", ""));
        System.out.println("Card Created " + card3);
        String card4 = cardService.createCard(new Card(String.valueOf(idCount++), "abc", "", "abc"));
        System.out.println("Card Created " + card4);
        cardService.showCard(card1);
        System.out.println("------------------");
        cardService.assignCardToUser(card1, userId1);
        System.out.println("------------------");
        cardService.showAllCards();
        System.out.println("------------------");
        cardService.unAssignCard(card4);
        System.out.println("------------------");
        cardService.deleteCard(card2);
        cardService.deleteCard("card2");
        cardService.assignCardToUser(card1, "userId1");
        cardService.assignCardToUser("card1", userId1);
        System.out.println("------------------");
        cardService.showAllCards();

        //--------------------------card service end---------------------------------------------------------

        //--------------------------SubTasksList service start---------------------------------------------------------
        SubTasksListService subTasksList = new SubTasksListService();
        List<Card> cards = new ArrayList<>();
        cards.add(cardService.getCardById(card3));
        cards.add(cardService.getCardById(card4));
        String subTasksList1 = subTasksList.createSubTasksList(new SubTasksList(String.valueOf(idCount++), "MyTask", cards));
        System.out.println("SubTaskList created: " + subTasksList1);
        cards.clear();
        String subTasksList2 = subTasksList.createSubTasksList(new SubTasksList(String.valueOf(idCount++), "MyTask", cards));
        System.out.println("SubTaskList created: " + subTasksList2);
        cards.add(cardService.getCardById(card1));
        cards.clear();

        System.out.println("---------------");
        subTasksList.showSubTaskList(subTasksList1);
        System.out.println("---------------");
        subTasksList.deleteSubTasksListAndCardsOfList(subTasksList1);
        System.out.println("---------------");
        subTasksList.showSubTaskList(subTasksList1);
        cardService.showAllCards();
        //--------------------------SubTasksList service end---------------------------------------------------------

        //--------------------------Board service start---------------------------------------------------------
        String card5 = cardService.createCard(new Card(String.valueOf(idCount++), "abc", "", "abc"));
        System.out.println("Card Created " + card5);
        cards.add(cardService.getCardById(card1));
        cards.add(cardService.getCardById(card5));
        String subTasksList3 = subTasksList.createSubTasksList(new SubTasksList(String.valueOf(idCount++), "MyTask", cards));
        System.out.println();
        System.out.println("SubTaskList created: " + subTasksList3);
        BoardService boardService = new BoardService();
        List<User> users = new ArrayList<>();
        users.add(userService.userMap.get(userId1));
        List<SubTasksList> subTasksLists=new ArrayList<>();
        subTasksLists.add(subTasksList.subTasksListMap.get(subTasksList2));
        String board1 = boardService.createBoard(new Board(String.valueOf(idCount++), "Rishabh Board", "", users, subTasksLists));
        System.out.println("board created "+board1);
        subTasksLists.clear();

        subTasksLists.add(subTasksList.subTasksListMap.get(subTasksList3));
        List<User> users1 = new ArrayList<>();
        users1.add(userService.userMap.get(userId2));
        users1.add(userService.userMap.get(userId3));
        String board2 = boardService.createBoard(new Board(String.valueOf(idCount++), "Rishabh Board", "", users1, subTasksLists));
        System.out.println("board created "+board2);

        System.out.println("-----------------");
        boardService.showBoard(board1);
        boardService.showBoard(board2);
        System.out.println("---------user Add in list--------");

        boardService.addMemberInBoard(board1,userService.userMap.get(userId4));
        System.out.println("---------user remove in list--------");
        boardService.removeMemberInBoard(board2,userService.userMap.get(userId2));
        System.out.println("-----------------");
        boardService.showBoards();
        System.out.println("-----------------");
        boardService.deleteBoardAndSubTaskLists(board2);
        boardService.showBoards();
        subTasksList.showSubTaskList(subTasksList3);

        //--------------------------Board service end---------------------------------------------------------

    }


}
