package TCP协议;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class De01_Client {
    public static void main(String args[]) throws IOException {
        Socket socket = new Socket("127.0.0.1",12345);

        InputStream is = socket.getInputStream();   //获取客户端输入流
        OutputStream os =socket.getOutputStream();

        byte[] arr = new byte[1024];
        int len = is.read(arr);         //读取服务器发来的数据
        System.out.println(new String(arr,0,len));

        os.write("知道了".getBytes());     //客户端向服务器写数据

        socket.close();
    }


}
