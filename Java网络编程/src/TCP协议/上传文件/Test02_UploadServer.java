package TCP协议.上传文件;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Test02_UploadServer {
    public static void main(String args[]) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("服务器启动-->绑定12345端口");

        while (true) {
            Socket socket = server.accept();
            new Thread() {
                @Override
                public void run() {
                    try {
                        InputStream is = socket.getInputStream();
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        PrintStream ps = new PrintStream(socket.getOutputStream());

                        String fileName = br.readLine();
                        System.out.println("来自客户端的文件:" + fileName);

                        File dir = new File("upload");  //父级目录
                        dir.mkdir();
                        File file = new File(dir, fileName);     //封装成文件对象

                        if (file.exists()) {
                            ps.println("文件已经存在!");
                            socket.close();     //关闭socket,结束通讯
                            return;
                        } else {
                            ps.println("开始上传!");
                        }

                        // 从网络读取数据写出文件到本地
                        FileOutputStream fos = new FileOutputStream(file);
                        byte[] arr = new byte[8192];
                        int len;

                        while ((len = is.read(arr)) != -1) {
                            fos.write(arr, 0, len);
                        }
                        fos.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

        }
    }
}
