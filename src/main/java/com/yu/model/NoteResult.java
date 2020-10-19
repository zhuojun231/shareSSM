package com.yu.model;

/**
 *  status：我们设置状态 1表示登陆成功 0表示用户名已被占用 2 表示密码错误
 *  msg:   当用户登陆不成功 ，返回对应信息
 *  data: 用于保留数据 ，方便以后cookie的使用
 * @ClassName NoteResult
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/9/14 14:24
 *  用于返回结果
 */
public class NoteResult {
    private int status;    //状态
    private String msg;   //消息
    private Object data;   //数据

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
