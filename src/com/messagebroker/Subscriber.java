package com.messagebroker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subscriber {
    private final String name;
    private final Map<String, Topic> topicMap;


    public Subscriber(String name) {
        this.name = name;
        this.topicMap = new HashMap<>();
    }

    public void addTopic(Topic topic) {
        topicMap.put(topic.getName(), topic);
    }

    public void removeTopic(Topic topic) {
        topicMap.remove(topic);
    }

    public List<String> getAllTopics() {
        return new ArrayList<>(topicMap.keySet());
    }

    public void receiveMessage(Message message) {
        System.out.println("Subscriber : " + name + " received : " + message);
    }

    public String getName() {
        return name;
    }
}
