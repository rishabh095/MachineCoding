package com.TicTacToe;

import com.TicTacToe.exception.InvalidPlayerSymbolException;

public class Player {
    private int playerId;
    private String playerName;
    private String address;
    private int ranking;
    private char playerSymbol;

    public Player(int playerId, String playerName, char playerSymbol) throws InvalidPlayerSymbolException {
        if (playerSymbol == 'X' || playerSymbol == 'O') {
            this.playerName = playerName;
            this.playerId = playerId;
            this.playerSymbol = playerSymbol;
        } else
            throw new InvalidPlayerSymbolException("Invalid Player Symbol selected");
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public void setPlayerSymbol(char playerSymbol) {
        this.playerSymbol = playerSymbol;
    }
}
