package com.TicTacToe;

public class PlayGame {
    public static void main(String[] args) {
        Player player1 = new Player(1, "Rishabh", 'X');
        Player player2 = new Player(2, "Shivam", 'O');
        Player[] players = new Player[]{player1, player2};
        GameBoard gameBoard = new GameBoard(3, players);
        gameBoard.startGame();
    }
}
