package dev.pinetree20s.learnspringcorebasic.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("Create client with url : " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("Connecting to " + url);
    }

    public void call(String message) {
        System.out.println("Calling " + message + " to " + url);
    }

    public void disconnect() {
        System.out.println("Disconnecting from " + url);
    }

    @PostConstruct
    public void init() {
        connect();
        call("init");
    }

    @PreDestroy
    public void close() {
        disconnect();
    }
}
