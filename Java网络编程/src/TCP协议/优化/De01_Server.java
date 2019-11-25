package TCP协议.优化;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class De01_Server {
    public static void main(String args[]) throws IOException {

        ServerSocket server = new ServerSocket(12345);
        Socket socket =server.accept(); // 接收客户端请求
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());

        ps.println("欢迎你,客户端");
        System.out.println("收到来自客户端的消息:"+br.readLine());
        ps.println("我服务器晓得了");
        System.out.println("收到来自客户端的消息:"+br.readLine());
        socket.close();

    }
}
