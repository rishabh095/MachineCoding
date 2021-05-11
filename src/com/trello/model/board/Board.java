package com.trello.model.board;

import com.trello.model.subtask.SubTasksList;
import com.trello.model.user.User;

import java.util.List;

public class Board {
    private String boardId;
    private String BoardName;
    private String privacy;
    private String url;
    private List<User> members;
    private List<SubTasksList> subCardLists;

    public Board(String boardId, String boardName, String privacy, List<User> members, List<SubTasksList> subCardLists) {
        this.boardId = boardId;
        BoardName = boardName;
        this.privacy = privacy;
        this.members = members;
        this.subCardLists = subCardLists;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getBoardName() {
        return BoardName;
    }

    public void setBoardName(String boardName) {
        BoardName = boardName;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<SubTasksList> getSubCardLists() {
        return subCardLists;
    }

    public void setSubCardLists(List<SubTasksList> subCardLists) {
        this.subCardLists = subCardLists;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardId='" + boardId + '\'' +
                ", BoardName='" + BoardName + '\'' +
                ", privacy='" + privacy + '\'' +
                ", url='" + url + '\'' +
                ", members=" + members +
                ", subCardLists=" + subCardLists +
                '}';
    }
}

