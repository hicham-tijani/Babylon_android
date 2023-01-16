package it.itsar.myapplication;

public class Instagram {

    private  int profileIcon;
    private int postImage;
    private String title;

    public Instagram(int profileIcon, int postImage, String title) {
        this.profileIcon = profileIcon;
        this.postImage = postImage;
        this.title = title;
    }



    public int getProfileIcon() {
        return profileIcon;
    }

    public void setProfileIcon(int profileIcon) {
        this.profileIcon = profileIcon;
    }

    public int getPostImage() {
        return postImage;
    }

    public void setPostImage(int postImage) {
        this.postImage = postImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
