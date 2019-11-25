package 模板方法设计模式;

public class De01_Template {

    public static void main(String args[]) {

        /*

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            System.out.println("X");
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
         */

        Demo d = new Demo();
        System.out.println(d.getTime());
    }
}

abstract class GetTime {
    public final long getTime() {                   //子类默认继承
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();
        return end - start;
    }

    abstract void code();               //子类自己编辑

}

class Demo extends GetTime {

    @Override
    void code() {
        int i = 0;
        while (i < 100000) {
            System.out.println("x");
            i++;
        }
    }
}
