package com.trello.service.subtasksservice;

import com.trello.model.card.Card;
import com.trello.model.subtask.SubTasksList;
import com.trello.service.Utils.TrelloUtility;
import com.trello.service.cardservice.CardService;

import java.util.HashMap;
import java.util.Map;

public class SubTasksListService implements ISubTasksListService {
    public static Map<String, SubTasksList> subTasksListMap = new HashMap<>();

    @Override
    public String createSubTasksList(SubTasksList subTasks) {
        String randomId = TrelloUtility.getRandomId(Integer.parseInt(subTasks.getId()));
        subTasks.setId(randomId);
        subTasksListMap.put(subTasks.getId(), subTasks);
        return subTasks.getId();
    }

    @Override
    public void showSubTaskList(String id) {
        if(subTasksListMap.containsKey(id))
            System.out.println(subTasksListMap.get(id));
        else
            System.out.println("SubTaskList "+id+" does not exist");
    }

    @Override
    public SubTasksList getSubTasksList(String id) {
        if(subTasksListMap.containsKey(id))
            System.out.println(subTasksListMap.get(id));
        return null;
    }

    @Override
    public boolean deleteSubTasksListAndCardsOfList(String id) {
        if (subTasksListMap.containsKey(id)) {
            for (Card card : subTasksListMap.get(id).getCards()) {
                if (CardService.cardMap.containsKey(card.getCardId()))
                    CardService.cardMap.remove(card.getCardId());
                else {
                    System.out.println("card " + card.getCardId() + " does not exist so can not delete subTaskList " + id);
                    return false;
                }
                subTasksListMap.remove(id);
            }
        } else {
            System.out.println("subTaskList " + id + " does not exist so can not delete.");
            return false;
        }
        return true;
    }

    @Override
    public boolean updateSubTasksList() {
        return false;
    }
}
