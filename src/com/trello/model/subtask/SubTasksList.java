package com.trello.model.subtask;

import com.trello.model.card.Card;

import java.util.List;

public class SubTasksList {
    private String id;
    private String name;
    private List<Card> cards;

    public SubTasksList(String id, String name, List<Card> cards) {
        this.id = id;
        this.name = name;
        this.cards = cards;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "SubTasksList{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }
}
