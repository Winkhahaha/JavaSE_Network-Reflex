package reflect;

import bean.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class De05_Method {

    /*
    Class.getMethod(String, Class...) 和
    Class.getDeclaredMethod(String, Class...)方法可以获取类中的指定方法,
    调用invoke(Object, Object...)可以调用该方法,
    Class.getMethod("eat") invoke(obj) Class.getMethod("eat",int.class) invoke(obj,10)
     */
    public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("bean.Person");
        Constructor c = clazz.getConstructor(String.class, int.class);   //获取有参构造
        Person p = (Person) c.newInstance("张三", 24);         //通过有参构造创建对象

//        Method method = clazz.getMethod("eat");     //获取eat方法(无参)
//        method.invoke(p);
        Method method = clazz.getMethod("eat", int.class);     //获取eat方法(带参数)
        method.invoke(p, 8);
    }
}
