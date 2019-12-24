package top.daoyang.structural.flyweightpattern;

import java.util.concurrent.ConcurrentHashMap;
/**
 * 享元模式，用池技术服用对象
 */
public class ExamInfoFactory {

    private static ConcurrentHashMap<String, ExamInfo> pool = new ConcurrentHashMap<>();

    public static ExamInfo getExamInfo(String subject) {
        ExamInfo examInfo;

        if (!pool.containsKey(subject)) {
            examInfo = new ExamInfo(subject);
            pool.putIfAbsent(subject, examInfo);
            System.out.println("建立对象，并放到池中..." + subject);
        } else {
            System.out.println("直接从池中获取..." + subject);
            examInfo = pool.get(subject);
        }

        return examInfo;
    }
}
