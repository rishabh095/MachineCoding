package com.trello.service.Utils;

import com.trello.model.board.Board;

import java.util.Random;

public class TrelloUtility {
    Random random=new Random();
    static String UpperLetters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String lowerLetters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String numbers="0123456789";
    static String alphaNumericString = numbers+UpperLetters+lowerLetters;

    public static String getRandomId(int id){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<12;i++){
            int index= (int) (alphaNumericString.length()*Math.random());
            sb.append(alphaNumericString.charAt(index));
        }
        return sb.append(id).toString();
    }

    public static String getUrl(Board board){
        StringBuilder sb = new StringBuilder();
        sb.append("https://Trello.com/borad/");
        for(int i=0;i<4;i++){
            int index= (int) (alphaNumericString.length()*Math.random());
            sb.append(alphaNumericString.charAt(index));
        }
        return sb.append("/").append(board.getBoardId()).toString();
    }
}
