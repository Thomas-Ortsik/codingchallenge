package com.craftworks.codingchallenge.enums;

public enum Status {
    FINISHED (0),
    STARTED (1),
    NEW (2);

    private final int index;

    Status(int index) {
        this.index = index;
    }

    public int index() {
        return index;
    }
}
