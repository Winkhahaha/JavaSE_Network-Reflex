package reflect;

import bean.Person;

public class De01_Reflect {
    public static void main(String args[]) throws ClassNotFoundException {
        Class clazz = Class.forName("bean.Person");
        Class clazz2 = Person.class;

        Person p = new Person();
        Class clazz3 = p.getClass();
        System.out.println(clazz == clazz2);        //true
        System.out.println(clazz2 == clazz3);       //true
    }
}
