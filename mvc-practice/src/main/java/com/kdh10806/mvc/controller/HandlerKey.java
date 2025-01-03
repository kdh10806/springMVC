package com.kdh10806.mvc.controller;

import java.util.Objects;

public class HandlerKey {
    private final RequestMethod requestMethod;
    private final String uriPath;

    //Constructor
    public HandlerKey(RequestMethod requestMethod, String uriPath) {
        this.requestMethod = requestMethod;
        this.uriPath = uriPath;
    }

    //Equals & HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandlerKey that = (HandlerKey) o;
        return requestMethod == that.requestMethod && Objects.equals(uriPath, that.uriPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestMethod, uriPath);
    }
}
