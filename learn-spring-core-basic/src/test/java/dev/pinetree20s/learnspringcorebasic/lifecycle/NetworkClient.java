package dev.pinetree20s.learnspringcorebasic.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {
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

    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("initialize message call");
    }

    @Override
    public void destroy() throws Exception {
        disconnect();
    }
}
