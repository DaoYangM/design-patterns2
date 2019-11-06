package top.daoyang.creational.prototypepattern;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Java clone拷贝类. 如果不能编辑类源码就不能实现深拷贝
 * 要实现完全的深克隆, 要保证所有的引用类字段链路的所有对象都要实现Cloneable接口, 并且逐个clone
 * {@link Date}
*/

@Data
@AllArgsConstructor
public class Person implements Cloneable, Serializable {

    private int age;

    // 浅克隆引用的还是同一个对象
    private Date birthday;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 直接调用此方法 只会深克隆简单类型的字段对象

        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Person p1 = new Person(12, new Date());
        Person p2 = (Person) p1.clone();

        System.out.println("shallow clone");
        System.out.println(p1 == p2);
        System.out.println(p1.age == p2.age);
        System.out.println(p1.getBirthday() == p2.getBirthday());

        // 通过反序列化实现深拷贝
        System.out.println("Serializable depth clone");

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

        objectOutputStream.writeObject(p1);

        byte[] bytes = byteArrayOutputStream.toByteArray();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

        Person p3 = (Person) objectInputStream.readObject();

        System.out.println(p1 == p3);
        System.out.println(p1.age == p3.age);
        System.out.println(p1.getBirthday() == p3.getBirthday());
    }
}
