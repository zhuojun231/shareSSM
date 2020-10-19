package com.yu.model.chatEntity;

import java.util.Date;

/**
 * @ClassName Message
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/10/19 9:46
 */
public class Message {
    private int id;
    private String fromUser;
    private String toUser;
    private String content;
    /**
     * 整型	值为0时：这条消息为普通的文本消息，content为消息内容，服务器转发时会给发出者发一份
     * 		值为-1时：这条消息为普通文本类通知消息，content为消息内容，服务器转发时不会发给发出者
     * 		值为1时：这条消息为群组消息，content为消息内容，服务器转发时不会发给发出者，因为发送对象含有发出者自身
     * 			注意：当值为1时，to数组不全为发送对象的id，0为groupId
     * 		值为2时：请注意，值为2的情况并不会出现在前端发送消息的类型中，这严格来说是值为1的一种特殊情况。这条消息为群组消息，只被记录于数据库，to为群组的Id，服务端真正进行的操作是向群组的每一个用户发送一条相同的类型为1消息，而这个类型的消息仅仅用于记录用户和群组之间有这样的消息，以便于查询用户在群组里的聊天记录。
     * 		值为3时：这条消息为上线通知，content无意义，仅为记录性内容，服务器转发不给发出者
     * 		值为4时：这条消息为下线通知，content无意义，仅为记录性内容，不给发出者发
     * 		值为5时：这条消息为好友申请，content为附加消息(申请结果将以普通消息格式返回)，不给发出者发
     * 		值为6时：这条消息为加群邀请，content为群的id
     */
    private int type;
    private Date sendTime;//消息发送时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", fromUser='" + fromUser + '\'' +
                ", toUser='" + toUser + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", sendTime=" + sendTime +
                '}';
    }
}
