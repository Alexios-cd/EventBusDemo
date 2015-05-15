package com.fwj.onuseeventbus.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by WenJiang on 2015/5/15.
 */
public abstract class BaseActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initEvent();
        initData();
    }

    /**
     * 初始化控件
     */
    protected abstract void initView() ;

    /**
     * 初始化控件的事情
     */
    protected abstract void initEvent();

    /**
     * 初始化页面数据
     */
    protected abstract  void initData() ;
}
