package com.tangyx.wear;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.DelayedConfirmationView;
import android.view.View;

import com.tangyx.wear.utils.SLog;

/**
 * Created by tangyx on 2016/12/12.
 *
 */

public class DelayedActivity extends WearableActivity implements DelayedConfirmationView.DelayedConfirmationListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delayed);
        //左边错误按钮
        DelayedConfirmationView mCancel = (DelayedConfirmationView) findViewById(R.id.cancel);
        mCancel.setListener(this);
        //设置动画执行时间
        mCancel.setTotalTimeMs(2000);
        mCancel.start();

        //右边正确按钮
        DelayedConfirmationView mOk = (DelayedConfirmationView) findViewById(R.id.ok);
        mOk.setListener(this);
        mOk.setTotalTimeMs(5000);
        mOk.start();
    }

    @Override
    public void onTimerFinished(View view) {
        SLog.e("我已经执行完成："+view);
    }

    @Override
    public void onTimerSelected(View view) {
        SLog.e("你当前的点击的按钮："+view);
        DelayedConfirmationView delayedConfirmationView = (DelayedConfirmationView) view;
        delayedConfirmationView.start();
    }
}
