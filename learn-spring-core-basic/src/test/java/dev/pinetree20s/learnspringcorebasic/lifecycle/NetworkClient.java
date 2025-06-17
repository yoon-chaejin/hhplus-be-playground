package dev.pinetree20s.learnspringcorebasic.lifecycle;

public class  NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("Create client with url : " + url);
        connect();
        call("initialize message call");
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
}
