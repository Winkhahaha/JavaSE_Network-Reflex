package UDP编程.优化为键盘录入;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class De02_Send {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        DatagramSocket socket = new DatagramSocket();   //创建socket,相当于创建码头

        while (true) {
            String str = sc.nextLine();
            if ("quit".equals(str)) {
                break;
            }
            DatagramPacket packet =                         //创建packet,相当于集装箱
                    new DatagramPacket(str.getBytes(), str.getBytes().length,
                            InetAddress.getByName("127.0.0.1"), 6666);
            socket.send(packet);    //发货,将数据发出去
        }
        socket.close(); //关闭码头
    }
}
