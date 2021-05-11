package com.trello.service.cardservice;

import com.trello.model.card.Card;
import com.trello.service.Utils.TrelloUtility;
import com.trello.service.userservice.UserService;

import java.util.HashMap;
import java.util.Map;

public class CardService implements ICardService {
    public static Map<String, Card> cardMap = new HashMap<>();

    @Override
    public String createCard(Card card) {
        String randomId = TrelloUtility.getRandomId(Integer.parseInt(card.getCardId()));
        card.setCardId(randomId);
        cardMap.put(card.getCardId(), card);
        return card.getCardId();
    }

    @Override
    public void showCard(String cardId) {
        if (cardMap.containsKey(cardId))
            System.out.println(cardMap.get(cardId));
        else
            System.out.println("Card " + cardId + " does not Exist");
    }

    @Override
    public void showAllCards() {
        if (cardMap.size() > 0) {
            for (Map.Entry<String, Card> entry : cardMap.entrySet())
                System.out.println(entry.getValue());
        } else
            System.out.println("No Card Exist");
    }

    @Override
    public Card getCardById(String id) {
        if(cardMap.containsKey(id))
            return cardMap.get(id);
        return null;
    }

    @Override
    public void deleteCard(String cardId) {
        if (cardMap.containsKey(cardId)) {
            cardMap.remove(cardId);
            System.out.println("Card " + cardId + " deleted");
        } else
            System.out.println("Card " + cardId + " not exists so can not delete");
    }

    @Override
    public boolean assignCardToUser(String cardId, String userId) {
        if (cardMap.containsKey(cardId)) {
            if (UserService.userMap.containsKey(userId)) {
                cardMap.get(cardId).setAssignedUser(UserService.userMap.get(userId).getUserName());
                return true;
            } else {
                System.out.println("user dose not exist so card " + cardId + "can not be assigned to " + userId);
                return false;
            }
        } else {
            System.out.println("card " + cardId + "does not exist so can no assign to user " + userId);
            return false;
        }
    }

    @Override
    public boolean unAssignCard(String cardId) {
        if (cardMap.containsKey(cardId)) {
            cardMap.get(cardId).setAssignedUser("");
            return true;
        }
        return false;
    }
}
