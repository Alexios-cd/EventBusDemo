package com.fwj.onuseeventbus;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fwj.onuseeventbus.base.BaseActivity;
import com.fwj.onuseeventbus.event.BaseEvent;
import com.fwj.onuseeventbus.event.SingleEvent;

import de.greenrobot.event.EventBus;

/**
 * Created by WenJiang on 2015/5/15.
 */
public class SingleParameterActvity extends BaseActivity implements View.OnClickListener {


    private Button bt_single;
    private TextView tv_single;

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_singleparameter);
        bt_single = (Button) findViewById(R.id.bt_single);
        tv_single = (TextView) findViewById(R.id.tv_single);
    }

    @Override
    protected void initEvent() {
        bt_single.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    /**
     * 当EventBus注册时只有一个参数（EventBus.getDefault().register(this)）
     * 代表本类为消息订阅者（接受者）
     * 在EventBus中，使用约定来指定事件订阅者以简化使用。
     * 即所有事件订阅都都是以onEvent开头的函数，具体来说，
     * 函数的名字是onEvent，onEventMainThread，onEventBackgroundThread，onEventAsync这四个
     * 当事件发布者通过post方法发布一个消息之后，本类相应的处理方法会做出相应的处理
     * @param event
     */
    public void onEvent(BaseEvent event) {
        // 接收收藏事件通知，同步处理收藏数字
        if (event instanceof SingleEvent) {
            // 即时更新收藏的数量(从sqlite中取得收藏数量)
            tv_single.setText("这是由EventBus Post过来的数据。");
        } else{

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_single:
                EventBus.getDefault().post(new SingleEvent());
                break;
        }
    }

}

