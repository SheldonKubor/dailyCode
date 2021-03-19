package com.constantine.daily.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: bio网络编程模型
 * @author: mjh
 * @created: 2021/03/18 19:52
 * @version: V1.0
 */
public class BIOServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6666);
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("服务器启动");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    handler(socket);
                }
            });
        }
    }

    public static void handler(Socket socket) {
        System.out.println("线程信息：{id：" + Thread.currentThread().getId() + ", " +
                "name: " + Thread.currentThread().getName());
        // 用于接收数据
        byte[] bytes = new byte[1024];
        // 通过 socket 获取输入流
        try {
            InputStream inputStream = socket.getInputStream();
            // 循环的读取客户端发送的数据
            while (true) {
                System.out.println("进行通信线程信息：{id：" + Thread.currentThread().getId() + ", " +
                        "name: " + Thread.currentThread().getName());
                int read = inputStream.read(bytes);
                if (read != -1) {
                    // 说明还可以读
                    // 输出客户端发送的数据
                    System.out.println(new String(bytes, 0, read));
                } else {
                    // 读取完毕
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭连接");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}