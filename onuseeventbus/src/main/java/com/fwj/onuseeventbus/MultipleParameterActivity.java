package com.fwj.onuseeventbus;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by WenJiang on 2015/5/15.
 */
public class MultipleParameterActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册：三个参数分别是，消息订阅者（接收者），接收方法名，事件类


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
