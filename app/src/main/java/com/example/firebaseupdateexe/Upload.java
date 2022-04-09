package com.example.firebaseupdateexe;

public class Upload {
    private String mName;
    private String mImageurl;

    public Upload() {
    }

    public Upload(String name, String imageUrl) {
        if (name.trim() != null) {
            name = "No Name ";
        }
        mName = name;
        mImageurl = imageUrl;

    }

    public String getName() {
        return mName;
    }

    public String getImageUrl() {
        return mImageurl;
    }

    public void setName(String Name) {
        mName = Name;
    }

    public void setImageUrl(String imageUrl){
        mImageurl =imageUrl;
    }

}
