package reflect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class De08_配置类的完整名称 {

    /*
    -  写一个Properties格式的配置文件，配置类的完整名称。
    -  写一个程序，读取这个Properties配置文件，获得类的完整名称并加载这个类，用反射的方式运行run方法。

     */
    public static void main(String args[]) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        BufferedReader br = new BufferedReader(new FileReader("De08.properties"));
        Class clazz = Class.forName(br.readLine());

        De08_DemoClass demoClass = (De08_DemoClass) clazz.newInstance();    //通过字节码创建对象
        demoClass.run();
    }
}
