package top.daoyang.structural.flyweightpattern;

import java.util.Objects;

public class ExamInfo {

    private String user;

    private String subject;

    public ExamInfo(String subject) {
        this.subject = subject;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamInfo examInfo = (ExamInfo) o;
        return subject.equals(examInfo.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject);
    }

    @Override
    public String toString() {
        return "ExamInfo{" +
                "user='" + user + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
