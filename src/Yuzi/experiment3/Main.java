package Yuzi.experiment3;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            // 创建服务端套接字
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("服务端已启动");
            while (true) {
                // 监听客户端套接字，若有客户端连接，则代码不会往下执行，否则会堵塞在此处。
                Socket socket = serverSocket.accept();

                // 开启线程，用于读取客户端发送的信息，并转发给每一个客户端
                new ThreadServer(socket).start();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
