package com.juanite.model.domain;

import java.util.Objects;

public class Document {
    private String name;
    private String content;
    private Priority priority;
    private int priorityValue;

    public Document() {
        this.name = "";
        this.content = "";
        this.priority = Priority.MEDIUM;
        this.priorityValue = 2;
    }
    public Document(String name, String content, Priority priority) {
        this.name = name;
        this.content = content;
        this.priority = priority;
        if(priority == Priority.LOW) {
            priorityValue = 1;
        } else if(priority == Priority.MEDIUM) {
            priorityValue = 2;
        } else {
            priorityValue = 3;
        }
    }

    public String getDocName() {
        return name;
    }

    public void setDocName(String name) {
        this.name = name;
    }

    public String getDocContent() {
        return content;
    }

    public void setDocContent(String content) {
        this.content = content;
    }

    public Priority getDocPriority() {
        return priority;
    }

    public void setDocPriority(Priority priority) {
        this.priority = priority;
    }

    public int getDocPriorityValue() {
        return priorityValue;
    }

    public void setDocPriorityValue(int priorityValue) {
        this.priorityValue = priorityValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(name, document.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
