package com.example.zhoule.barragedemo.modle;

import android.content.Intent;

import com.example.zhoule.barragedemo.ui.BarrageActivity;
import com.example.zhoule.barragedemo.ui.MainActivity;

/**
 * Created by zhoule on 2018/7/11.
 */

public class MainPresenter {

    private MainActivity mainActivity;


    public MainPresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


    /*********************************************点击事件*************************************************/
    //点击按钮
    public void start() {
        mainActivity.startActivity(new Intent(mainActivity, BarrageActivity.class));
    }
}
