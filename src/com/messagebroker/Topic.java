package com.messagebroker;

import java.util.*;

public class Topic implements Runnable {
    private final String name;
    private volatile Set<Subscriber> subscribers;
    private volatile Queue<Message> queue;

    public Topic(String name) {
        this.name = name;
        subscribers = new HashSet<>();
        queue = new ArrayDeque<>();
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public Set<Subscriber> getAllSubscribers() {
        return subscribers;
    }

    public String getName() {
        return name;
    }

    public void addMessage(Message message) {
        System.out.println("topic : " + name + " created : " + message);
        queue.add(message);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Topic topic = (Topic) o;
        return Objects.equals(name, topic.getClass());
    }

    @Override
    public void run() {
        while (true) {
            while (!queue.isEmpty()) {
                Message message = queue.poll();
                for (Subscriber subscriber : subscribers) {
                    System.out.println("sending : " + message + " to : " + subscriber.getName());
                    subscriber.receiveMessage(message);
                }
            }
        }
    }
}
