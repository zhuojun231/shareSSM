package com.yu.javaBasic.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Socket
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/9/30 9:57
 */
public class MyServer {
    /**
     *  发数据：OutputStream
     *  收数据：InputStream
     *  1、建立连接(准备服务)
     *  2、通过socket生成OutputStream、InputStream
     *  3、使用OutputStream、InputStream，发送/接收数据
     *  4、关闭
     */

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream is = null;
        BufferedReader bufferedReader = null;
        OutputStream os = null;
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("服务端连接打开,等待客户端连接");
            accept = serverSocket.accept();
            System.out.println("客户端已连接……");
            //接收客户端传递的数据（InputStream）
            is = accept.getInputStream();
            //带缓冲的字符流(字节流-转换流-字符流)
            bufferedReader = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while((info=bufferedReader.readLine())!=null){
                System.out.println("server端，接收到客户端的数据："+info);
            }
            //服务端作出反馈 发数据给客户端
            os = accept.getOutputStream();
            os.write("你好客户端，我是服务端。。。".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
                if (is != null) is.close();
                if (os != null) os.close();
                if (accept != null) accept.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
