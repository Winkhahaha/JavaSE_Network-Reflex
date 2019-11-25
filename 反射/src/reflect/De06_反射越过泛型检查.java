package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class De06_反射越过泛型检查 {

    /*
    ArrayList<Integer>的一个对象，在这个集合中添加一个字符串数据，如何实现呢？
    泛型只在编译期间有效,运行期会被擦除
     */
    public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(111);
        list.add(222);

        Class clazz = Class.forName("java.util.ArrayList"); //获取字节码对象
        Method method = clazz.getMethod("add",Object.class);
        method.invoke(list,"abc");      //擦除泛型,存入String
        System.out.println(list);   //[111, 222, abc]
    }
}
