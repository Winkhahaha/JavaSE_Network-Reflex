package reflect;

import bean.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class De03_Constructor {
    /*
    Class类的newInstance()方法是使用该类无参的构造函数创建对象,
    如果一个类没有无参的构造函数, 就不能这样创建了,
    可以调用Class类的getConstructor(String.class,int.class)
    方法获取一个指定的构造函数然后再调用Constructor类的newInstance("张三",20)方法创建对象
     */
    public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Class.forName("bean.Person");
        Constructor c = clazz.getConstructor(String.class,int.class);   //获取有参构造
        Person p = (Person) c.newInstance("张三",24);         //通过有参构造创建对象
        System.out.println(p);

    }
}
