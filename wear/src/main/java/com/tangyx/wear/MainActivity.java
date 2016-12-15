package com.tangyx.wear;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.wearable.activity.ConfirmationActivity;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.view.View;
import android.widget.TextView;

import com.tangyx.wear.utils.SLog;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends WearableActivity implements View.OnClickListener{

    private static final SimpleDateFormat AMBIENT_DATE_FORMAT =
            new SimpleDateFormat("HH:mm", Locale.US);

    private BoxInsetLayout mContainerView;
    private TextView mTextView;
    private TextView mGridViewPager;
    private TextView mCard;
    private TextView mDelayedConfirmationView;
    private TextView mQuit;
    private TextView mClockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAmbientEnabled();

        mContainerView = (BoxInsetLayout) findViewById(R.id.container);
        mTextView = (TextView) findViewById(R.id.text);
        mGridViewPager = (TextView) findViewById(R.id.grid);
        mCard = (TextView) findViewById(R.id.card);
        mDelayedConfirmationView = (TextView) findViewById(R.id.delayed);
        mQuit = (TextView) findViewById(R.id.quit);
        mClockView = (TextView) findViewById(R.id.clock);
        mTextView.setOnClickListener(this);
        mCard.setOnClickListener(this);
        mGridViewPager.setOnClickListener(this);
        mDelayedConfirmationView.setOnClickListener(this);
        mQuit.setOnClickListener(this);
    }

    @Override
    public void onEnterAmbient(Bundle ambientDetails) {
        super.onEnterAmbient(ambientDetails);
        SLog.e("--->onEnterAmbient");
        updateDisplay();
    }

    @Override
    public void onUpdateAmbient() {
        super.onUpdateAmbient();
        SLog.e("--->onUpdateAmbient");
        updateDisplay();
    }

    @Override
    public void onExitAmbient() {
        SLog.e("--->onExitAmbient");
        updateDisplay();
        super.onExitAmbient();
    }

    private void updateDisplay() {
        if (isAmbient()) {
            mContainerView.setBackgroundColor(getResources().getColor(android.R.color.black));
            mTextView.setTextColor(getResources().getColor(android.R.color.white));
            mGridViewPager.setTextColor(getResources().getColor(android.R.color.white));
            mCard.setTextColor(getResources().getColor(android.R.color.white));
            mDelayedConfirmationView.setTextColor(getResources().getColor(android.R.color.white));
            mQuit.setTextColor(getResources().getColor(android.R.color.white));
            mClockView.setText(AMBIENT_DATE_FORMAT.format(new Date()));
            mClockView.setTextColor(Color.WHITE);
        } else {
            mContainerView.setBackground(null);
            mTextView.setTextColor(getResources().getColor(android.R.color.black));
            mGridViewPager.setTextColor(getResources().getColor(android.R.color.black));
            mCard.setTextColor(getResources().getColor(android.R.color.black));
            mDelayedConfirmationView.setTextColor(getResources().getColor(android.R.color.black));
            mQuit.setTextColor(getResources().getColor(android.R.color.black));
            mClockView.setTextColor(Color.BLACK);
        }
    }


    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(prefix, fd, writer, args);
        SLog.e(prefix+":"+fd+":"+writer+":"+args);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.text:
                intent.setClass(this,WearListActivity.class);
                startActivity(intent);
                break;
            case R.id.grid:
                intent.setClass(this,GridViewPagerActivity.class);
                startActivity(intent);
                break;
            case R.id.card:
                intent.setClass(this,CardActivity.class);
                startActivity(intent);
                break;
            case R.id.delayed:
                intent.setClass(this,DelayedActivity.class);
                startActivity(intent);
                break;
            case R.id.quit:
                intent.setClass(this, ConfirmationActivity.class);
                intent.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE,
                        ConfirmationActivity.OPEN_ON_PHONE_ANIMATION);
                intent.putExtra(ConfirmationActivity.EXTRA_MESSAGE,"应用已打开");
                startActivity(intent);
                break;
        }
    }
}
