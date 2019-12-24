package top.daoyang.structural.decoratorpattern;

public abstract class MediaPlayer {

    public abstract String getMediaName();

    public abstract int getMediaSeconds();

    public abstract String getMediaContent();

    public final void play() {
        System.out.println("Media: " + getMediaName() + "(累计时长: " + getMediaSeconds() + " 秒) 正在播放");

        for (int i = 0; i < getMediaSeconds(); i++) {
            System.out.println("当前播放第 " + i + " 秒，" + getMediaContent() +  "...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
