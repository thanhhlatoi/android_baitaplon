package com.example.baitaplon.Main;

public class AnhMhc {
    private  int resourceId;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AnhMhc(String title) {
        this.title = title;
    }

    public AnhMhc(String anh1, int resourceId) {
        this.resourceId = resourceId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
