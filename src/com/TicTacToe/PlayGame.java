package com.TicTacToe;

import com.TicTacToe.exception.InvalidPlayerSymbolException;

public class PlayGame {
    public static void main(String[] args) throws InvalidPlayerSymbolException {
        Player player1 = new Player(1, "Rishabh", 'X');
        Player player2 = new Player(2, "Shivam", 'O');
        Player[] players = new Player[]{player1, player2};
        int boardSize=3;
        GameBoard gameBoard = new GameBoard(boardSize, players);
        gameBoard.startGame();
    }
}
