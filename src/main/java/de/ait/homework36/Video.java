package de.ait.homework36;

public class Video {
    private String title;
    private String channel;
    private int views;
    private int likes;
    private int duration;
    private String category;
    private boolean isMonetized;

    public Video(String title, String channel, int views, int likes, int duration, String category, boolean isMonetized) {
        this.title = title;
        this.channel = channel;
        this.views = views;
        this.likes = likes;
        this.duration = duration;
        this.category = category;
        this.isMonetized = isMonetized;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isMonetized() {
        return isMonetized;
    }

    public void setMonetized(boolean monetized) {
        isMonetized = monetized;
    }

    @Override
    public String toString() {
        return "Video{" +
                "title='" + title + '\'' +
                ", channel='" + channel + '\'' +
                ", views=" + views +
                ", likes=" + likes +
                ", duration=" + duration +
                ", category='" + category + '\'' +
                ", isMonetized=" + isMonetized +
                '}';
    }
}
