package top.daoyang.structural.decoratorpattern;

public class RealMediaPlayer extends MediaPlayer {

    private String mediaName;

    private int mediaSeconds;

    private String mediaContent;

    public RealMediaPlayer(String mediaName, int mediaSeconds, String mediaContent) {
        this.mediaName = mediaName;
        this.mediaSeconds = mediaSeconds;
        this.mediaContent = mediaContent;
    }

    @Override
    public String getMediaName() {
        return mediaName;
    }

    @Override
    public int getMediaSeconds() {
        return mediaSeconds;
    }

    @Override
    public String getMediaContent() {
        return mediaContent;
    }
}
