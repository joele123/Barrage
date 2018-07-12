package com.example.zhoule.barragedemo.ui;

import android.databinding.ViewDataBinding;
import android.os.Bundle;


/**
 * Created by zhoule on 2018/7/11.
 */

public abstract class BaseActivity<T extends ViewDataBinding> extends BaseMVVMActivity {


    public T mPresenter;

    protected abstract T createPresener();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = createPresener();
        initView();
        setView();
    }


    public abstract void initView();
}
