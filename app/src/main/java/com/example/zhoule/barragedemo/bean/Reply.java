package com.example.zhoule.barragedemo.bean;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzh on 2018/7/3.
 */

public class Reply {
    private int code;
    private String msg;
    private String data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    /**
     * 返回数组对象
     *
     * @param clazz IncomeDayResp.class
     * @param <T>   IncomeDayResp
     * @return List<IncomeDayResp>
     */
    public <T> List<T> getDataListBean(Class<T> clazz) {
        try {
            if (data != null) {
                Type type = new TypeToken<ArrayList<JsonObject>>() {
                }.getType();
                ArrayList<JsonObject> jsonObjects = new Gson().fromJson(data, type);
                ArrayList<T> arrayList = new ArrayList<>();
                for (JsonObject jsonObject : jsonObjects) {
                    arrayList.add(new Gson().fromJson(jsonObject, clazz));
                }
                return arrayList;
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
