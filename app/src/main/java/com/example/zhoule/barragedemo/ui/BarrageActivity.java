package com.example.zhoule.barragedemo.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zhoule.barragedemo.R;
import com.example.zhoule.barragedemo.databinding.ActivityBarrageBinding;
import com.example.zhoule.barragedemo.databinding.ActivityMainBinding;
import com.example.zhoule.barragedemo.modle.BarragePresenter;

public class BarrageActivity extends BaseActivity {

    private ActivityBarrageBinding dataBinding;

    @Override
    protected ViewDataBinding createPresener() {

        dataBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_barrage);
        return dataBinding;
    }

    @Override
    public void initView() {

        dataBinding.setBarragePresenter(new BarragePresenter(this));
    }
}
