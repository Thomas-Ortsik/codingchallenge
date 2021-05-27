package com.craftworks.codingchallenge.enums;

public enum Priority {
    HIGH  (2),
    MEDIUM (1),
    LOW (0);

    private final int index;

    Priority(int index) {
        this.index = index;
    }

    public int index() {
        return index;
    }
}
