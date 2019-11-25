package reflect;

import java.lang.reflect.Field;

public class De07_Tool {
    // 此方法可将obj对象中名为propertyName的属性的值设置为value。
    public static void setProperty(Object obj, String propertyName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Class clazz = obj.getClass();       //获取字节码对象
        Field f = clazz.getDeclaredField(propertyName); //暴力反射获取字段
        f.setAccessible(true);  //去除权限
        f.set(obj,value);

    }
}
