package com.TicTacToe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GameBoard {
    char[][] gameBoard;
    int boardSize;
    Queue<Player> nextTurn;
    Scanner input;
    String winString = "";
    String playerOneWinString = "XXX";
    String playerTwoWinString = "OOO";

    public GameBoard(int boardSize, Player[] players) {
        this.boardSize = boardSize;
        this.gameBoard = new char[(2 * boardSize) - 1][(2 * boardSize) - 1];
        initializeBoard(gameBoard);
        nextTurn = new LinkedList<>();
        if (players[0].getPlayerSymbol() == 'X') {
            nextTurn.offer(players[0]);
            nextTurn.offer(players[1]);
        } else {
            nextTurn.offer(players[1]);
            nextTurn.offer(players[0]);
        }
        input = new Scanner(System.in);
    }

    private void initializeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i % 2 == 0 && j % 2 != 0) board[i][j] = '|';
                if (i % 2 != 0 && j % 2 == 0) board[i][j] = '-';
                if (i % 2 != 0 && j % 2 != 0) board[i][j] = '+';
            }
        }
        /*
        *  | |
          -+-+-
           | |
          -+-+-
           | |
        * */
        printBoard();
    }

    private void printBoard() {
        for (char[] row : gameBoard) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public void startGame() {
        int count = 0;
        while (true) {
            count++;
            if (count == ((boardSize * boardSize) + 1)) {
                System.out.println("Match draw.");
                break;
            }
            Player player = nextTurn.poll();
            int position = getUserInput(player);
            int row = getRow(position);
            int col = getColumn(position);
            gameBoard[row][col] = player.getPlayerSymbol();
            System.out.println("Board after the move");
            printBoard();
            if (count >= boardSize && checkEndGame(player, row, col))
                break;
            nextTurn.offer(player);
        }
    }

    private int getUserInput(Player player) {
        System.out.println(player.getPlayerName() + " Please Enter a number between 1 - " + (boardSize * boardSize));
        int val = input.nextInt();
        while (!validateInput(val)) {
            printBoard();
            System.out.println("Wrong Position - " + player.getPlayerName() + " Please Enter a number between 1 - " + (boardSize * boardSize));
            val = input.nextInt();
        }
        return val;
    }

    private boolean validateInput(int position) {
        if (position < 1 || position > (boardSize * boardSize))
            return false;
        int row = getRow(position);
        int col = getColumn(position);
        return (int) gameBoard[row][col] == 0;
    }

    private int getColumn(int position) {
        return 2 * ((position % boardSize == 0 ? boardSize : position % boardSize) - 1);
    }

    private int getRow(int position) {
        return 2 * ((position % boardSize == 0) ? (position / boardSize) - 1 : position / boardSize);
    }

    private boolean checkEndGame(Player player, int row, int col) {
        if (player.getPlayerSymbol() == 'X')
            winString = playerOneWinString;
        else
            winString = playerTwoWinString;
        StringBuilder rowString = new StringBuilder();
        StringBuilder colString = new StringBuilder();
        StringBuilder diagonalString = new StringBuilder();
        StringBuilder reverseDiagonalString = new StringBuilder();
        for (int i = 0; i < gameBoard.length; i = i + 2) {
            rowString.append(gameBoard[row][i]);
            colString.append(gameBoard[i][col]);
            if (row == col) {
                diagonalString.append(gameBoard[i][i]);
            }
            if ((row + col) == gameBoard.length - 1) {
                reverseDiagonalString.append(gameBoard[gameBoard.length - 1 - i][i]);
            }
        }
        if (winString.equals(rowString.toString()) || winString.equals(colString.toString()) || winString.equals(diagonalString.toString()) || winString.equals(reverseDiagonalString.toString())) {
            System.out.println(player.getPlayerName() + " has won the Game.");
            return true;
        }
        return false;
    }
}
