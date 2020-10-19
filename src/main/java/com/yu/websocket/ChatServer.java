package com.yu.websocket;

import javax.websocket.*;

import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import net.sf.json.JSONObject;

/**
 * @ClassName ChatServer
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/9/23 11:21
 */
//@ServerEndpoint("/websocket/{myUserId}")
public class ChatServer {

    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static Vector<Session> room = new Vector<Session>();
    //记录当前在线连接数
    private static int onlineCount = 0;
    //	在线用户
    private static Map<String, Session> userMap = new HashMap<String, Session>();
    private String username;

    /**
     * 用户接入
     * @param session 可选
     */
    @OnOpen
    public void onOpen(Session session,@PathParam(value = "myUserId") String myUserId){

        System.out.println("用户接入userid:"+myUserId);
        System.out.println("用户接入session:==================="+session.toString());
        room.addElement(session);
        userMap.put(myUserId, session);
        System.out.println("userMap的大小==>"+userMap.size());
    }

    /**
     * 接收到来自用户的消息
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message,Session session){
        System.out.println("来自用户的消息message==>"+message);
        System.out.println("session"+session);
        //把用户发来的消息解析为JSON对象
        JSONObject obj = JSONObject.fromObject(message);

//		自己添加有关1对1聊天（20200831）
//		String userName = obj.getString("nickname").toString();
////		用户自己的id
        String myUserId = obj.getString("myUserId").toString();
////		对方id
        String toUserId = obj.getString("toUserId").toString();
        Session toUserSe = userMap.get(toUserId);
        Session myUserSe = userMap.get(myUserId);
        System.out.println("mySession---------------------------"+myUserSe);

        //向JSON对象中添加发送时间
        obj.put("date", df.format(new Date()));
        System.out.println("聊天室用户的数量==>"+room.size());
        //发送消息给远程用户
        toUserSe.getAsyncRemote().sendText(obj.toString());
//        myUserSe.getAsyncRemote().sendText(obj.toString());
        //遍历聊天室中的所有会话
//        for(Session se : room){
//            if(se.equals(toUserSe) || se.equals(myUserSe)) {
//                System.out.println("聊天室中存在toUserSe==>"+toUserSe);
//                obj.put("isSelf", se.equals(session));
//                //发送消息给远程用户(这里可以考虑发送的消息中带有指定的toUser关键字)
//                System.out.println("onMessage--obj==>"+obj);
//                System.out.println("onMessage--session==>"+se.toString());
//                se.getAsyncRemote().sendText(obj.toString());
//            }else {
////				obj.put("isSelf", se.equals(session));
////				se.getAsyncRemote().sendText(obj.toString());
//                System.out.println("---聊天室中无toUserid用户---");
//            }
//            //设置消息是否为自己的
////			obj.put("isSelf", se.equals(session));
////			obj.put("content", "服务端传输的消息");
////			//发送消息给远程用户(这里可以考虑发送的消息中带有指定的toUser关键字)
////			System.out.println("onMessage--obj==>"+obj);
////			System.out.println("onMessage--session==>"+se.toString());
////			se.getAsyncRemote().sendText(obj.toString());
//        }
    }

    /**
     * 用户断开
     * @param session
     */
    @OnClose
    public void onClose(Session session){
        System.out.println("断开连接……用户数"+onlineCount--);
        room.remove(session);
    }

    /**
     * 用户连接异常
     * @param error
     */
    @OnError
    public void onError(Throwable error){
        System.out.println("连接异常  ---onError");
        error.printStackTrace();
    }
    //
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }
    //
    public static synchronized int addOnlineCount() {
        return onlineCount++;
    }



}
