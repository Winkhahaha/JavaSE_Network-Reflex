package reflect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class De02_Fruits {
    public static void main(String args[]) throws ClassNotFoundException, IOException, IllegalAccessException, InstantiationException {
        /*
        没有反射,只说多态
        Juicer j = new Juicer();    //购买榨汁机
        j.run(new Apple());         //苹果放入榨汁机
        j.run(new Orange());
        */

        /*
         用反射和配置文件
         */
        BufferedReader br = new BufferedReader(new FileReader("De02.properties"));
        Class clazz = Class.forName(br.readLine());
        //Class类的newInstance()方法是使用该类无参的构造函数创建对象
//        Fruit f = (Fruit) clazz.newInstance();  //相当于父类引用指向子类对象
////        Juicer juicer = new Juicer();
////        juicer.run(f);
        new Juicer().run((Fruit) clazz.newInstance());
    }
}

interface Fruit {
    public void squeeze();
}

class Apple implements Fruit {
    public void squeeze() {
        System.out.println("苹果汁");
    }
}

class Orange implements Fruit {
    public void squeeze() {
        System.out.println("橘子汁");
    }
}

class Juicer {       //榨汁机
    //    void run(Apple a) {
//        a.squeeze();
//    }
//
//    void run(Orange a) {
//        a.squeeze();
//    }
// 改进后
    public void run(Fruit fruit) {
        fruit.squeeze();
    }
}
