package com.example.news_application;

import android.os.Parcel;
import android.os.Parcelable;

//this is the related news data model
public class RelatedNews implements Parcelable {

    private int imageResource;
    private String title;
    private String description;

    public RelatedNews(int imageResource, String title, String description) {
        this.imageResource = imageResource;
        this.title = title;
        this.description = description;
    }

    protected RelatedNews(Parcel in) {
        imageResource = in.readInt();
        title = in.readString();
        description = in.readString();
    }

    public static final Creator<RelatedNews> CREATOR = new Creator<RelatedNews>() {
        @Override
        public RelatedNews createFromParcel(Parcel in) {
            return new RelatedNews(in);
        }

        @Override
        public RelatedNews[] newArray(int size) {
            return new RelatedNews[size];
        }
    };

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageResource);
        dest.writeString(title);
        dest.writeString(description);
    }
}

