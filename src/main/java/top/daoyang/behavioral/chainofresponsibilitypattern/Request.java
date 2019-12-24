package top.daoyang.behavioral.chainofresponsibilitypattern;

public class Request implements IRequest {

    private int level;

    private String content;

    public Request(int level, String content) {
        this.level = level;

        switch (this.level) {
            case 1:
                this.content = "Problem level 1 is " + content;
                break;
            case 2:
                this.content = "Problem level 2 is " + content;
                break;
            case 3:
                this.content = "Problem level 3 is " + content;
                break;
        }
    }

    @Override
    public int getRequestLevel() {
        return level;
    }

    @Override
    public String getContent() {
        return content;
    }
}
