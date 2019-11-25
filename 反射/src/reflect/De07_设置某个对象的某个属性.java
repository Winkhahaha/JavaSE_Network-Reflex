package reflect;

public class De07_设置某个对象的某个属性 {
    public static void main(String args[]) throws NoSuchFieldException, IllegalAccessException {
            /*
            De07_Tool
             public void setProperty(Object obj, String propertyName, Object value){}，
             此方法可将obj对象中名为propertyName的属性的值设置为value。
             */
        Student s = new Student("张三", 26);
        System.out.println(s);
        De07_Tool.setProperty(s, "name", "李四");
        System.out.println(s);
    }
}

class Student {
    private String name;
    private int age;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
