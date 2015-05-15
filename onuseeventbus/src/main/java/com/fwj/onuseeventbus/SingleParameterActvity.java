package com.fwj.onuseeventbus;

import android.util.Log;
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
     *  当EventBus注册时只有一个参数（EventBus.getDefault().register(this)）
     * 代表本类为消息订阅者（接受者）
     *
     * 在EventBus中，使用约定来指定事件订阅者以简化使用。
     * 即所有事件订阅都都是以onEvent开头的函数，具体来说，
     * 函数的名字是onEvent，onEventMainThread，onEventBackgroundThread，onEventAsync这四个
     * 当事件发布者通过post方法发布一个消息之后，本类相应的处理方法会做出相应的处理
     * /

     /**
      *PostThread：事件的处理在和事件的发送在相同的进程，所以事件处理时间不应太长，
      *不然影响事件的发送线程，而这个线程可能是UI线程。对应的函数名是onEvent。
      *
      * @param event
      */
    public void onEvent(BaseEvent event) {
        Log.d("Event","onEvent");
        // 接收收藏事件通知，同步处理收藏数字
        if (event instanceof SingleEvent) {
            // 即时更新收藏的数量(从sqlite中取得收藏数量)
            tv_single.setText("这是由EventBus Post过来的数据。");
        } else {

        }
    }

    /**
     * MainThread: 事件的处理会在UI线程中执行。事件处理时间不能太长，
     * 这个不用说的，长了会ANR的，对应的函数名是onEventMainThread。
     * @param event
     */
    public void onEventMainThread(BaseEvent event) {
        Log.d("Event","onEventMainThread");
        tv_single.setText("onEventMainThread。");
    }

    /**
     * 事件的处理会在一个后台线程中执行，对应的函数名是onEventBackgroundThread，
     * 虽然名字是BackgroundThread，事件处理是在后台线程，但事件处理时间还是不应该太长，
     * 因为如果发送事件的线程是后台线程，会直接执行事件，如果当前线程是UI线程，
     * 事件会被加到一个队列中，由一个线程依次处理这些事件，如果某个事件处理时间太长，会阻塞后面的事件的派发或处理。
     * @param event
     */
    public void onEventBackgroundThread(BaseEvent event) {
        Log.d("Event","onEventBackgroundThread");
        tv_single.setText("onEventBackgroundThread。");
    }

    /**
     * 事件处理会在单独的线程中执行，主要用于在后台线程中执行耗时操作，
     * 每个事件会开启一个线程（有线程池），但最好限制线程的数目
     * @param event
     */
    public void onEventAsync(BaseEvent event) {
        Log.d("Event","onEventAsync");
        tv_single.setText("onEventAsync。");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_single:
                EventBus.getDefault().post(new SingleEvent());
                break;
        }
    }

}

