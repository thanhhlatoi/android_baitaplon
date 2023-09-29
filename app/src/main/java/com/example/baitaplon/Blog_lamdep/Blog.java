package com.example.baitaplon.Blog_lamdep;

public class Blog {
    private int resourceId_1;
    private String title;
    public int getResourceId_1() {
        return resourceId_1;
    }

    public void setResourceId_1(int resourceId_1) {
        this.resourceId_1 = resourceId_1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Blog(int resourceId_1, String title) {
        this.resourceId_1 = resourceId_1;
        this.title = title;

    }
}
