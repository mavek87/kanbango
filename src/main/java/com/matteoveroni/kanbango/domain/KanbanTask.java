package com.matteoveroni.kanbango.domain;

public class KanbanTask {
    private String title;
    private String description;
    private String text;
    private boolean completed = false;

    public KanbanTask(String title, String description, String text, boolean completed) {
        this.title = title;
        this.description = description;
        this.text = text;
        this.completed = completed;
    }

    public KanbanTask(String title, String description, String text) {
        this.title = title;
        this.description = description;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
