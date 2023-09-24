package com.example.baitaplon.Main;

public class AnhMhc {
    private  int resourceId;
    private String title;
    private String title_gm;

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_gm() {
        return title_gm;
    }

    public void setTitle_gm(String title_gm) {
        this.title_gm = title_gm;
    }

    public AnhMhc(int resourceId, String title, String title_gm) {
        this.resourceId = resourceId;
        this.title = title;
        this.title_gm = title_gm;
    }
}
