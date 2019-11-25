package UDP编程.优化为键盘录入;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class De02_Receive {

    /*
     接收端:接收数据
     */
    public static void main(String args[]) throws Exception {
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

    }
}
