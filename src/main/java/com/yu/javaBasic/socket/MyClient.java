package com.yu.javaBasic.socket;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName MyClient
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/9/30 10:16
 */
public class MyClient {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        BufferedReader reader = null;
        try {
            socket = new Socket("localhost",8888);
            //发送数据到服务端
             os = socket.getOutputStream();
            os.write("你好服务端，我是客户端。。。".getBytes());
            socket.shutdownOutput();
            //接收服务端的反馈
            is = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = reader.readLine())!=null){
                System.out.println("接收到服务端传递的消息："+info);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (os != null) os.close();
                if (is != null) is.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
