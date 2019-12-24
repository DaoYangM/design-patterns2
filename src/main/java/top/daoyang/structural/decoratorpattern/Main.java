package top.daoyang.structural.decoratorpattern;

public class Main {

    public static void main(String[] args) {

        MediaPlayer mediaPlayer = new RealMediaPlayer("射雕英雄传",  6, "郭靖大战欧阳锋");

        mediaPlayer.play();

        MediaPlayer barrageMediaPlay = new BarrageMediaPlayer(mediaPlayer);
        barrageMediaPlay.play();

    }
}
