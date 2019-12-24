package top.daoyang.structural.decoratorpattern;

public abstract class DecoratorMediaPlayer extends MediaPlayer {

    protected MediaPlayer mediaPlayer;

    public DecoratorMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }
}
