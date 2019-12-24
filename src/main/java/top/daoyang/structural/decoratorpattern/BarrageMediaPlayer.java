package top.daoyang.structural.decoratorpattern;

public class BarrageMediaPlayer extends DecoratorMediaPlayer {
    public BarrageMediaPlayer(MediaPlayer mediaPlayer) {
        super(mediaPlayer);
    }

    @Override
    public String getMediaName() {
        return mediaPlayer.getMediaName() + " 已开启弹幕";
    }

    @Override
    public int getMediaSeconds() {
        return mediaPlayer.getMediaSeconds();
    }

    @Override
    public String getMediaContent() {
        return "--------- " + mediaPlayer.getMediaContent() + "( 弹幕中 ) --------- ";
    }

}
