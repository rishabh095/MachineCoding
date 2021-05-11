package com.trello.service.cardservice;

import com.trello.model.card.Card;

public interface ICardService {
    String createCard(Card cardId);
    void showCard(String cardId);
    void showAllCards();
    Card getCardById(String id);
    void deleteCard(String cardId);
    boolean assignCardToUser(String cardId,String userName);
    boolean unAssignCard(String cardsId);
}
