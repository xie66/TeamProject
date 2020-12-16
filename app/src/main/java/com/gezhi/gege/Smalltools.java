package com.gezhi.gege;

import java.util.List;

public class Smalltools {
    String name;
    int imageId;
    int tag;


    public Smalltools(String name, int imageId, int tag) {
        this.name = name;
        this.imageId = imageId;
        this.tag = tag;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}
