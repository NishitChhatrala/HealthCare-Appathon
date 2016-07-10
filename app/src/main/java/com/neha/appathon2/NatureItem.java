package com.neha.appathon2;

/**
 * Created by rajan pipaliya on 8/18/2015.
 */
public class NatureItem {

    private String mName;
    private String medu;
    private String mexp;
    private String mhos;
    private String mspec;
    private int mThumbnail;
    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }
    public int getThumbnail() {

              return mThumbnail;
    }

    public void setThumbnail(int thumbnail) {

        this.mThumbnail = thumbnail;
    }


    public String getedu() {
        return medu;
    }

    public void setExp(String mexp) {
        this.mexp = mexp;
    }

    public String getExp() {
        return mexp;
    }

    public void setMhos(String mhos) {
        this.mhos = mhos;
    }

    public String getMhos() {
        return mhos;
    }

    public void setMspec(String mspec) {
        this.mspec = mspec;
    }
}
