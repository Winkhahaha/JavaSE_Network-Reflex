package TCP协议.上传文件;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Test02_UploadClient {

    public static void main(String args[]) throws IOException {
        File file = getFile();

        Socket socket = new Socket("127.0.0.1", 12345);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());

        ps.println(file.getName());
        String result = br.readLine();      //读取存在or不存在的结果
        System.out.println("来自服务端的提示:" + result);
        if ("文件已经存在!".equals(result)) {
            System.out.println("该文件已经存在,请不要重复上传!");
            socket.close();
            return;
        }
        // 不存在则准备上传:
        FileInputStream fis = new FileInputStream(file);
        byte[] arr = new byte[8192];
        int len;
        while ((len = fis.read(arr)) != -1) {
            ps.write(arr, 0, len);
        }

        fis.close();
        socket.close();

        //
    }

    private static File getFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个文件路径:");

        while (true) {
            String line = sc.nextLine();
            File file = new File(line);
            if (!file.exists()) {
                System.out.println("文件路径不存在!请重新录入:");
            } else if (file.isDirectory()) {
                System.out.println("禁止文件夹路径!请重新录入:");
            } else {
                return file;
            }
        }
    }
}
