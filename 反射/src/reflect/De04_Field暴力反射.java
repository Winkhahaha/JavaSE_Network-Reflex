package reflect;

import bean.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class De04_Field暴力反射 {

    /*
     - - Class.getField(String)方法可以获取类中的指定字段(可见的),
     如果是私有的可以用getDeclaedField("name")方法获取,
     通过set(obj, "李四")方法可以设置指定对象上该字段的值,
     如果是私有的需要先调用setAccessible(true)设置访问权限,
     用获取的指定的字段调用get(obj)可以获取指定对象中该字段的值
     */
    public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz = Class.forName("bean.Person");
        Constructor c = clazz.getConstructor(String.class, int.class);   //获取有参构造
        Person p = (Person) c.newInstance("张三", 24);         //通过有参构造创建对象

//        Field f = clazz.getField("name");
//        f.set(p,"李四");
        Field f = clazz.getDeclaredField("name");   //暴力反射获取字段
        f.setAccessible(true);      //去除private权限
        f.set(p, "李四");
        System.out.println(p);
    }
}
