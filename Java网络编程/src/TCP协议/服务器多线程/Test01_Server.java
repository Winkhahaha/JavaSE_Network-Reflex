package TCP协议.服务器多线程;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test01_Server {
    public static void main(String args[]) throws IOException {
        ServerSocket server = new ServerSocket(54321);
        System.out.println("服务器启动-->绑定54321端口");

        while(true){
            Socket socket = server.accept();

            new Thread(){
                @Override
                public void run() {
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintStream ps = new PrintStream(socket.getOutputStream());

                        String line = br.readLine();
                        System.out.println("来自客户端未反转:"+line);
                        line = new StringBuffer(line).reverse().toString(); //反转
                        ps.println(line);   //将反转结果返回给客户端

                        socket.close(); //关闭socket同时会关闭in/outputStream

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
