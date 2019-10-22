package top.daoyang.creational.factorypattern;

/**
 * 简单工厂
 * 缺点: 所有创建对象的功能都集中在一个类中。
 *      当增加了新的类时需要修改工厂类.
 * 违背: 开闭原则
 */
public class SimpleFactory {

    interface Sender {
        void send();
    }

    static class EmailSender implements Sender {

        public void send() {
            System.out.println("发送邮件");
        }
    }

    static class SmsSender implements Sender {

        public void send() {
            System.out.println("发送短信");
        }
    }

    static class ExpressSender implements Sender {

        public void send() {
            System.out.println("发送快递");
        }
    }

//    普通简单工厂
//    缺点: 方法传参错误导致返回错误的实例
    static class SendFactory {
        Sender produce(String type) {
            if (type == null) {
                return null;
            } else if (type.equalsIgnoreCase("mail")) {
                return new EmailSender();
            } else if (type.equalsIgnoreCase("sms")) {
                return new SmsSender();
            } else if (type.equalsIgnoreCase("express")) {
                return new ExpressSender();
            } else {
                return null;
            }
        }
    }

    // 缺点: 需要创建工厂实例
    static class MultiMethodSendFactory {
        Sender produceSms() {
            return new SmsSender();
        }

        Sender produceEmail() {
            return new EmailSender();
        }

        Sender producerExpress() {
            return new ExpressSender();
        }
    }

    static class StaticMultiMethodFactory {
        static Sender produceSms() {
            return new SmsSender();
        }

        static Sender produceEmail() {
            return new EmailSender();
        }

        static Sender produceExpress() {
            return new ExpressSender();
        }
    }

    public static void main(String[] args) {
        System.out.println("simple factory");
        SendFactory sendFactory = new SendFactory();

        sendFactory.produce("mail").send();
        sendFactory.produce("sms").send();
        sendFactory.produce("express").send();

        System.out.println("multi method factory");

        MultiMethodSendFactory multiMethodSendFactory = new MultiMethodSendFactory();
        multiMethodSendFactory.produceEmail().send();
        multiMethodSendFactory.produceSms().send();
        multiMethodSendFactory.producerExpress().send();

        System.out.println("static multi method factory");

        StaticMultiMethodFactory.produceEmail().send();
        StaticMultiMethodFactory.produceSms().send();
        StaticMultiMethodFactory.produceExpress().send();
    }
}
