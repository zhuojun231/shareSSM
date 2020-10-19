package com.yu.websocket;

import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.Gson;
import net.sf.json.JSONObject;

/**
 * @ClassName ChatServer2
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/9/24 13:41
 */
@ServerEndpoint("/websocket/{username}")
public class ChatServer2 {
    private static int onlineCount = 0;
    private static Map<String, ChatServer2> clients = new ConcurrentHashMap<String, ChatServer2>();
    private Session session;
    private String username;

    //监听连接
    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session){
        this.username = username;
        this.session = session;
        //在线用户数+1
        addOnlineCount();
        clients.put(username, this);
        System.out.println("已连接……");
        System.out.println("当前在线用户数量："+getOnlineCount());
    }
    //监听关闭
    @OnClose
    public void onClose(){
        clients.remove(username);
        //在线用户数-1
        subOnlineCount();
        System.out.println("有用户退出……");
        System.out.println("当前在线用户数量："+getOnlineCount());
    }

    //发送消息
    @OnMessage
    public void onMessage(String message){
        System.out.println("前台传递过来的消息==>"+message);
        JSONObject jsonTo = JSONObject.fromObject(message);
        //消息内容
        String content = jsonTo.getString("content");
        String myUser = jsonTo.getString("myUserId");
        String msgFlag = jsonTo.getString("msgFlag");
        Map<String,String> contentMap = new HashMap<>();
        contentMap.put("content",content);
        contentMap.put("myUser",myUser);
        contentMap.put("msgFlag",msgFlag);
        //利用 Gson将Map 转成  json字符串
        Gson gson = new Gson();
        String jsonStr = gson.toJson(contentMap);

        if (!jsonTo.get("toUserId").equals("All")){
            sendMessageTo(jsonStr, jsonTo.get("toUserId").toString());
        }else{
            sendMessageAll("给所有人");
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    //1对1消息
    private void sendMessageTo(String message, String To) {
        for (ChatServer2 item : clients.values()) {
            if (item.username.equals(To) )
                item.session.getAsyncRemote().sendText(message);
        }
    }

    //群发消息
    private void sendMessageAll(String 给所有人) {

    }

    //获取在线用户数量
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        ChatServer2.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        ChatServer2.onlineCount--;
    }
}
