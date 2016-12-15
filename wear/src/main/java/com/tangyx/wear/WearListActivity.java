package com.tangyx.wear;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.WearableListView;

import com.tangyx.wear.adapter.WearListAdapter;
import com.tangyx.wear.utils.SLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangyx on 2016/12/10.
 *
 */

public class WearListActivity extends WearableActivity implements WearableListView.ClickListener{

    private WearableListView mListView;
    private WearListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wear_list);
        mListView = (WearableListView) findViewById(R.id.list_view);
        mListView.setClickListener(this);
        initData();
    }
    /**
     * 初始化数据
     * 模拟数据
     */
    private void initData(){
        List<String> datas = new ArrayList<>();
        for (int m = 0;m<100;m++){
            datas.add("我是WearableListView的Item"+m);
        }
        mAdapter = new WearListAdapter(this,datas);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(WearableListView.ViewHolder viewHolder) {
        SLog.e("-----viewHolder---"+viewHolder);
        String s = (String) viewHolder.itemView.getTag();
        SLog.w("S:"+s);
    }

    @Override
    public void onTopEmptyRegionClick() {
        SLog.e("-----onTopEmptyRegionClick---");
    }
}
