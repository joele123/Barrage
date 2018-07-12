package com.example.zhoule.barragedemo.bean;


/**
 * Created by zzh on 2018/7/3.
 */

public class ReplyComment {
    private long cid;
    private long nid;
    private String msg;
    private long time;
    private ReplyUser user;

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public long getNid() {
        return nid;
    }

    public void setNid(long nid) {
        this.nid = nid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public ReplyUser getUser() {
        return user;
    }

    public void setUser(ReplyUser user) {
        this.user = user;
    }


}
