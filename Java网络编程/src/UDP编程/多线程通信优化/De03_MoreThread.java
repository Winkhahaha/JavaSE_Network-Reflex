package UDP编程.多线程通信优化;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class De03_MoreThread {
    public static void main(String args[]) throws InterruptedException {

        new Receive().start();
        Thread.sleep(1000);
        new Send().start();

    }
}
class Receive extends Thread{
    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(6666);   //创建接收端socket
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);    //创建接收端集装箱

            while (true) {
                socket.receive(packet);     //接货,接收数据

                byte[] arr = packet.getData();      //获取数据
                int len = packet.getLength();       //获取有效字节个数
                String ip = packet.getAddress().getHostAddress();   //获取ip地址
                int port = packet.getPort();                        //获取端口号
                System.out.println(ip + ":" + port + ":" + new String(arr, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Send extends Thread{
    @Override
    public void run() {
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
