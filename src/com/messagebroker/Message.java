package com.messagebroker;

public class Message {
    private final String producer;
    private final String payload;

    public Message(String producer, String payload) {
        this.producer = producer;
        this.payload = payload;
    }

    public String getProducer() {
        return producer;
    }

    public String getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "Message{" +
                "producer='" + producer + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}
