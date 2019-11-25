package UDP编程;

import java.io.IOException;
import java.net.*;

public class De01_Send {
    public static void main(String args[]) throws IOException {
        String str="干啥?";
        DatagramSocket socket = new DatagramSocket();   //创建socket,相当于创建码头
        DatagramPacket packet =                         //创建packet,相当于集装箱
                new DatagramPacket(str.getBytes(),str.getBytes().length,
                InetAddress.getByName("127.0.0.1"),6666);

        socket.send(packet);    //发货,将数据发出去
        socket.close();         //关闭码头
    }
}
