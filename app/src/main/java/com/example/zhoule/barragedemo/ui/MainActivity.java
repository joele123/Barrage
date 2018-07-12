package com.example.zhoule.barragedemo.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zhoule.barragedemo.R;
import com.example.zhoule.barragedemo.databinding.ActivityMainBinding;
import com.example.zhoule.barragedemo.modle.MainPresenter;

public class MainActivity extends BaseActivity<ActivityMainBinding>{

    ActivityMainBinding binding;

    @Override
    protected ActivityMainBinding createPresener() {
        binding = DataBindingUtil.setContentView(
                this, R.layout.activity_main);
        return binding;
    }

    @Override
    public void initView() {
        binding.setMainPresenter(new MainPresenter(this));
    }

}
