package TCP协议.服务器多线程;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Test01_Client {
    public static void main(String args[]) throws IOException {

            /*
            客户端向服务器写字符串(键盘录入),服务器(多线程)将字符串反转后写回,
            客户端再次读取到是反转后的字符串
             */

        Scanner sc = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1",54321);  //创建客户端指定ip地址和端口号

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());

        ps.println(sc.nextLine());  //将字符串写到服务器
        System.out.println("来自服务器已反转:"+br.readLine());  //读出服务器发送的反转后的结果

    }
}
