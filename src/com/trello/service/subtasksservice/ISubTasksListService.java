package com.trello.service.subtasksservice;

import com.trello.model.subtask.SubTasksList;

public interface ISubTasksListService {
String createSubTasksList(SubTasksList subTasksList);
void showSubTaskList(String id);
SubTasksList getSubTasksList(String id);
    boolean deleteSubTasksListAndCardsOfList(String id);
    boolean updateSubTasksList();
}
