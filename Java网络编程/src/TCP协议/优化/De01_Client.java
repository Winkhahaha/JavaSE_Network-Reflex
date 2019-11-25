package TCP协议.优化;

import java.io.*;
import java.net.Socket;

public class De01_Client {
    public static void main(String args[]) throws IOException {
        Socket socket = new Socket("127.0.0.1",12345);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());

        System.out.println("收到来自服务器的消息:"+br.readLine());
        ps.println("服务器,我是客户端");
        System.out.println("收到来自服务器的消息:"+br.readLine());
        ps.println("我客户端今天灭了你");

        socket.close();
    }


}
