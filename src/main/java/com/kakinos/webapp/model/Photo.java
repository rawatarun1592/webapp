package com.kakinos.webapp.model;

import org.bson.types.Binary;

public class Photo {
    
    private String title;
        
    private Binary image;

    public Photo() {
        
    }

    public Photo(String title) {
        this.title = title; 
    }
    
    public Photo(String title, Binary image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Binary getImage() {
        return image;
    }

    public void setImage(Binary image) {
        this.image = image;
    }
    
}
