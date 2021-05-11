package com.trello.model.card;

public class Card {
    private String cardId;
    private String cardName;
    private String cardDescription;
    private String assignedUser;

    public Card(String cardId, String cardName, String cardDescription, String assignedUser) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.cardDescription = cardDescription;
        this.assignedUser = assignedUser;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId='" + cardId + '\'' +
                ", cardName='" + cardName + '\'' +
                ", cardDescription='" + cardDescription + '\'' +
                ", assignedUser='" + assignedUser + '\'' +
                '}';
    }
}
