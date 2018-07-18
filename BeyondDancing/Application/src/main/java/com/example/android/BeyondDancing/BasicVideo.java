package com.example.android.BeyondDancing;

public class BasicVideo {
    private String title;
    private String videoTime;
    private String thumbnailImage;
    private String uploader;
    private int likes;
    private int dislikes;
    public BasicVideo(){}

    public BasicVideo(final String title, final String videoTime, final String thumbnailImage, final String uploader, final int likes, final int dislikes){
        this.title = title;
        this.videoTime = videoTime;
        this.thumbnailImage = thumbnailImage;
        this.uploader = uploader;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public String getTitle(){
        return title;
    }
    public String getVideoTime() {
        return videoTime;
    }
    public String getThumbnailImage() {
        return thumbnailImage;
    }
    public String getUploader() {
        return uploader;
    }
    public int getLikes() {
        return likes;
    }
    public int getDislikes() {
        return dislikes;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setVideoTime(String videoTime) {
        this.videoTime = videoTime;
    }
    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }
    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }
}
