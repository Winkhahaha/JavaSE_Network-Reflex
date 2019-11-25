package UDP编程;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class De01_Receive {

    /*
     接收端:接收数据
     */
    public static void main(String args[]) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);   //创建接收端socket
        DatagramPacket packet = new DatagramPacket(new byte[1024],1024);    //创建接收端集装箱
        socket.receive(packet);     //接货,接收数据

        byte[] arr = packet.getData();      //获取数据
        int len = packet.getLength();       //获取有效字节个数
        System.out.println(new String(arr,0,len));
        socket.close();
    }
}
