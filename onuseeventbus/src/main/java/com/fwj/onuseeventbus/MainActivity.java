package com.fwj.onuseeventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button bt_singleParameter;
    private Button bt_MultipleParameter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniView();
        initEvent();
    }


    private void iniView() {
        bt_singleParameter = (Button) findViewById(R.id.bt_SingleParameter);
        bt_MultipleParameter = (Button) findViewById(R.id.bt_MultipleParameter);
    }

    private void initEvent() {
        bt_singleParameter.setOnClickListener(this);
        bt_MultipleParameter.setOnClickListener(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_SingleParameter:
                startActivity(new Intent(MainActivity.this, SingleParameterActvity.class));
                break;
            case R.id.bt_MultipleParameter:
                startActivity(new Intent(MainActivity.this, MultipleParameterActivity.class));
                break;
        }
    }
}
