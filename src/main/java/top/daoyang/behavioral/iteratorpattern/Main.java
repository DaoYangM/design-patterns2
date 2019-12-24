package top.daoyang.behavioral.iteratorpattern;

public class Main {

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList(10);

        myArrayList.add(0);
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);

        for (Integer integer : myArrayList) {
            System.out.println(integer);
        }
    }
}
