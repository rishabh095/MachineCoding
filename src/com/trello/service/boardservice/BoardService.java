package com.trello.service.boardservice;

import com.trello.model.board.Board;
import com.trello.model.card.Card;
import com.trello.model.subtask.SubTasksList;
import com.trello.model.user.User;
import com.trello.service.Utils.TrelloUtility;
import com.trello.service.subtasksservice.SubTasksListService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardService implements IBoardService {
    Map<String, Board> boardMap = new HashMap<>();

    @Override
    public String createBoard(Board board) {
        String randomId = TrelloUtility.getRandomId(Integer.parseInt(board.getBoardId()));
        board.setBoardId(randomId);
        board.setUrl(TrelloUtility.getUrl(board));
        boardMap.put(board.getBoardId(), board);
        return board.getBoardId();
    }

    @Override
    public boolean deleteBoardAndSubTaskLists(String boardId) {
        if (boardMap.containsKey(boardId)) {
            for (SubTasksList subTasksList : boardMap.get(boardId).getSubCardLists()) {
                if (SubTasksListService.subTasksListMap.containsKey(subTasksList.getId()))
                    SubTasksListService.subTasksListMap.remove(subTasksList.getId());
                else {
                    System.out.println("SubTasksList " + subTasksList.getId() + " does not exist so can not delete board " + boardId);
                    return false;
                }
                boardMap.remove(boardId);
            }
        } else {
            System.out.println("Board " + boardId + " does not exist so can not delete.");
            return false;
        }
        return true;
    }

    @Override
    public boolean addMemberInBoard(String boardId, User user) {
        if (boardMap.containsKey(boardId)) {
            boardMap.get(boardId).getMembers().add(user);
            return true;
        }
        System.out.println("User Can not be add to Board as " + boardId + " does not exist");
        return false;
    }

    @Override
    public boolean removeMemberInBoard(String boardId, User user) {
        if (boardMap.containsKey(boardId)) {
            boardMap.get(boardId).getMembers().remove(user);
            return true;
        }
        System.out.println("User Can not be remove from Board as " + boardId + " does not exist");
        return false;
    }

    @Override
    public void updateBoard(String boardId, Board board) {

    }

    @Override
    public void showBoard(String boardId) {
        if(boardMap.containsKey(boardId))
            System.out.println(boardMap.get(boardId));
        else
            System.out.println("Board "+boardId+" does not exist");
    }

    @Override
    public void showBoards() {
        if (boardMap.size() > 0) {
            for (Map.Entry<String, Board> entry : boardMap.entrySet())
                System.out.println(entry.getValue());
        } else
            System.out.println("No board Exist");
    }
}
