package com.swd.starter;

public class HelloService {

    HelloServiceProperties helloServiceProperties;

    public HelloServiceProperties getHelloServiceProperties() {
        return helloServiceProperties;
    }

    public void setHelloServiceProperties(HelloServiceProperties helloServiceProperties) {
        this.helloServiceProperties = helloServiceProperties;
    }

    public String sayHelloSwd(String name) {
        return helloServiceProperties.getPrefix() + "-" + name + helloServiceProperties.getSuffix();
    }
}
