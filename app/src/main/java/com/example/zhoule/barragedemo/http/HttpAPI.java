package com.example.zhoule.barragedemo.http;

import com.example.zhoule.barragedemo.bean.Reply;
import com.example.zhoule.barragedemo.bean.ReplyComment;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zhoule on 2018/7/11.
 */

public interface HttpAPI {

    @GET("getCommentList")
    Call<Reply> getCommentList(@Query("nid") int nid, @Query("time") long time);
}
