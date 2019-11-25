package TCP协议;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class De01_Server {
    public static void main(String args[]) throws IOException {

        ServerSocket server = new ServerSocket(12345);
        Socket socket =server.accept(); // 接收客户端请求

        InputStream is = socket.getInputStream();   //获取客户端输入流
        OutputStream os =socket.getOutputStream();

        os.write("百度一下".getBytes());        //服务器向客户端写出数据

        byte[] arr = new byte[1024];
        int len = is.read(arr);         //读取客户端发来的数据
        System.out.println(new String(arr,0,len));

        //server.close();  服务器不用关
    }
}
