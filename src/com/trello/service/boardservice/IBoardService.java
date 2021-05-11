package com.trello.service.boardservice;

import com.trello.model.board.Board;
import com.trello.model.user.User;

public interface IBoardService {
    String createBoard(Board board);
    boolean deleteBoardAndSubTaskLists(String boardId);
    boolean addMemberInBoard(String boardId, User user);
    boolean removeMemberInBoard(String boardId, User user);
    void updateBoard(String boardId,Board board);
    void showBoard(String boardId);
    void showBoards();
}
