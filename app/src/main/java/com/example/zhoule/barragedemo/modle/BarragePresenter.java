package com.example.zhoule.barragedemo.modle;

import android.net.Uri;
import android.util.Log;

import com.example.zhoule.barragedemo.R;
import com.example.zhoule.barragedemo.bean.Reply;
import com.example.zhoule.barragedemo.bean.ReplyComment;
import com.example.zhoule.barragedemo.bean.ReplyUser;
import com.example.zhoule.barragedemo.databinding.ActivityBarrageBinding;
import com.example.zhoule.barragedemo.http.HttpUtils;
import com.example.zhoule.barragedemo.ui.BarrageActivity;
import com.example.zhoule.barragedemo.view.TranTextView;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zhoule on 2018/7/11.
 */

public class BarragePresenter {

    private BarrageActivity barrageActivity;
    private ActivityBarrageBinding barrageBinding;

    List<ReplyComment> list;

    public BarragePresenter(BarrageActivity barrageActivity) {
        this.barrageActivity = barrageActivity;
        getBarrageList(1, 0);
        barrageBinding = (ActivityBarrageBinding) barrageActivity.mPresenter;

        barrageBinding.tranView.setIsFinsh2Anim(new TranTextView.isFinsh2Anim() {
            @Override
            public void finish() {

                if (list != null && list.size() > 0) {
                    getBarrageList(1, list.get(list.size() - 1).getTime());
                }
            }
        });

        barrageBinding.playerview.setUrl(barrageActivity, R.raw.aa);
    }


    /**
     * 获取服务器的弹幕
     *
     * @param nid
     * @param time
     */
    public void getBarrageList(int nid, long time) {
        HttpUtils.getInstance().API().getCommentList(nid, time).enqueue(new Callback<Reply>() {
            @Override
            public void onResponse(Call<Reply> call, Response<Reply> response) {

                Reply replyComment = response.body();
                Log.e("-------", response.body().toString());
                show(replyComment);
            }

            @Override
            public void onFailure(Call<Reply> call, Throwable t) {

            }
        });
    }


    public void show(Reply replyComment) {

        list = replyComment.getDataListBean(ReplyComment.class);
        //过滤服务器返回的较少内容的弹幕
        if (list != null && list.size() > 2) {
            barrageBinding.tranView.setMag(list);
        } else {
            getBarrageList(1, 0);
        }
    }
}
