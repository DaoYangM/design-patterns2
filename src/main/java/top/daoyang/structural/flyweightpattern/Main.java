package top.daoyang.structural.flyweightpattern;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                ExamInfo exam1 = ExamInfoFactory.getExamInfo("科目 " + j);
                exam1.setUser("user " + i);

                System.out.println(exam1);
            }
        }
    }
}
