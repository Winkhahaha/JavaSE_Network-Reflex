package 动态代理;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String args[]){

        /*
            UserImp userImp = new UserImp();
            userImp.add();
            userImp.delete();
        System.out.println("----------------------------");

             //动态代理
             //public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)


            User u = (User) Proxy.newProxyInstance(userImp.getClass().getClassLoader(),
                            userImp.getClass().getInterfaces(),
                            new MyInvocationHandler(userImp));
            u.add();
            u.delete();
            */
        StuImp stuImp = new StuImp();
        stuImp.login();
        stuImp.submit();
        System.out.println("------------------------");

        Student student = (Student) Proxy.newProxyInstance(stuImp.getClass().getClassLoader(),
                stuImp.getClass().getInterfaces(),
                new MyInvocationHandler(stuImp));

        student.login();
        student.submit();
    }
}
